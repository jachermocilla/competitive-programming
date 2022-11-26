graph2 = {'A': set(['B', 'C']),
         'B': set(['E', 'D', 'A']),
         'C': set(['F', 'A']),
         'D': set(['B']),
         'E': set(['F', 'B']),
         'F': set(['E', 'C'])}




graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

print(graph)
