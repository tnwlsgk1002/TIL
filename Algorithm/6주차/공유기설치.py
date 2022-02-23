import sys

input = sys.stdin.readline
[N, C] = list(map(int, input().split()))
array = [int(input()) for _ in range(N)]

array.sort()

start = 1
end = array[-1] - array[0]

answer = 0

while (start <= end) :
    mid = (start + end) // 2
    count = 1 # 현재 공유기 설치 갯수
    current = array[0] # 현재 공유기 설치하는 집 좌표
    for i in range(1, len(array)) :
        if array[i] - current >= mid :
            count += 1
            current = array[i]
    
    if count >= C : # 공유기 갯수가 같거나 더 많이 설치할 수 있으면 -> 거리 키우기
        start = mid + 1
        answer = mid
        
    else : # 공유기 갯수가 더 작으면 -> 거리 늘이기
        end = mid - 1
        
print(answer)
