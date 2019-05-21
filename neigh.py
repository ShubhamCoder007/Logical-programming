'''Neighbours and New Year Party (100 Marks)
In the XYZ society, the neighbours hate each other for their attitude. Various activities are organized in the society for Welcoming the New Year. The tickets were provided to each house with an integer written on it. Some got tickets with positive integers and some got tickets with negative integers. In the evening, people had to carry their tickets to the club house where the eligible ones will get the exciting gifts. The eligibility of winning the gift depends on the maximum sum which can be formed from the tickets numbers keeping in mind that neighbours hate each other. Since the neighbours hate each other, the two cannot be together in the list of maximum sum. 
'''


def get_pair(t, N):
    if len(t) == 0:
        return

    s = None
    cor = []

    for i in range(N):
        for j in range(N):
            if i == j or abs(i - j) == 1 or t[i] == 0 or t[j] == 0:
                continue
            if s == None or t[i] + t[j] > s:
                s = t[i] + t[j]
				cor.append(t[i])
				cor.append(t[j])
            
    for i in t:
        if i > s:
            return [i]

    return cor
            



def main():
 T = int(input())
 while T>0:
  N = int(input())
  t = input()
  t = t.split()
  t = [int(i) for i in t]
	
  l = get_pair(t, N)
  if len(l) == 1:
   print(l[0])
  else:
   s = str(l[-1])+str(l[-2])
   print(s)

  T = T - 1

main()

