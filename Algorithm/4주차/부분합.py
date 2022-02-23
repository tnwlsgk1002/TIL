import sys

input = sys.stdin.readline

[N, S] = list(map(int, input().split(' ')))
array = list(map(int, input().split(' ')))

ldx = 0
rdx = 1
result = array[ldx]
answer = len(array)

if sum(array) < S :
    print(0)
else :
    while rdx < N :
        result += array[rdx]
        if result >= S :
            if rdx - ldx < answer :
                answer = rdx - ldx
            while result >= S :
                result -= array[ldx]
                ldx += 1
                if result >= S :
                    if rdx - ldx < answer :
                        answer = rdx - ldx
                   
        rdx += 1
    print(answer+1)
