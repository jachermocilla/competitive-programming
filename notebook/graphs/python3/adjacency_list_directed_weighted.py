#modified from https://www.pythonpool.com/adjacency-list-python/
from sys import stdin, stdout


#holds the adjacency list
adj_list = {}

#holds the node list
nodelist = []

def add_node(node):
    if node not in nodelist:
        nodelist.append(node)
    else:
        print("Node ",node," already exists!")

def add_edge(node1, node2, weight):
    if node1 not in nodelist or node2 not in nodelist:
        add_node(node1)
        add_node(node2)

    if node1 in nodelist and node2 in nodelist:
        if not node1 in adj_list.keys(): 
            temp=set()
            temp.add(tuple([node2,weight]))
            adj_list[node1] = temp
        else:
            adj_list[node1].add(tuple([node2,weight]))
    else:
        print("Nodes don't exist!")

def read_graph():
    for line in stdin.readlines():
        if line.startswith("#"):
            continue
        source,dest,weight=line.strip().split()
        #print(u,v)
        add_edge(source,dest,weight)

def init_graph():
    #make sure to add nodes even if there are no outgoing edges
    for node in nodelist:
        if not node in adj_list.keys(): 
            adj_list[node] = set()
    #can be commented out, only for debugging 
    for node in adj_list:
        print(node, " ---> ", [i for i in adj_list[node]])




