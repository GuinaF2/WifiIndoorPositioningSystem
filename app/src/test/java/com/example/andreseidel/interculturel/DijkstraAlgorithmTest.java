package com.example.andreseidel.interculturel;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

// Agora usando pacotes em minúsculo:
import com.example.andreseidel.interculturel.dijkstra.model.Vertex;
import com.example.andreseidel.interculturel.dijkstra.model.Edge;
import com.example.andreseidel.interculturel.dijkstra.model.Graph;
import com.example.andreseidel.interculturel.dijkstra.engine.DijkstraAlgorithm;

public class DijkstraAlgorithmTest {

    @Test
    public void testShortestPathCalculation() {
        List<Vertex> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        Vertex locationA = new Vertex("Node_A", "Corridor_Start");
        Vertex locationB = new Vertex("Node_B", "Stairs");
        Vertex locationC = new Vertex("Node_C", "Lab_01");

        nodes.add(locationA);
        nodes.add(locationB);
        nodes.add(locationC);

        edges.add(new Edge("Edge_1", locationA, locationB, 10));
        edges.add(new Edge("Edge_2", locationB, locationC, 15));
        edges.add(new Edge("Edge_3", locationA, locationC, 50));

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

        dijkstra.execute(locationA);
        List<Vertex> path = dijkstra.getPath(locationC);

        assertNotNull(path, "O caminho não deveria ser nulo");
        assertEquals(3, path.size(), "O caminho deveria ter 3 nós");
    }
}