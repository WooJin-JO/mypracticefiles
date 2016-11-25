#include <stdio.h>
int palindrome(char *a, int b);

int main(){
	printf("%d\n", palindrome("C", 1));
	printf("%d\n", palindrome("civic", 5));
	printf("%d\n", palindrome("kayak", 5));
	printf("%d\n", palindrome("madam", 5));
	printf("%d\n", palindrome("racecar", 7));
	printf("%d\n", palindrome("radar", 5));
	printf("%d\n", palindrome("rotator", 7));
	printf("%d\n", palindrome("step on no pets", 15));
	printf("%d\n", palindrome("no lemon no melon", 17));
}
int palindrome(char *a, int b){
	for(int i = 0; i < b; i++){
		if(*a == *(a+b-1-i)){
			a++;
			b--;
		}
		else{
			return 0;
		}
		return 1;
	}
}

/*int palindrome(char *s, int l){
	int i;
	int ans = 1;
	for(i = 0; i*2 <= l; i++){
		ans &= (*(s+i) == *(s+l-i-1));
	}
	return ans;	
}*/

/*int palindrome(char *s, int l){
	int i;
	int ans = 1;
	for(i = 0; i*2 <= l; i++){
		ans &= (*(s+i) == *(s+l-i-1));
		if(!ans){
			return ans;
		}
	}
	return ans;	
}*/