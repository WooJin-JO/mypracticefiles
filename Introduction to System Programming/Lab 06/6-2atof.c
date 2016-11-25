#include <stdio.h>
#include <ctype.h>

/* atof: convert string s to double */
double atof(char s[]) {
	double val, power, pow, digit;
	int i, sign;

	for (i = 0; isspace(s[i]); i++)
		;
	sign = (s[i] == '-') ? -1 : 1;
	if (s[i] == '+' || s[i] == '-')
		i++;
	for (val = 0.0; isdigit(s[i]); i++)
		val = 10.0 * val + (s[i] - '0');
	if (s[i] == '.')
		i++;
	for (power = 1.0; isdigit(s[i]); i++) {
		val = 10.0 * val + (s[i] - '0');
		power *= 10.0;
	}
	val = sign * val / power;

	if (s[i] == 'e' || s[i] == 'E'){
		i++;
	}
	if (s[i] == '+' || s[i] == '-'){
		if(s[i] == '-'){
			pow = 0.1;
		}
		else if(s[i] == '+'){
			pow = 10.0;
		}
		i++;
	}
	for(digit = 0; isdigit(s[i]); i++){
		digit = 10.0 * digit + (s[i] - '0');
	}
	for(;digit > 0; digit--){
		val *= pow;
	}
	return val;
}


int main() {
	char s[10] = "-3.14e+2";
	printf("%g\n", 2 * atof(s));
}
