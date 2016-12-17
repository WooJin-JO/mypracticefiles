char *strncat(char *s, char *t, int n){
    char *temp = s;

    while (*s != '\0'){
    	s++;
    }
    while (n > 0){
    	n--;
        if (!(*s++ = *t++)){
        	return temp;
        }
    }
    *s = '\0';
    return temp;
}
