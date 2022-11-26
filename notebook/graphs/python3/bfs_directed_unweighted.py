
visited = [] # List for visited nodes.
queue = []     #Initialize a queue
path = []

def bfs(graph, start): #function for BFS
    visited.append(start)
    queue.append(start)

    while queue:          # Creating loop to visit each node
        node = queue.pop(0) 
        path.append(node)
        print (node, end = " ") 

        for adjacent in sorted(graph[node]):
            if adjacent not in visited:
                visited.append(adjacent)
                queue.append(adjacent)

    return path
