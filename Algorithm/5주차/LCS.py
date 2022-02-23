import sys

input = sys.stdin.readline

string1 = input().rstrip()
string2 = input().rstrip()

array = [[0]*(len(string2)+1) for _ in range(len(string1)+1)]

for i in range(1, len(string1)+1) :
    for j in range(1, len(string2)+1) :
        if string1[i-1] == string2[j-1] :
            array[i][j] = array[i-1][j-1] + 1
        else :
            array[i][j] = max(array[i][j-1], array[i-1][j])

print(array[-1][-1])
            
