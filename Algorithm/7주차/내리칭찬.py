import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**6)

def dfs(graph, v) :
    visited[v] = 1
    for i in graph[v] :
        if visited[i] == 0 :
            praise[i]+=praise[v]
            dfs(graph, i)
        
    return visited

n, m = map(int, input().split(' '))

graph = {i : [] for i in range(1, n+1)}
temp = list(map(int, input().split(' ')))

for i in range(n) :
    if temp[i] == -1 :
        continue
    graph[temp[i]].append(i+1)

praise = [0 for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

for _ in range(m) :
    i, w = map(int, input().split(' '))
    praise[i]+= w
    
dfs(graph, 1)

praise.pop(0)
print(*praise)
