package F28DA_CW2;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;


public class Journey implements IJourneyPartB<Airport, Flight>, IJourneyPartC<Airport, Flight> {

	
	List<Flight> flightList;    // ArrayList of all of the flights 
	List<Airport> airportList;  // ArrayList of all of the airports 

	/**
	 * @param flightList
	 * @param airportList
	 */
	public Journey(List<Flight> flightList, List<Airport> airportList) {
		this.flightList = flightList; 
		this.airportList = airportList; 
	}

	
	
	public Journey(GraphPath<Airport, Flight> path) {
		this.airportList = path.getVertexList();
		this.flightList = path.getEdgeList(); 
	}



	public Journey(List<Flight> edgeList) {
		// TODO Auto-generated constructor stub
	}



	/**
	 *@return The list of airports codes composing the journey
	 */
	public List<String> getStops() {
		
		List<String> airportCodesList = new ArrayList<String>(); 	// Creating new array list of airport codes 
		for(Airport a : airportList) {								// Iterating over all airports in the airport list 
			String airportCode = a.getCode();						// Getting the airport code 
			airportCodesList.add(airportCode); 						// Adding the code to the list of airport codes 
		}
		return airportCodesList;  									// Returning the airport codes list 
	}

	
	/**
	 * @return The list of flight codes composing the journey
	 */
	public List<String> getFlights() {
		
		List <String> flightCodesList = new ArrayList<String>();    // Creating new array list of flight codes 
		for(Flight f : flightList) {								// Iterating over all the flights in the flight list 
			String flightCodes = f.getFlightCode();					// Getting the flight code 
			flightCodesList.add(flightCodes); 						// Adding the code to the list of flight codes 
		}
		return flightCodesList; 									// Returning the flight codes list 
	}

	
	/**
	 * @return The number of connections of the journey
	 */
	public int totalHop() {
		
		return flightList.size(); 	// Returning the size of the flight list, the number of connections of the journey 
					
	}

	/**
	 * @return The total cost of the journey
	 */
	public int totalCost() {
		int totalCost = 0; 					// Setting total cost to 0 
		for(Flight f : flightList) {		// Iterating over all the flights in the flight list 
			int cost = f.getCost();			// Setting cost equal to the cost of the flight 
			totalCost += cost; 				// Setting total cost to the cost of all the flights combined 
		}
		return totalCost; 					// Returning the total cost 
	}

	
	
	/**
	 * @return The total time in flight of the journey
	 */
	public int airTime() {
		
		String fromTimeS = null;     		// Setting the from time string to null to begin with 
		String toTimeS = null;				// Setting the to time string to null to begin with 
		
		for(Flight f : flightList) {		// Iterating over all the flights in the flight list 
			fromTimeS = f.getFromGMTime();	// Setting the from time string equal to the GMT from time 
		}
		
		for(Flight f : flightList) {		// Iterating over all the flights in the flight list 
			toTimeS = f.getToGMTime();		// Setting the to time string equal to the GMT to time
		}
		
		if (fromTimeS.length() < 2) {		// If the length of the string is '5' instead of '00:05' 
			fromTimeS = ("000" + fromTimeS); // We add 3 zeros to keep them all in the same format 
		}
		
		if (toTimeS.length() <2) {			// If the length of the string is '5' instead of '00:05' 
			toTimeS = ("000" + toTimeS);	// We add 3 zeros to keep them all in the same format 
		}
		
		
		int fromTime = Integer.parseInt(fromTimeS); 	// Parsing the string to an integer 
		int toTime = Integer.parseInt(toTimeS); 		// Parsing the string to an integer 
		
		int airTime = (toTime - fromTime); 				// The total time is equal to the to time minus the from time (Arrival-Departure)
														// Example: Departure: 13:00 , Arrival: 20:00..... Total time = (20:00 - 13:00) = 7 hour flight
		if(airTime <0) {								// If the time is total time is a minus number we have to add 2400 (24 hours) 
			airTime = airTime + 2400;					// Example: (Arrival: 05:00 - Departure: 13:00) = -8000 + 2400 = 16 hour flight 
		}
		
		return airTime; 								// Returning the air time 
	}

	
	
	public int connectingTime() {
		// TODO Auto-generated method stub
		// Flight end time from flight 1 to the start time of flight 2 
		return this.connectingTime();
	}

	
	
	public int totalTime() {
		// Total time from the start of flight 1 to the end of the last flight 
		return this.totalTime();
	}

}
