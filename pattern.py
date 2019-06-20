'''Generate the pattern 
[1, 1, 1, 1, 1, 1, 2]
[3, 2, 2, 2, 2, 2, 2]
[3, 3, 3, 3, 3, 3, 4]
[5, 4, 4, 4, 4, 4, 4]
'''

import math

N = int(input('Enter the value of N: '))
rows = N - 1
l = []

mid_series = [i for i in range(1,N)]

for i in range(0,N+2):

	if i == 0:	
		a = []
		a.append(i + 1)
		j = 0
		mid = math.floor((1 + N)/2)
		while j < N - 3:
			a.append(i + mid)
			j = j + 1
		a.append(i + N)	
		
		l.append(a)
		continue
		
	
	if i == N + 1:
		a = []
		j = 0
		while j < rows:
			if j < rows/2:
				a.append(2)
			else:
				a.append(N-1)
			j = j + 1
			
		l.append(a)
		continue
		
		
	l.append(mid_series)
	


#transposing to generate required output
out = []
for i in range(0, N - 1):
	lis = []
	for j in range(0, len(l)):
		lis.append(l[j][i])
	out.append(lis)
	
	
	
#displaying	the resultant pattern
for i in out:
	print(i)
			
		
				
	