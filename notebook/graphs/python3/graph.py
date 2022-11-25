class AdjacentNode:
    def __init__(self, label):
        self.label = label
        self.next = None

class Edge:
    def __init__(self, label, weight, is_directed):
        self.label = label
        self.weight = weight
        self.is_directed = is_directed

class Graph:
    def __init__(self, vertex_count):
        self.vertex_count = vertex_count
        self.graph = [None] * self.vertex_count

    def add_edge(self, source, dest):
        node = AdjacentNode(dest)
        node.next = self.graph[source]
        self.graph[source] = node
        
        node = AdjacentNode(source)
        node.next = self.graph[dest]
        self.graph[dest] = node

    def print(self):
        for i in range(self.vertex_count):
            print("Vertex " + str(i) + ":", end="")
            temp = self.graph[i]
            while temp:
                print(" -> {}".format(temp.label), end="")
                temp = temp.next
            print(" \n")

if __name__ == "__main__":
    vertex_count = 4

        # Create graph and edges
    graph = Graph(vertex_count)
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(0, 3)
    graph.add_edge(1, 2)

    graph.print()
