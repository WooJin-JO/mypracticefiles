#include <stdio.h>

void escape(char s[], char t[]) {
    int i, j;

    for (i = j = 0; t[i] != '\0'; i++)
        switch (t[i]) {
            case '\n':
                s[j++] = '\\';
                s[j++] = 'n';
                break;
            case '\t':
                s[j++] = '\\';
                s[j++] = 't';
                break;
            default:
                s[j++] = t[i];
        }
    s[j] = '\0';     
}

int main() {
    char u[10] = "ERI\tCA\nHY";
    char v[10];
    printf("Before:\n%s\n", u);
    escape(v, u);
    printf("After:\n%s\n", v);
}