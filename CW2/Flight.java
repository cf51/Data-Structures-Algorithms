package F28DA_CW2;

public class Flight implements IFlight {

	String flightCode; 
	Airport toAirport; 
	Airport fromAirport;
	String fromTime; 
	String toTime;
	int cost; 
	
	public Flight(Airport arrival, Airport departure, String[] strings) {
		this.flightCode = strings[0];
		this.fromTime = strings[2]; 
		this.fromAirport = departure;
		this.toAirport = arrival; 
		this.toTime = strings[4];
		this.cost = Integer.parseInt(strings[5]); 
		
	}
	
	
	/**
	 *@return The flight code 
	 */
	public String getFlightCode() {
		return flightCode; 
	}

	
	/**
	 *@return The arrival airport 
	 */
	public Airport getTo() {
		return toAirport; 
	}

	/**
	 *@return The departure airport 
	 */
	public Airport getFrom() {
		return fromAirport;  
	}

	/**
	 *@return The flights departure time 
	 */
	public String getFromGMTime() {
		return fromTime; 
	}

	/**
	 *@return The flights arrival GMT time 
	 */
	public String getToGMTime() {
		return toTime; 
	}

	/**
	 *@return The flights cost 
	 */
	public int getCost() {
		return cost; 
	}


}
