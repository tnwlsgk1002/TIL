def solution(X, Y, D):
    answer = (Y - X) // D
    remain = (Y - X) % D
    if remain == 0 :
        return answer
    else :
        return answer+1
