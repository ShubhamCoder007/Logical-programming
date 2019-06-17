a = [1,2,3,4,5,6]
k = 2

def rotate(a, k):
	
	index = 0
	i = k
	while index < k:
		temp = a[-i]
		a[-i] = a[index]
		a[index] = temp
		i = i - 1
		index = index + 1
		
	return a

print('array: ',a)
print(rotate(a,k))	