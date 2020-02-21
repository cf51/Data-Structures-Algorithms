package F28DA_CW2;

import java.util.Scanner;

import org.jgrapht.alg.shortestpath.*;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;

public class FlyingPlannerMainPartA {

	public static void main(String[] args) {
		
		Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		DijkstraShortestPath<String, DefaultWeightedEdge> g = new DijkstraShortestPath<String, DefaultWeightedEdge>(graph); 
		
		GraphPath<String, DefaultWeightedEdge> journey; 
		String airport2; 

		String v1 = "Edinburgh";
		String v2 = "Heathrow";
		String v3 = "Dubai";
		String v4 = "Sydney";
		String v5 = "Kuala Lumpur"; 

		// add the vertices
		graph.addVertex(v1); //Edinburgh
		graph.addVertex(v2); //Heathrow 
		graph.addVertex(v3); //Dubai
		graph.addVertex(v4); //Sydney
		graph.addVertex(v5); //Kuala Lumpa 


		// add edges to create a circuit
		DefaultWeightedEdge edge = new DefaultWeightedEdge(); 

		//Adding edge for Edinburgh - Heathrow (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v1, v2);
		graph.setEdgeWeight(edge,  80); //Using the price as the weight of the edge
		edge = graph.addEdge(v2, v1);
		graph.setEdgeWeight(edge,  80); //Using the price as the weight of the edge 

		//Adding edge for Heathrow - Dubai (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v2, v3);
		graph.setEdgeWeight(edge, 130); //Using the price as the weight of the edge 
		edge = graph.addEdge(v3, v2);
		graph.setEdgeWeight(edge, 130); //Using the price as the weight of the edge 


		//Adding edge for Heathrow - Syndey (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v2, v4); 
		graph.setEdgeWeight(edge, 570); //Using the price as the weight of the edge 
		edge = graph.addEdge(v4, v2); 
		graph.setEdgeWeight(edge, 570); //Using the price as the weight of the edge 


		//Adding edge for Dubai - Kuala Lumpa (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v3, v5); 
		graph.setEdgeWeight(edge,  170); //Using the price as the weight of the edge 
		edge = graph.addEdge(v5, v3);
		graph.setEdgeWeight(edge,  170); //Using the price as the weight of the edge 


		//Adding edge for Dubai - Edinburgh (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v3, v1);
		graph.setEdgeWeight(edge,  190);  //Using the price as the weight of the edge 
		edge = graph.addEdge(v1, v3);
		graph.setEdgeWeight(edge,  190);  //Using the price as the weight of the edge 


		//Adding edge for Kuala Lumpa - Sydney (as it's bidirectional I have added an edge for both ways)
		edge = graph.addEdge(v5, v4);
		graph.setEdgeWeight(edge,  150);    //Using the price as the weight of the edge
		edge = graph.addEdge(v4, v5);
		graph.setEdgeWeight(edge,  150);    //Using the price as the weight of the edge 
		
		Scanner scan = new Scanner(System.in); 

		System.out.println("-- toString output");
		System.out.println(graph.toString());
		
		System.out.println(" _____________________________________");
		System.out.println("                                     ");
		System.out.println(" Flight                          Cost");
		System.out.println(" _____________________________________");
		System.out.printf(String.format("%-30s| %-15s", "    " + v1 + " <-> " + v2, " £80"));
		System.out.println("");
		System.out.printf(String.format("%-30s| %-15s", "    " + v2 + "  <-> " + v3, "£130"));
		System.out.println("");
		System.out.printf(String.format("%-30s| %-15s", "    " + v2 + "  <-> " + v4, "£570"));
		System.out.println("");
		System.out.printf(String.format("%-30s| %-15s", "      " + v3 + "   <-> " + v5, "£170"));
		System.out.println("");
		System.out.printf(String.format("%-30s| %-15s", "      " + v3 + "   <-> " + v1, "£190"));
		System.out.println("");
		System.out.printf(String.format("%-30s| %-15s", " " + v5 + " <-> " + v4, "£150"));
	
		System.out.println("");
		
		System.out.println("");
		System.out.println("The following airports are used:");
		System.out.println("      " + v1);
		System.out.println("      " + v2);
		System.out.println("      " + v3);
		System.out.println("      " + v4);
		System.out.println("      " + v5);
		System.out.println();
		System.out.println("Please enter the start airport");
		String start = scan.nextLine(); 
		System.out.println("Please enter the destination airport");
		String destination = scan.nextLine(); 
		journey = g.getPath(start, destination); 
		System.out.println("The shortest path is " + journey + " which will cost £" + g.getPathWeight(start, destination));
		// Code is from HelloJGraphT.java of the org.jgrapth.demo package (start)
	
	}

}


