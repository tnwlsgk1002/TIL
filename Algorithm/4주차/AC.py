'''
문제 : AC
해결방법 : deque
시간 오래 잡아먹은 부분 : if문 쓸 때 반례 찾기
'''

import sys
import copy
from collections import deque

input = sys.stdin.readline

T = int(input())
pArray = deque()
xArray = deque()
answer = []

for i in range(T) :
    # 함수 입력
    p = input().rstrip('\n')
    p = p.replace('RR', '')
    p = deque(p)
    # 배열에 들어있는 수의 갯수
    n = int(input())
    # 배열[x1, x2, ... xn]
    x = input().rstrip('\n')
    x = deque(x[1:-1].split(','))
    if n == 0 :
        x = []
    pArray.append(p)
    xArray.append(x)

for p, x in zip(pArray, xArray) :
    temp = copy.copy(x)
    is_reversed = False
    for fx in p :
        if fx == 'R' :
            if is_reversed  : is_reversed = False
            else : is_reversed  = True
        else :
            if temp :
                if is_reversed == False :    
                    temp.popleft()
                else :
                    temp.pop()
            else :
                temp = 'error'
                break
                
    if temp != 'error' and is_reversed :
        temp = reversed(temp)
    answer.append(temp)

for a in answer :
    if a == 'error' :
        print(a)
    else :
        print(str(list(a)).replace(' ', '').replace('\'', ''))
