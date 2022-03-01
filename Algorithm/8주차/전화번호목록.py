import sys
input = sys.stdin.readline

t = int(input())
for i in range(t) :
    n = int(input())
    phoneNumberList = [input().rstrip() for _ in range(n)]
    phoneNumberList.sort()
    check = phoneNumberList[0]
    for i in range(1, len(phoneNumberList)) :
        current = phoneNumberList[i]
        if current.startswith(check) :
            print("NO")
            break
        else:
            check = current
    else :
        print("YES")