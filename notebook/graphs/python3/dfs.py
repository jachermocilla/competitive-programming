#from input_graph import graph

def dfs(graph, start):
    visited, stack = set(), [start]
    path = []
    while stack:
        vertex = stack.pop()
        print(vertex)
        if vertex not in visited:
            path.append(vertex)
            visited.add(vertex)
            stack.extend(graph[vertex] - visited)
    #return visited
    return path

#print(dfs(graph, 'A')) # {'E', 'D', 'F', 'A', 'C', 'B'}
