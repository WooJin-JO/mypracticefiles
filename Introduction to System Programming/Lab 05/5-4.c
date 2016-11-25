#include <stdio.h>

int double_sum_for(int n) {
	int sum = 0;
	int i = 0;
	if(n > 0){
		for(i = n; i <= 2*n; i++){
			sum += i;
		}
	} else {
		for(i = n; 2*n <= i; i--){
			sum += i;
		}
	}
	return sum;
}

int double_sum_while(int n) {
	int sum = 0;
	int i = n;
	if(n > 0){
		while(i <= 2*n){
			sum += i;
			i++;
		}
	} else {
		while(2*n <= i){
			sum += i;
			i--;
		}
	}
	return sum;
}

int main() {
	printf("%d\n", double_sum_for(0)); /* 0 */
	printf("%d\n", double_sum_for(1)); /* 3 */
	printf("%d\n", double_sum_for(3)); /* 18 */
	printf("%d\n", double_sum_for(-3)); /* -18 */
	printf("%d\n", double_sum_while(0)); /* 0 */
	printf("%d\n", double_sum_while(1)); /* 3 */
	printf("%d\n", double_sum_while(3)); /* 18 */
	printf("%d\n", double_sum_while(-3)); /* -18 */
}