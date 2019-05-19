'''WIN or LOSE 
A new fighting game has become popular. There are N number of villains with each having some strength. There are N players in the game with each having some energy. The energy is used to kill the villains. The villain can be killed only if the energy of the player is greater than the strength of the villain. 


Maxi is playing the game and at a particular time wants to know if it is possible for him to win the game or not with the given set of energies and strengths of players and villains. Maxi wins the game if his players can kill all the villains with the allotted energy.

Input Format
The first line of input consist of number of test cases, T.

The first line of each test case consist of number of villains and player, N.

The second line of each test case consist of the N space separated strengths of Villains.

The third line of each test case consist of N space separated energy of players. '''


def result(hero, vil, N):
    f = True
    for i,j in zip(hero, vil):
        if j > i:
            f = False
            break
    if f:
        return "WIN"

    hero.sort()
    vil.sort()
    
    vil.reverse()
    
    while N >= 0:
        flag = False
        for i in range(N):
            for j in range(N):
                if flag:
                    break
                
                if hero[j] < vil[i]:
                    continue

                else:
                    hero.remove(hero[j])
                    vil.remove(vil[i])
                    
                    if len(hero) == 0:
                        return "WIN"

                    flag = True
                
            
            if flag:
                break
        if i == N and flag == False:
            return 'LOSE'
        N = N - 1

    if len(hero) == 0:
        return "WIN"
    return "LOSE"


def main():
    T = int(input())

    while T > 0:
        N = int(input())
        vil = input()
        hero = input()
        vil = vil.split()
        hero = hero.split()
        vil = [int(i) for i in vil]
        hero = [int(i) for i in hero]
        print(result(hero,vil,N))
        T = T - 1

main()