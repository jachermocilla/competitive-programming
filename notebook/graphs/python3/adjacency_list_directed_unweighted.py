#modified from https://www.pythonpool.com/adjacency-list-python/

from dfs import dfs

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
    for node in node_list:
        if not node in adj_list.keys(): 
            temp=set()
            temp.add([])
            adj_list[node1] = temp
    for node in adj_list:
        print(node, " ---> ", [i for i in adj_list[node]])

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

#Printing the graph
graph()

#Printing the adjacency list
print(adj_list)

print(dfs(adj_list,0))
