import sys
from collections import deque

input = sys.stdin.readline

# n : 트럭 갯수, w : 다리의 길이, L : 다리의 최대 하중
[n, w, L] = list(map(int, input().split(' ')))

nList = deque(map(int, input().split(' '))) # 건너지 못한 트럭

answer = 0

bridge = deque([0]*w) # 다리 위에 있는 트럭
idx = 0

summary = 0

while True :
    answer+=1
    bTruck = bridge.popleft()
    summary-=bTruck
    if len(nList) !=0 :
        if summary+nList[0] <= L :
            nTruck = nList.popleft()
            bridge.append(nTruck)
            summary+=nTruck
        else :
            bridge.append(0)
        
    if not bridge :
        break
        
print(answer)
