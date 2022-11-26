#modified from https://www.pythonpool.com/adjacency-list-python/

from dfs_directed import dfs
from input_graph import graph1

adj_list = {}
nodelist = []

def add_node(node):
    if node not in nodelist:
        nodelist.append(node)
    else:
        print("Node ",node," already exists!")

def add_edge(node1, node2):
    if node1 in nodelist and node2 in nodelist:
        if not node1 in adj_list.keys(): 
            temp=set()
            temp.add(node2)
            adj_list[node1] = temp
        else:
            adj_list[node1].add(node2)
    else:
        print("Nodes don't exist!")

def graph():
    for node in nodelist:
        if not node in adj_list.keys(): 
            temp=set()
            #temp.add()
            adj_list[node] = temp
    #can be commented out, only for debugging 
    for node in adj_list:
        print(node, " ---> ", [i for i in adj_list[node]])

#https://www.pythonpool.com/adjacency-list-python/
#Adding nodes
add_node(0)
add_node(1)
add_node(2)
add_node(3)
add_node(4)
#Adding edges
add_edge(0,1)
add_edge(1,2)
add_edge(2,3)
add_edge(3,0)
add_edge(3,4)
add_edge(4,0)

#https://www.educative.io/answers/how-to-implement-depth-first-search-in-python
#add_node('A')
#add_node('B')
#add_node('C')
#add_node('D')
#add_node('E')
#add_node('F')
#
#add_edge('A','C')
#add_edge('A','B')
#
#add_edge('B','E')
#add_edge('B','D')
#add_edge('C','F')
#add_edge('E','F')
#Printing the graph
graph()

#Printing the adjacency list
#print(adj_list)


#print(dfs(adj_list,0))
print(graph1)
print(dfs(graph1,'A'))
