import sys

input = sys.stdin.readline

N = int(input())
NList = list(map(int, input().split()))
M = int(input())

dp = [[0]*N for _ in range(N)]
# dp[x][y] -> x부터 y까지의 숫자가 팰린드롬인지 아닌지

# 1일 경우
for i in range(N) :
    dp[i][i] = 1

# 2일 경우
for i in range(N-1) :
    if NList[i] == NList[i+1] :
        dp[i][i+1] = 1

# 3 이상일 경우
for i in range(2, N) :
    for j in range(N-i) :                
        if NList[j] == NList[i+j] and dp[j+1][i+j-1] :
            dp[j][i+j] = 1
        
for i in range(M) :
    S, E = map(int, input().split())
    print(dp[S-1][E-1])
