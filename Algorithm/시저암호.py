def solution(s, n):
    answer = ''

    for i in range(len(s)) :
        if s[i] == ' ' :
            answer += ' '
        elif 65 <= ord(s[i]) and ord(s[i]) <= 90 :
            temp = ord(s[i])+n
            if temp > 90 :
                answer += chr(temp - 26)
            else :
                answer += chr(temp)
        else :
            temp = ord(s[i])+n
            if temp > 122 :
                answer += chr(temp - 26)
            else :
                answer += chr(temp)
    return answer