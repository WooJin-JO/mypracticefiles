#include <stdio.h>

static char daytab[2][13] = {
	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
	{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
};

/* day_of_year: set day of year from manth & day */
int day_of_year(int year, int month, int day) {
	int i, leap;
	leap = (year%4 == 0 && year%100 != 0) || year%400 == 0;
	for (i = 1; i < month; i++)
		day += daytab[leap][i];
	if(year < 0){
		fprintf(stderr, "need to modify the year.\n");
		return -1;
	}
	if(month < 1 || month > 12){
		fprintf(stderr, "need to modify the month.\n");
		return -1;
	}
	if(!(0 <day & day <= daytab[leap][month])){
		fprintf(stderr, "need to modify the day.\n");
	}
	return day;
}

/* month_day: set month, day from day of year */
void month_day(int year, int yearday, int *pmonth, int *pday) {
	int i, leap;

	leap = (year%4 == 0 && year%100 != 0) || year%400 == 0;
	if(year < 0){
		fprintf(stderr, "need to modify the year.\n");
		*pmonth = -1;
		*pday = -1;
		return;
	}
	if(!(0 < yearday & yearday <= (leap ? 366 : 365))){
		fprintf(stderr, "need to modify the day.\n");
		*pmonth = -1;
		*pday = -1;
		return;
	}
	for (i = 1; yearday > daytab[leap][i]; i++)
		yearday -= daytab[leap][i];
	*pmonth = i;
	*pday = yearday;
}

/* month_name: return name of n-th month */
char *month_name(int n) {
	static char *name[] = {
		"Illegal month",
		"January", "February", "March",
		"April", "May", "June",
		"July", "August", "September",
		"October", "November", "December"
	};

	return (n < 1 || n > 12) ? name[0] : name[n];
}

int main(void){
	int y, yd, m, d, *pm = &m, *pd = &d;
	printf("Day of Year\n");
	printf("%d.%d.%d:%d\n", 0,5,5,day_of_year(0,5,5));
	printf("%d.%d.%d:%d\n", 2015,12,31,day_of_year(2015,12,31));
	printf("%d.%d.%d:%d\n", 2016,11,17,day_of_year(2016,11,17));
	printf("%d.%d.%d:%d\n", 2016,12,31,day_of_year(2016,12,31));
	printf("! NEED EXCEPTION !\n");
	int day1 = day_of_year(-1,8,15);
	int day2 = day_of_year(2016,-1,31);
	int day3 = day_of_year(-3,13,39);
	if(day1 != -1){
		printf("%d.%d.%d:%d\n", -1,8,15,day1);
	}
	if(day2 != -1){
		printf("%d.%d.%d:%d\n", 2016,-1,31,day2);
	}
	if(day3 != -1){
		printf("%d.%d.%d:%d\n", -3,13,39,day3);
	}
	printf("+++++++++++\n");
	printf("Month Day\n");
	y = 0; yd = 126;month_day(y,yd,pm,pd);
	printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	y = 2015; yd = 365;month_day(y,yd,pm,pd);
	printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	y = 2016; yd = 322;month_day(y,yd,pm,pd);
	printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	y = 2016; yd = 366;month_day(y,yd,pm,pd);
	printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	printf("! NEED EXCEPTION !\n");
	y = -1; yd = 227;month_day(y,yd,pm,pd);
	if(*pm != -1 && *pd != -1){
		printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	}
	y = 2015; yd = 366;month_day(y,yd,pm,pd);
	if(*pm != -1 || *pd != -1){
		printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	}
	y = -3; yd = 404;month_day(y,yd,pm,pd);
	if(*pm != -1 || *pd != -1){
		printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
	}

	return 1;
}