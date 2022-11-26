#from input_graph import graph

def dfs(graph, start):
    visited, stack = set(), [start]
    traversal = []
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            print(vertex)
            traversal.append(vertex)
            
            visited.add(vertex)
            stack.extend(graph[vertex] - visited)
    #return visited
    return traversal

#print(dfs(graph, 'A')) # {'E', 'D', 'F', 'A', 'C', 'B'}
