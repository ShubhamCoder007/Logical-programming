#include<stdio.h>

int s = 0;
int st = -1;
int e = -1;

void sum(int a[], int start, int end){
	int i = start; 
	int sum = 0;
	for(; i < end; i++)
		sum += a[i];
	if(s < sum){
		s = sum;
		st = start;
		e = end;
	}
}

void sumArray(int a[], int start, int end){
	if(start >= end)
		return NULL;
	
	sum(a, start, end);
	
	sumArray(a, start + 1, end);
	sumArray(a, start, end - 1);
	
}
	
	

int main()
{
	int a[] = {-4,-6,2,-2,8,3,-2,11,-1};
	
	sumArray(a, 0, 9);
	
	printf("Sum is : %d start: %d end: %d\n",s,st,e);
	
	for(; st < e; st++)
		printf("%d ",a[st]);
	
	return 0;
}
	