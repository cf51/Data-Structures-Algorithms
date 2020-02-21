package F28DA_CW2;

import java.util.Set;

public class Airport implements IAirportPartB, IAirportPartC {
	
	String code; 
	String name; 
	
	public Airport(String [] airports) {
		this.code = airports[0]; 
		this.name = airports[1]; 
	}
	
	/**
	 * @return The airport code 
	 */
	public String getCode() {
		
		return code; 
	}

	/**
	 * @return The airport name 
	 */
	public String getName() {
		
		return name; 
	}

	
	public void setDicrectlyConnected(Set<Airport> dicrectlyConnected) {
		// TODO Auto-generated method stub

	}

	
	public Set<Airport> getDicrectlyConnected() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public void setDicrectlyConnectedOrder(int order) {
		// TODO Auto-generated method stub

	}

	
	public int getDirectlyConnectedOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
