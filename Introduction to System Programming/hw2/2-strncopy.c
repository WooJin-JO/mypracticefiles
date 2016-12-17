#include <string.h>

char *strncopy(char *s, char *t, int n){
	int i;
	char *temp;
	temp = s; 
	for (i = 0; i < n; i++){
		*s++ = *t++;
	}
	if(strlen(t) < n){
		*s++;
	}
	*s = '\0';
	return temp;
}
