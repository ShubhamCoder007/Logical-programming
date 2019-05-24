//Find all possible triplets which adds to zero

#include<stdio.h>
#include<stdbool.h>

int rec[10][3];
int fill = 0;

bool check(int i, int j, int k, int N){
	if(fill == 0)
		return false;
	
	if(i == j || i == k || j == k || i == N - 1 || j == N - 1 || k == N - 1)
		return true;
	
	int a = 0;
	for(; a < fill; a++){
		if(rec[a][0] == i && rec[a][1] == j && rec[a][2] == k)
			return true;
	}
	return false;
}

void triplets(int a[], int N, int i, int j, int k){
	if(check(i, j, k, N))
		return;
	
	if(a[i] + a[j] + a[k] == 0){
		rec[fill][0] = i;
		rec[fill][1] = j;
		rec[fill][2] = k;
		fill++;
	}
	
	triplets(a, N, i, j, k + 1);
	triplets(a, N, i, j + 1, k);
	triplets(a, N, i + 1, j, k);
}

int main()
{
	int a[] = {-1,0,1,2,-1,-4};
	triplets(a, 6, 0, 1, 2);
	
	printf("Number of triplets: %d\n",fill);
	
	int i = 0;
	for(; i < fill; i++)
		printf("\npos(%d,%d,%d) [%d %d %d]",rec[i][0],rec[i][1],rec[i][2],a[rec[i][0]],a[rec[i][1]],a[rec[i][2]]);
	
	return 0;
}