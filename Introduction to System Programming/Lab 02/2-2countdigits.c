#include <stdio.h>

/* count digits, white space, others */
int main() {
    int c, i, star, nwhite, nother;
    int ndigit[10];

    nwhite = nother = 0;
    for (i = 0; i < 10; ++i)
        ndigit[i] = 0;
	
    while ((c = getchar()) != EOF)
        if (c >= '0' && c <= '9')
            ++ndigit[c-'0'];
        else if (c == ' ' || c == '\n' || c == '\t')
            ++nwhite;
        else
            ++nother;

    
    for (i = 0; i < 10; ++i){
        printf("%d ", i);
        for(star = 0; star < ndigit[i]; ++star){
            printf("%c", '*');
        }
        printf("\n");
    }
    printf("w ");
    for(star =0; star < nwhite; ++star){
        printf("%c", '*');
    }
    printf("\n");

    printf("o ");
    for(star = 0; star < nother; ++star){
        printf("%c", '*');
    }
}