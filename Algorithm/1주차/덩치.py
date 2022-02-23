N = int(input())
group = []
for i in range(N) :
    W, H = map(int, input().split())
    group.append([W, H])

answer = [1]*N

for i in range(N):
    for j in range(i+1, N) :
        if (group[i][0] < group[j][0]) and (group[i][1] < group[j][1]) :
            answer[i]+=1
        elif (group[i][0] > group[j][0]) and (group[i][1] > group[j][1]) :
            answer[j]+=1
            
for rank in answer :
    print(rank, end=' ')
