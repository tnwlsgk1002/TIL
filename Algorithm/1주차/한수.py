def is_hansu(num) : # 한수 판단
    n1 = num // 100
    n3 = num % 10
    n2 = (num - 100 * n1 - n3) // 10
    n = n2 - n1
    if (n3-n2) == n :
       return True
    return False

N = int(input())
answer = 0

if (0 < N) and (N < 100) : # 한 자리수 or 두 자리수
    answer = N
elif (99 < N) and (N < 1001) : # 세 자리 수
    answer+=99
    if 110 < N :
        for i in range(111, N+1) :
            if is_hansu(i) :
               answer+=1
            if 999 < i : # 1000 or 1001은 제외
                break
print(answer)
