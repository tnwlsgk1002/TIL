import sys
input = sys.stdin.readline
N = int(input())
answer = [int(input()) for i in range(N)]
answer.sort()
for a in answer :
    print(a)
