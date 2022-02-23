def diff(p1, p2) :
    if p1 < p2 :
       return p2-p1
    else :
        return p1-p2

def solution(A):
    # P가 1일 경우의 각 구간의 합과 차이
    part = 1
    p1 = sum(A[:1])
    p2 = sum(A[1:])
    min = diff(p1, p2)
    
    # P가 2 이상 일 경우
    for part, a in zip(range(2, len(A)), A[1:]) :
        p1 += a
        p2 -= a
        temp = diff(p1, p2)
        if temp < min :
            min = temp

    return min
