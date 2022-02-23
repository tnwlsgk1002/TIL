import sys
input = sys.stdin.readline

N = int(input())
teste = list(map(int, input().split()))
k = int(input())

left = 0
right = len(teste)//k
distance = right

answer = []

for i in range(k) :
    temp = teste[left:right]
    temp.sort()
    answer.extend(temp)
    left+=distance
    right+=distance
    
for a in answer :
	print(a, end=' ')
