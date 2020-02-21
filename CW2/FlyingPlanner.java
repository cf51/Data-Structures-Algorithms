package F28DA_CW2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.AsUnweightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class FlyingPlanner implements IFlyingPlannerPartB<Airport,Flight>, IFlyingPlannerPartC<Airport,Flight> {

	Graph<Airport, Flight> graph;
	

	public FlyingPlanner() {
		graph = new SimpleDirectedWeightedGraph<Airport, Flight>(Flight.class); 	// Creating new simple directed weighted graph 
	}
	
	/**
	 * Populates the graph with the airports and flights information from a flightreader object. 
	 * @param fr
	 * @returns true if the operation is successful 
	 */
	public boolean populate(FlightsReader fr) {
		
		for(String [] airport : fr.getAirports()) {		// Iterating over the airport from the flight reader 
			graph.addVertex(new Airport(airport));		// Adds vertexes 
		}
		
		for(String[] b : fr.getFlights()) {																// Iterating over the flights from the flight reader 
			graph.addEdge(airport(b[1]), airport(b[3]), new Flight(airport(b[3]), airport(b[1]),b)); 	// Adding the edges, airport departures code, airport arrival code then vice versa 
			graph.setEdgeWeight(airport(b[1]),airport(b[3]), Double.parseDouble(b[5]));					// Setting the edge weight, departure code, arrival code, cost of flight 
		}
		return true;  																	
		}
	

	/**
	 * Populates the graph with the airports and flights information. 
	 * @param airports 
	 * @param flights
	 * @returns true if operation was successful 
	 */
	public boolean populate(HashSet<String[]> airports, HashSet<String[]> flights) {
		
		for(String [] airport : airports) {			// Iterating over the airport from the hash set 
			graph.addVertex(new Airport(airport));  // Adds vertexes 
		}
		
		for(String[] b : flights) {																		// Iterating over the flights from the hashset  
			graph.addEdge(airport(b[1]), airport(b[3]), new Flight(airport(b[3]), airport(b[1]),b));    // Adding the edges, airport departures code, airport arrival code then vice versa
			graph.setEdgeWeight(airport(b[1]),airport(b[3]), Double.parseDouble(b[5]));					// Setting the edge weight, departure code, arrival code, cost of flight 
		}
		return true;  
		
	} 

	
	/**
	 * @param code 
	 * @returns the airport object of the given airport code.
	 */
	public Airport airport(String code) {
		
		Set<Airport> airports = graph.vertexSet(); 			// Creating a set of airports 
		for(Airport airport : airports) {					// Iterating through all the airports
			if (airport.getCode().equals(code)) {			// Checking if the code is equal to the airport(code)
				return airport; 							// Returning the airport 
				}
			}
		return null;	// Else returning null 
	}

	
	/**
	 * @param code
	 * @returns the flight object of the given flight code.
	 */
	public Flight flight(String code) {
		
		Set<Flight> flights = graph.edgeSet(); 				// Creating a set of flights 
		for(Flight flight : flights) {						// Iterating through all the flights
			if (flight.getFlightCode().equals(code)) {		// Checking if the code is equal to the flight(code)
				return flight; 								// Returning the flight 
				}
			}
		return null;	// Else returning null 
	}

	
	/**
	 * @param from 
	 * @param to
	 * @return journey
	 * @throws FlyingPlannerException
	 */
	public Journey leastCost(String from, String to) throws FlyingPlannerException {
		
		DijkstraShortestPath<Airport, Flight> dij = new DijkstraShortestPath<>(graph); 	// Creating new graph using Dijkstra shortest path algorithm 
		Journey journey = new Journey(dij.getPath(airport(from), airport(to))); 		// Creating a new journey from, departure airport to arrival airport
		return journey; 																// Using Dijkstra on the path to get the least cost then returning the journey 
	
	}

	
	/**
	 * @param from 
	 * @param to
	 * @return a least connections flight journey from one airport (airport code) to another
	 * @throws FlyingPlannerException
	 */
	public Journey leastHop(String from, String to) throws FlyingPlannerException {
		
		graph = new AsUnweightedGraph<Airport, Flight>(graph); 							// Creating a new unweighed graph as Dijkstra uses the weight and the weight is the cost
		DijkstraShortestPath<Airport, Flight> dij = new DijkstraShortestPath<>(graph);	// so we have to use the unweighed graph to get the hop instead
		Journey journey = new Journey(dij.getPath(airport(from), airport(to))); 		// Using Dijkstra on the path to get the least hop then returning the journey 
		return journey; 
		
		
	}

	
	/**
	 * @param form
	 * @param to
	 * @param excluding
	 * @return a cheapest flight journey from one airport (airport code) to another,excluding a list of airport (airport codes)
	 * @throws FlyingPlannerException
	 */
	public Journey leastCost(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		Graph<Airport, Flight> temporary = graph;				// Creating a new temporary graph 
		for(String airport : excluding) {						// Iterating through all the airports in the excluding
			temporary.removeVertex(airport(airport)); 			// Removing that vertex from the temporary graph 
		}
		GraphPath<Airport, Flight> path = DijkstraShortestPath.findPathBetween(temporary, airport(from), airport(to)); 	// Using Dijkstra to find the shortest path between the from and to airport, using the temporary excluded graph
		if(path == null) {
			throw new FlyingPlannerException("Error: The path is null");		// If the path is null we display an error 
		}
		
		Journey journey = new Journey(path.getEdgeList()); 		// Returning the cheapest flight from one airport to another excluding the list of airports
		return journey; 
		
	}

	
	public Journey leastHop(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		
		return null;
	}


	
	public Set<Airport> directlyConnected(Airport airport) {
		
		return null;
	}

	
	public int setDirectlyConnected() {
		
		return 0;
	}

	
	public int setDirectlyConnectedOrder() {
		
		return 0;
	}

	
	public Set<Airport> getBetterConnectedInOrder(Airport airport) {
		
		return null;
	}

	
	public String leastCostMeetUp(String at1, String at2) throws FlyingPlannerException {
		
		return null;
	}

	
	public String leastHopMeetUp(String at1, String at2) throws FlyingPlannerException {
		
		return null;
	}

	
	public String leastTimeMeetUp(String at1, String at2, String startTime) throws FlyingPlannerException {
		
		return null;
	}


}
