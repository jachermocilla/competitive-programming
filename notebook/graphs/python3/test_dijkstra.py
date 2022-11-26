from adjacency_list_directed_weighted import *
from sssp_dijkstra import dijkstra 

#read the graph from stdin
read_graph()

#Printing the graph
init_graph()

#Printing the adjacency list
#print(adj_list)

#run some algo on the graph
#NOTE: make sure to change to start node based on the input
#print(dfs(adj_list,'0'))
print(dijkstra('0',nodelist,adj_list))


