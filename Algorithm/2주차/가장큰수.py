def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    
    numbers.sort(key=lambda x : x*3, reverse=True) # number가 1000 미만임을 고려
    
    answer = numbers[0]
    if len(numbers) > 1 :
        for n in numbers[1:] :
            answer+=n
    answer = str(int(answer)) # 반레 '0000..' 방지
    return answer
