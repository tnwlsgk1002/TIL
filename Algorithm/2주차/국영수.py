import sys

input = sys.stdin.readline
N = int(input())
student = dict()

for _ in range(N) :
    name, lang, eng, math = input().split()
    student[name] = list(map(int, (lang, eng, math)))

answer = sorted(student.items(), key=(lambda x:(-x[1][0], x[1][1], -x[1][2], x[0])), reverse=False)

for key, _ in answer :
    print(key)
