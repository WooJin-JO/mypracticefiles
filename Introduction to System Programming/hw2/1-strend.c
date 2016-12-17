#include <stdio.h>

/* strend: return 1 if the string t occurs at the end of the string s,
           0 otherwise */
int strend(char *s, char *t){
	char *temp;
	while(*s != '\0'){
		s++;
	}
	*t == *temp;
	while(*t != '\0'){
		t++;
	}
	for(--s, --t; *s == *t; --s, --t){
		return 1;
	}
	return 0;
}

int main() {
	printf("%d\n", strend("HanyangERICA", "ERICA"));
	printf("%d\n", strend("HanyangERICAERICA", "ERICA"));
	printf("%d\n", strend("HanyangERICAnsan", "ERICA"));
	printf("%d\n", strend("Hanyang", "ERICA"));
}