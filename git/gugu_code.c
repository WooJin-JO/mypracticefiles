#include <stdio.h>
 
int main(void) {
 
	for(int i = 1 ; i < 20 ; i++)
	{
		for(int j = 1 ; j < 20 ; j++)
		{
			printf(" %d * %d = %d\t", j, i, j*i);
		}
		printf("\n");
	}
 
	return 0;
}
