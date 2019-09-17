#printing pattern
# 1
# 2 3
# 4 5 6
# 7 8 9 10
# 7 8 9 10
# 4 5 6
# 2 3
# 1

line = int(input('Enter the lines of pattern: '))
a = []
count = 1

for i in range(1,line):
    temp = []
    for j in range(1,i):
        print(count, end = ' ')
        temp.append(count)
        count = count + 1 
    a.append(temp)
    print('')
    
for i in range(1,len(a)):
    for j in a[-i]:
        print(j, end = ' ')
    print('')