'''
문제 : 기탓줄 6개줄 -> 1~P번 프랫, 손가락을 최소한으로 움직이기
해결 방안 : 스택
현재 손가락이 잡고 있는 기타줄을 스택에 넣고
for문을 돌면서 확인하기.
시간 : 1시간 소요 - 아이디어는 빨리 생각났으나 for문의 else와 같은 예외, 혹은 수정이 오래 걸림
개선 : if-else문이 난잡함
'''

import sys
input = sys.stdin.readline
N, P = map(int, input().split(' '))
melody = [list(map(int, input().split(' '))) for i in range(N)]
melody.sort(key=lambda x : x[0]) # 기탓줄만 정렬
answer = 0
stack = [] # 현재 손가락이 잡고 있는 기타줄
for gs, p in melody :
    if stack :
        n = len(stack)
        for i in range(n) :
            stack_gs, stack_p = stack[-1]
            if gs == stack_gs :
                if p < stack_p :
                    stack.pop()
                    answer+=1
                elif p == stack_p :
                    break
                else :
                    stack.append([gs, p])
                    answer+=1
                    break
            else :
                stack.append([gs, p])
                answer+=1
                break
        else :
            if not stack:
                stack.append([gs, p])
                answer+=1
    else :
        stack.append([gs, p])
        answer+=1

print(answer)
