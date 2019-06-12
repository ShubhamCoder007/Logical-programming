'''Egyptian fraction 
Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
Egyptian Fraction Representation of 6/14 is 1/3 + 1/11 + 1/231
Egyptian Fraction Representation of 12/13 is 1/2 + 1/3 + 1/12 + 1/156 '''



n = float(input('Enter the fraction: '))

f = []
cached = 0
N = n

def egypt(n):
	flag = False
	print('\nn: ',n)
	if n == 0:
		return
		
	if n < 0:
		cached = f.pop()
		print('after pop: ',f)
		flag = True 
		
	num = 1
	inc = 2
	num = num / inc
	
	while num > n:
		if flag:
			cached = 1/cached
			cached = cached + 1
			num = 1/cached
			flag = False
			break
			
		inc = inc + 1
		num = 1/inc
		
		
	f.append(num)
	
	tot = 0
	for i in f:
		tot = tot + i
	print('f, tot: ',f,tot)
	print('net: ',N - tot)
	egypt(N - tot)
	
	
egypt(n)

print('Egyptian fraction: ',f)

	
	