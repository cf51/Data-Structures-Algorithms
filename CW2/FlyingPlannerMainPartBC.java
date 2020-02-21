package F28DA_CW2;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class FlyingPlannerMainPartBC {

	public static void main(String[] args) {

		// Your implementation should be in FlyingPlanner.java, this class is only to
		// run the user interface of your programme.
		
		FlyingPlanner fi;
		fi = new FlyingPlanner();
		try {
			
			fi.populate(new FlightsReader());
					
			Scanner scan = new Scanner(System.in); 									// Creating a new scanner 

			System.out.println("---------------------------");						// Printing out user interface 
			System.out.println(" Welcome to flight Planner ");
			System.out.println("---------------------------");
			System.out.println();
			System.out.println("Please use all caps and check your spelling");
			System.out.println("Please enter the start airport");
			
			String startAirport = scan.nextLine(); 									// Taking the users input for their departure airport using a scanner 
			Airport airStart = fi.airport(startAirport); 							// Setting the users input to the graph
			while(fi.graph.containsVertex(airStart) == false) {						// Checking if the users input was a valid airport code 
				System.err.println("Please enter a valid airport to depart from");	// Giving an error message to the user 
				startAirport = scan.nextLine(); 									// Taking their input back in again
				airStart = fi.airport(startAirport);  
			}
			
			
			
			
			System.out.println("Great, now where would you like to fly to?");		// Asking the user for their arrival airport 
			String endAirport= scan.nextLine(); 									// Scanning the users input 
			Airport airEnd = fi.airport(endAirport); 								// Setting the users input to the graph 
			while(fi.graph.containsVertex(airEnd) == false) {						// Again checking if the users input was a valid airport 
				System.err.println("Please enter a valid airport to depart from");	// Giving an error message back to the user 
				endAirport = scan.nextLine();										// Taking their input back in again 
				airEnd = fi.airport(endAirport); 
			}
			
			Journey journey = fi.leastCost(airStart.getCode(),airEnd.getCode()); 	// Getting the least cost for the start airport code & end airport code 
			 
			
			System.out.println("-----------------------------------------------------------");							// Printing out user interface
			System.out.println("\n\tHere is your journey from " + airStart.getName() + " to " + airEnd.getName());		// Displaying the airports names 
			System.out.println("\n\tYour connections will be " + journey.getFlights());									// Displaying the connections
			System.out.println("");
			System.out.printf(String.format("|%30s|","Your total journey cost will be = £" + journey.totalCost()));							// Displaying the total cost 
			System.out.printf(String.format("|%30s|","Your total journey time will be = " + journey.airTime())); // Displaying the total time in the air
		
	
			
			
		} catch (FileNotFoundException | FlyingPlannerException e) {
			e.printStackTrace();
		}

	}

}
