package F28DA_CW2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class FlyingPlannerTest {

	FlyingPlanner fi;

	@Before
	public void initialize() {
		fi = new FlyingPlanner();
		try {
			fi.populate(new FlightsReader());
		} catch (FileNotFoundException | FlyingPlannerException e) {
			e.printStackTrace();
		}
	}

	// Add your own tests here
	// You can get inspiration from FlyingPlannerProvidedTest
	
	@Test
	public void leastCostTest1() {
		try {
			Journey i = fi.leastCost("SEA", "JUL");
			assertEquals(5, i.totalHop());
			assertEquals(656, i.totalCost());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastCostTest2() {
		try {
			Journey i = fi.leastCost("NTL", "BNE");
			assertEquals(1, i.totalHop());
			assertEquals(89, i.totalCost());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastCostTest3() {
		try {
			Journey i = fi.leastCost("AMS", "HKG");
			assertEquals(1, i.totalHop());
			assertEquals(518, i.totalCost());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastHopTest1() {
		try {
			Journey i = fi.leastHop("SEA", "JUL");
			assertEquals(4, i.totalHop());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastHopTest2() {
		try {
			Journey i = fi.leastHop("BNE", "AMS");
			assertEquals(2, i.totalHop());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastHopTest3() {
		try {
			Journey i = fi.leastHop("SEA", "EDI");
			assertEquals(2, i.totalHop());
		} catch (FlyingPlannerException e) {
			fail();
		}
	}
	
	@Test
	public void leastCostCustomTest() {
		FlyingPlanner fp = new FlyingPlanner();
		HashSet<String[]> airports = new HashSet<String[]>();
		String[] b1= {"B1","City1","AirportName1"}; airports.add(b1);
		String[] b2= {"B2","City2","AirportName2"}; airports.add(b2);
		String[] b3= {"B3","City2","AirportName3"}; airports.add(b3);
		String[] b4= {"B4","City2","AirportName3"}; airports.add(b4);
		HashSet<String[]>  flights = new HashSet<String[]>();
		String[] f1= {"F1","B1","2000","B2","8900","5400"}; flights.add(f1);
		String[] f2= {"F2","B1","3000","B3","15700","5330"}; flights.add(f2);
		String[] f3= {"F3","B3","4500","B2","1480","504"}; flights.add(f3);
		String[] f4= {"F4","B3","4500","B4","1480","504"}; flights.add(f4);
		fp.populate(airports, flights);
		try {
			System.out.println(fp);
			Journey lc = fp.leastCost("B1", "B2");
			assertEquals(5400,lc.totalCost());
		} catch (FlyingPlannerException e) {
			e.printStackTrace();
			fail();
		}
	}

}
