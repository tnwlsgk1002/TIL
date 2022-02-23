'''
문제 :
- N개의 탑, 높이 입력
- 꼭대기에서 왼쪽으로 발사
- 가장 먼저 만나는 단 하나의 탑에서만 수신
힌트 :
- 스택 활용
풀이 :
- 오른쪽 탑부터 왼쪽으로 탐색
- 자신보다 큰 탑이 나오면 스택에서 모두 빼고 큰 탑을 스택에 넣는다.
후기 :
시간초과로 못 풀어서 힌트보고 푼 문제. 추후 다시 풀어볼 것. 
'''

import sys

input = sys.stdin.readline

N = int(input())
tower = list(map(int, input().split(' ')))
answer = [0 for _ in range(N)]
stack = [] # 수신이 가능한 탑

for idx, top in zip(range(N-1, -1, -1), tower[::-1]) :
    # 오른쪽 탑부터 탐색,
    # 자신보다 큰 탑이 나오면 스택에서 모두 뺀다.
    # 큰 탑을 스택에 넣는다.
    while stack and top > stack[len(stack)-1][1] :
        jdx, _ = stack.pop()
        answer[jdx] = idx+1
    stack.append([idx, top])
        
print(*answer)
