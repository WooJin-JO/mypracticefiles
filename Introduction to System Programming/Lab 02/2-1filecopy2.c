#include <stdio.h>

/* copy input to output; 2nd version */
int main() {
    int c;
    int prev = 0;
	while ((c = getchar()) != EOF){
		if (!(prev == ' ' && c == ' '))
			putchar(c);
		prev = c;
	}
}