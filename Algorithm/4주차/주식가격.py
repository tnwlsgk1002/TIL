def solution(prices):
    answer = [0]*len(prices)
    stack = []
    popList = []
    for idx, cnt_price in enumerate(prices) :
        if stack :
            for jdx, [zdx, prev_price] in enumerate(stack) :
                answer[zdx]+=1
                if prev_price > cnt_price : # 가격이 떨어짐
                    popList.append(jdx)
            else :
                while popList :
                    stack.pop(popList.pop())
        stack.append([idx, cnt_price])
    return answer
