#include <stdio.h>
#include <ctype.h>
#include "calc.h"

/* getop: get next operator or numeric operand */
int getop(char s[]) {
	int i, c;

	if (!isdigit(s) && s != '.')
		return s;

	if(digit(s)){
		return NUMBER;
	}
	else{
		return s;
	}

	return NUMBER;
}