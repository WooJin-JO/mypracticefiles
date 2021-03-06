#include <stdio.h>
#include <string.h>
#define MAXLEN 1000
#define ALLOCSIZE 10000

static char allocbuf[ALLOCSIZE]; /* storage for alloc */
static char *allocp = allocbuf; /* next free position */

char *alloc(int n) {
	if (allocbuf + ALLOCSIZE - allocp >= n) { /* it fits */
		allocp += n;
		return allocp - n; /* old p */
	}
	else /* not enough room */
		return NULL; /* return 0; */ 
}

/* readline: read line into s, return length */
int readline(char *s, int lim) {
	int c, i;

	i = 0;
	while (--lim > 0 && (c = getchar()) != EOF && c != '\n'){
		*(s++) = c;
		i++;
	}
	if (c == '\n'){
		*(s++) = c;
		i++;
	}
	*s = '\0';
	return i;
}

int readlines(char *lineptr[], int maxlines) {
	int len, nlines;
	char *p, line[MAXLEN];

	nlines = 0;
	while ((len = readline(line, MAXLEN)) > 0)
		if (nlines >= maxlines || (p = alloc(len)) == NULL)
			return -1;
		else {
			line[len-1] = '\0';
			strcpy(p, line);
			lineptr[nlines++] = p;
		}
	return nlines;
}

void writelines(char *lineptr[], int nlines) {
	int i;

	while (nlines-- > 0)
		printf("%s\n", *lineptr++);
	/*
	for (i = 0; i < nlines; i++)
		printf("%s\n", lineptr[i]);
	*/
}
