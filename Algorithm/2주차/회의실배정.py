import sys
input = sys.stdin.readline

N = int(input())
schedule = [list(map(int, input().split())) for i in range(N)]
schedule = sorted(schedule, key=lambda x : (x[1], x[0])) # 종료시간 -> 시작시간

start1, end1 = schedule[0] # 기준
answer = 1

for start2, end2 in schedule[1:] :
    if end1 <= start2 :
        answer+=1
        start1, end1 = start2, end2
    
print(answer)
