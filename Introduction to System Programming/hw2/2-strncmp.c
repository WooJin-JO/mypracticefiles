int *strncmp(char *s, char *t, int n){
	int i = 0;
	while(i < n){
		if (*s > *t){
			return 1;
		}else if(*s < *t){
			return -1;
		}else{
			return 0;
		}
		s++;
		t++;
		i++;
	}
	return 0;
}
