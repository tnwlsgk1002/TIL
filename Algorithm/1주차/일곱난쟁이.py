def sum(ages) :
    result = 0
    for age in ages :
        result += age
    return result

ages = []
n = 9

for i in range(n) :
    ages.append(int(input()))

total = sum(ages)
answer = False

for i, age in enumerate(ages) :
    n1 = age
    for j in range(i+1, n) :
        n2 = ages[j]
        if (total-n1-n2) == 100 : # 두 사람이 일곱 난쟁이가 아닐 경우(total - 특정 두명 == 100) 
            answer = True
            break
    if answer :
        break

ages.remove(n1)
ages.remove(n2)

ages = sorted(ages)
for age in ages :
    print(age)
