#include<stdio.h>
int main() {
	float fahr, celsius;
	int lower, upper, step;
	lower = -30;
	upper = 50;
	step = 10;
	
	printf("%3s %4s\n", "F", "C");
	celsius = lower;
	while (celsius <= upper) {
		fahr = celsius * 9/5 + 32;
		printf("%3.0f %6.1f\n", celsius, fahr);
		celsius = celsius + step;
	}
}