#Shubham Banerjee

def replicate_mat(mat):
	for i in range(2,N+1):
		mat.append(mat[-i])
	return mat
	
def central_infect(n,k):
	if k == 0:
		return n
		
	c = int((len(n) + 1 ) / 2)
	d = n[c-1] - 1
	v = [i for i in n[:k]]
	end = [i for i in n[:k]]
	end.reverse()
	for i in range(len(n)-2*k):
		v.append(d)
	for i in end:
		v.append(i)
		
	return v
	
N = int(input('input: '))
n = 2*N - 1
mat = []
mat.append([N for i in range(n)])
if N > 1:
	for i in range(1,N):
		mat.append(central_infect(mat[-1],i))
		
if N > 1:
	mat = replicate_mat(mat)
	
for i in mat:
	print(i)
	