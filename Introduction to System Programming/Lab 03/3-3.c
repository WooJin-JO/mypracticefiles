#include <stdio.h>

/*void bin(unsigned x){
  short size = sizeof(x)*8;
  char o[sizeof(x)*8] = {'0'};
  o[size+1]='\0';
  int i;
  for(i=0;i<=size;i++){
    o[size-i] = (x>>i&1)+48;
  }
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

/* getbits: get n bits from position p */
unsigned getbits(unsigned x, int p, int n) {
    /* 32bit 컴퓨터 기준
                  what we want ! ->   _ ____
    x       =  1110 1010 1010 1010 1011 1010 1011 1110
    x >> 8  =  0000 0000 1110 1010 1010 1010 1011 1010
    ~0      =  1111 1111 1111 1111 1111 1111 1111 1111
    ~0 << 5 =  1111 1111 1111 1111 1111 1111 1110 0000
    ~(~0 << 5)
            =  0000 0000 0000 0000 0000 0000 0001 1111
    (x >> 8) & ~(~0 << 5)
            =  0000 0000 1110 1010 1010 1010 1011 1010
             & 0000 0000 0000 0000 0000 0000 0001 1111
             -----------------------------------------
               0000 0000 0000 0000 0000 0000 0001 1010
    */
  return (x >> (p+1-n)) & ~(~0 << n);
}

unsigned setbits(unsigned x, int p, int n, unsigned y) {
  /*
  p = 3, n = 5
  mask            = 0000 0000 0000 0000 0000 0000 0001 1111
  mask<<p(3)      = 0000 0000 0000 0000 0000 0000 1111 1000
  ~(mask<<p)      = 1111 1111 1111 1111 1111 1111 0000 0111
  x               = 1111 0000 1111 0000 1111 1010 1111 0111
  x&(~(mask<<p))  = 1111 0000 1111 0000 1111 1010 0000 0111

  y               = 0000 0000 0000 0000 1010 1010 1010 1010
  mask            = 0000 0000 0000 0000 0000 0000 0001 1111
  y&mask          = 0000 0000 0000 0000 0000 0000 0000 1010
  (y&(mask))<<p   = 0000 0000 0000 0000 0000 0000 0101 0000
  
  (x&(~(mask<<p))) | (y&(mask))<<p
                  = 1111 0000 1111 0000 1111 1010 0000 0111
                   +0000 0000 0000 0000 0000 0000 0101 0000
                   ----------------------------------------
                    1111 0000 1111 0000 1111 1010 0101 0111
  */
  unsigned mask = ~(~0 << n);
  return (x&(~(mask<<p))) | (y&(mask))<<p;
}

int main() {
  unsigned a = 0xF0F0FAF7;
  unsigned b = 0xAAAA;
  bin(setbits(a,3,5,b));
  return 0;
}