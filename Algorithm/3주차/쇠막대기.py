'''
문제 : 여러 개 쇠막대기 => 레이저 절단. 괄호 표현을 입력받으면 잘려진 쇠막대기 갯수 출력 
해결 방안 : 스택
- '('이면 stack에 넣기
- 레이저이면(='()') pop 후 stack의 열린 괄호만큼 answer에 더하기
- 그 외의 닫힌 괄호일 때(='))') pop 후 answer+1
시간 : 1시간 반 소요 - 스택 이용 여부는 알았으나 문제 이해 & 아이디어 도출에서 오래 걸림
개선 방안 : 문제 빨리 이해하기
'''

import sys

batch = input()
# 고민의 흔적.............
#stick = 0 # 막대기 갯수
#rager = 0
stack = [] # 현재 쇠막대기 & 괄호

answer = 0

for idx, cnt in enumerate(batch) :
    if cnt == '(' : # 막대기의 시작 혹은 레이저 시작
        stack.append(cnt)
    else : # )
        prev = batch[idx-1]
        if prev == '(' : # 레이저 끝인 경우
            stack.pop()
            answer += len(stack)
        else : # 막대기 끝인 경우
            stack.pop()
            answer+=1
print(answer)
