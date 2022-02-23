def solution(A):
    A.sort()
    idx, a = 0, 0
    for idx, a in enumerate(A) :
        if idx+1 != a :
            return a-1
    return a+1 # 마지막이 누락이 되었을 경우 방지
