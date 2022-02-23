import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**6)

def dfs(v, color) :
    visited[v] = color
    for i in graph[v] : # v와 인접한 정점 방문
        if visited[i] == 0 : # 방문하지 않았을 때
            if not dfs(i, -color) : # 다른 컬러로 dfs -> False -> False 반환
                return False
        elif visited[i] == visited[v] : # 이미 방문한 인접한 정점인데 color가 같으면
            return False
    return True
  
K = int(input())

for _ in range(K) :
  V, E = map(int, input().split(' '))
  graph = {x : [] for x in range(1, V+1)} # 빈 그래프 생성
  visited = [0] * (V + 1) # 방문한 정점
  for _ in range(E) :
    [a, b] =map(int, input().split(' '))
    graph[a].append(b)
    graph[b].append(a)

  isBipartiteGraph = True
  
  for i in range(1, V+1) :
      if visited[i] == 0 :
          isBipartiteGraph = dfs(i, 1)
          
          if not isBipartiteGraph :
              break

  if isBipartiteGraph :
    print('YES')
  else :
    print('NO')
