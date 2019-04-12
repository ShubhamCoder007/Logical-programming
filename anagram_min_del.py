num = int(input())

def multiple_copies(s1,s2):
    #alphabet dictionary initialised to zero
    alp_s1 = {chr(s):0 for s in range(97,123)}
    alp_s2 = {chr(s):0 for s in range(97,123)}
    
    #calculating the frequencies of every letter, populating with occurence
    for i in s1:
        if i in alp_s1.keys():
            alp_s1[i] = alp_s1[i] + 1
            
    for i in s2:
        if i in alp_s2.keys():
            alp_s2[i] = alp_s2[i] + 1
            
    #order of letter arrangement
    alp = list(alp_s1.keys())
    
    #extracting only the frequencies
    alp_s1 = list(alp_s1.values())
    alp_s2 = list(alp_s2.values())
    
    total = 0
    for i,j,k in zip(alp_s1,alp_s2,alp):
        #if there are multiple copies add the num of deletions and delete
        if abs(i-j) > 0:
            l = 0
            if i > j: 
                
                while l < abs(i-j):
                    if k in s1:
                        s1.remove(k)
                        total = total + 1
                    l = l + 1
                    
            if j > i:
                
                while l < abs(i-j):
                    if k in s2:
                        s2.remove(k)
                        total = total + 1
                    l = l + 1
        
    return total,s1,s2
    

def anag(s1,s2):
    #string to list of characters
    s1 = [i for i in s1]
    s2 = [i for i in s2]
    
    tot, s1, s2 = multiple_copies(s1,s2)

    for i,c in enumerate(s1):
        if c not in s2:
            tot = tot + 1
            s1.pop(i)

    for i,c in enumerate(s2):
        if c not in s1:
            tot = tot + 1
            s2.pop(i)
            
    return tot
    
#for the test cases times
while num != 0:
    s1 = input()
    s2 = input()
    print(anag(s1,s2))
    num = num - 1


                