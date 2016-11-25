#include <stdio.h>

void expand(char s[], char t[]) {
    int i, c;
    i = 0;
    for(c = s[0]; c <= s[2]; c++)
        t[i++] = c;
    t[i] = '\0';
}

int main() {
    char u0[10] = "2-7";
    char u1[10] = "3-3";
    char u2[10] = "4-2";
    char v[10];
    printf("Before: %s\n", u0);
    expand(u0, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u1);
    expand(u1, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u2);
    expand(u2, v);
    printf("After: %s\n", v);
}