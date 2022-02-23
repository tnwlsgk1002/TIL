import sys
input = sys.stdin.readline

N = int(input())
k = int(input())

answer = 0
start = 1
end = k

while (start <= end) :
    mid = (start + end) // 2
    n_min = 0
    for i in range(1, N+1) :
        n_min += min(mid//i, N)
    if n_min >= k :
        answer = mid
        end = mid - 1
    else :
        start = mid + 1

print(answer)
