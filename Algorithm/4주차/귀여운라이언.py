'''
문제 : 귀여운 라이언
해결 방법 : 투포인터
보완할 점 : 문제 이해에서 오래 걸림
'''

import sys

input = sys.stdin.readline

[N, K] = list(map(int, input().split(' ')))
dollList = list(input().rstrip('\n').split(' '))

rionList = []

for idx, doll in enumerate(dollList) :
    if doll == '1' :
        rionList.append(idx)

if K > len(rionList) :
    print(-1)
else :
    lidx = 0
    ridx = K-1
    left = rionList[lidx]
    right = rionList[ridx]
    answer = right - left
    while True :
        lidx += 1
        ridx += 1
        if ridx == len(rionList) :
            break
        left = rionList[lidx]
        right = rionList[ridx]
        if right-left < answer :
            answer = right-left
    print(answer+1)
