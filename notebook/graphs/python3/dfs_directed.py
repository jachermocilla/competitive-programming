#https://www.cs.cmu.edu/~15451-f17/lectures/lec11-DFS-strong-components.pdf


i = 0
num = {}
mark = {}

def dfs(graph, start):
    def dfs_util(node):
        global i 
        i = i+1
        num[node] = i
        mark[node] = 1
        if node is not None:
            print(node)
        for adjacent in graph[node]:
            #print(node,"-->",adjacent)
            if num[adjacent] == 0:              #tree edge
                #print("tree edge")
                dfs_util(adjacent)
            #elif num[adjacent] > num[node]:     #forward edge
                #print("forward edge")
            #elif mark[adjacent] == 0:           #cross edge       
                #print("cross edge")
            #else:                               #back edge
                #print("back edge")
        mark[node] = 0
             
    for node in graph.keys():
        num[node] = 0
        mark[node] = 0

    for node in graph.keys():
        if num[node] == 0:
            dfs_util(node)

