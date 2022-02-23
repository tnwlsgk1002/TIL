import sys
input = sys.stdin.readline

[N, M, V] = list(map(int, input().split(' ')))
graph = {x : [] for x in range(1, N+1)}
for i in range(M) :
  [a, b] = list(map(int, input().split(' ')))
  graph[a].append(b)
  graph[b].append(a)

# 스택
def dfs(graph, start_node, visited = []) :
  visited.append(start_node)

  graph[start_node].sort()
  for node in graph[start_node] :
    if node not in visited :
      dfs(graph, node, visited)
  return visited


def bfs(graph, start_node) :
  need_visited, visited = [], []
  need_visited.append(start_node)

  while need_visited :
    node = need_visited.pop(0)

    if node not in visited :
      visited.append(node)
      need_visited.extend(graph[node])
    
  return visited

print(*dfs(graph, V))
print(*bfs(graph, V))
