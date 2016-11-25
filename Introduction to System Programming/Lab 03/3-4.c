#include <stdio.h>

/*void bin(unsigned x){
  short size = sizeof(x)*8;
  char o[sizeof(x)*8] = {'0'};
  o[size+1]='\0';
  int i;
  for(i=0;i<=size;i++)o[size-i] = (x>>i&1)+48;
  printf("binary : %s, dec : %u\n",o+1,x);
}*/

void bin(unsigned x){
  const int SIZE = sizeof(x) * 8;
  printf("binary : ");
  for(int i = 0; i < SIZE; ++i){
    if(i % 4 == 0){
      printf(" ");
    }
    printf("%c", (x>>(SIZE-i-1)&1) + 48);
  }
  printf("\n");
  printf("decimal : %u", x);
  printf("\n");
}

unsigned invert(unsigned x, int p, int n){

  /*
  p = 3, n = 5
  mask            = 0000 0000 0000 0000 0000 0000 0001 1111

  x               = 0000 0000 1111 1010 1111 1010 1010 1010
  ~x              = 1111 1111 0000 0101 0000 0101 0101 0101
  mask<<p         = 0000 0000 0000 0000 0000 0000 1111 1000
  ~x&mask<<p      = 0000 0000 0000 0000 0000 0000 0101 0000

  x               = 0000 0000 1111 1010 1111 1010 1010 1010
  ~(mask<<p)      = 1111 1111 1111 1111 1111 1111 0000 0111
  x&~(mask<<p)    = 0000 0000 1111 1010 1111 1010 0000 0010

  ~x&mask<<p | x&~(mask<<p)
                  = 0000 0000 1111 1010 1111 1010 0000 0010
                   +0000 0000 0000 0000 0000 0000 0101 0000
                    ----------------------------------------
                  = 0000 0000 1111 1010 1111 1010 1010 1010
  */

  unsigned mask = ~(~0 << n);
  bin(x);
  bin(~x);
  bin(~(mask<<p));
  bin(~x&mask<<p);
  bin(x&~(mask<<p));
  bin( ~x&mask<<p | x&~(mask<<p) );
  return x;
}

int main() {
  invert(0xFAFAAA,3,5);
  return 0;
}