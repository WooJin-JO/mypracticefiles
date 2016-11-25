#include <stdio.h>

void expand(char s[], char t[]) {
    int i, c, e;
    int checker = 0;
    i = 0;
    c = '0';
    e = '9';
    for(i = 0; s[i] != '\0'; i++){
        if(s[i] == '-'){
            checker = 1;
        } else if(checker == 0){
            c = s[i];
        } else{
            e = s[i];
        }
    }
    if(checker == 0){
        e = c;
    }
    i=0;
    for(;c <= e; c++){
        t[i++] = c;
    }
    t[i] = '\0';
}

int main() {
    char u0[10] = "-";
    char u1[10] = "-3";
    char u2[10] = "4-";
    char u3[10] = "5";
    char v[20];
    printf("Before: %s\n", u0);
    expand(u0, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u1);
    expand(u1, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u2);
    expand(u2, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u3);
    expand(u3, v);
    printf("After: %s\n", v);
}