#include <stdio.h>
#include <string.h>

/* strindex: return index of t in s, -1 if none */
int strindex(char s[], char t[]) {
	int i, j, k;

	for (i = 0; s[i] != '\0'; i++) {
		for (j = i, k = 0; t[k] != '\0' && s[j] == t[k]; j++, k++)
			;
		if (k > 0 && t[k] == '\0')
			return i;
	}
	return -1;
}

/*int strrindex(char s[], char t[]) {
	int i, j, k;
	int result = -1;
	for (i = 0; s[i] != '\0'; i++) {
		for (j = i, k = 0; t[k] != '\0' && s[j] == t[k]; j++, k++)
			;
		if (k > 0 && t[k] == '\0')
			result = i;
	}
	return result;
}*/


int strrindex(char s[], char t[]) {
	int i, j, k;
	int rusult = -1;
	int s_len, t_len;
	s_len = strlen(s);
	t_len = strlen(t);
	for (i = s_len-1; i > -1; i--) {
		for (j = i, k = t_len-1; k > -1 && s[j] == t[k]; j--, k--)
			;
		if (k == -1)
			return j+1;
	}
	return -1;
}

int main(){
	char source[] = "something anything";
	char target[] = "thing";
	strindex(source,target);
	strrindex(source,target);
	printf("%d\n", strindex(source,target));
	printf("%d\n", strrindex(source,target));
}