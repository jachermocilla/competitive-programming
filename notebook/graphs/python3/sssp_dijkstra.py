#https://www.pythonpool.com/dijkstras-algorithm-python/

def dijkstra(current,nodelist,adj_list):
    nodes=tuple(nodelist)
    distances={}
    
    for node in adj_list.keys(): 
        temp={}
        for adjacent_node in adj_list[node]:
            dest = adjacent_node[0];
            weight = int(adjacent_node[1])
            #print(dest,weight)
            temp[dest]=weight
            #print(temp)
        distances[node]=temp
    #print(distances)
    return _dijkstra(current,nodes,distances)




def _dijkstra(current, nodes, distances):
    # These are all the nodes which have not been visited yet
    unvisited = {node: None for node in nodes}

    # It will store the shortest distance from one node to another
    visited = {}
    # It will store the predecessors of the nodes
    currentDistance = 0
    unvisited[current] = currentDistance
    # Running the loop while all the nodes have been visited
    while True:
        # iterating through all the unvisited node
        for neighbour, distance in distances[current].items():
            # Iterating through the connected nodes of current_node (for 
            # example, a is connected with b and c having values 10 and 3
            # respectively) and the weight of the edges
            if neighbour not in unvisited: continue
            newDistance = currentDistance + distance
            if unvisited[neighbour] is None or unvisited[neighbour] > newDistance:
                unvisited[neighbour] = newDistance
        # Till now the shortest distance between the source node and target node 
        # has been found. Set the current node as the target node
        visited[current] = currentDistance
        del unvisited[current]
        if not unvisited: break
        candidates = [node for node in unvisited.items() if node[1]]
        print(sorted(candidates, key = lambda x: x[1]))
        current, currentDistance = sorted(candidates, key = lambda x: x[1])[0]
    return visited

