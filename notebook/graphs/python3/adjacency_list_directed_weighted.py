#https://www.pythonpool.com/adjacency-list-python/
adj_list = {}
nodelist = []

def add_node(node):
    if node not in nodelist:
        nodelist.append(node)
    else:
        print("Node ",node," already exists!")

def add_edge(node1, node2, weight):
    temp = []
    if node1 in nodelist and node2 in nodelist:
        if not node1 in adj_list.keys():
            temp=set()
            temp.add(tuple([node2,weight]))
            adj_list[node1]=temp
        else:
            adj_list[node1].add(tuple([node2,weight]))
    else:
        print("Nodes don't exist!")

def graph():
    for node in adj_list:
        print(node, " ---> ", [i for i in adj_list[node]])

#Adding nodes
add_node(0)
add_node(1)
add_node(2)
add_node(3)
add_node(4)
#Adding edges
add_edge(0,1,2)
add_edge(1,2,2)
add_edge(2,3,4)
add_edge(3,0,5)
add_edge(3,4,3)
add_edge(4,0,1)

#Printing the graph
graph()

#Printing the adjacency list
print(adj_list)
