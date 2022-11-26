from adjacency_list_directed_unweighted import *
from dfs_directed_unweighted import dfs

#read the graph from stdin
read_graph()

#Printing the graph
init_graph()

#Printing the adjacency list
#print(adj_list)

#run some algo on the graph
#NOTE: make sure to change to start node based on the input
#print(dfs(adj_list,'0'))
print(dfs(adj_list,'A'))


