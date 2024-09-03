package p3CrimeStatsSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p3.CityCrime;

class TestCityCrime {

	// Input data

	String validNameStateLow, validNameStateHigh;
	String invalidNameStateLow;

	int validIntLow, validIntHigh;
	int invalidIntLow;

	CityCrime c;

	@BeforeEach
	void setUp() throws Exception {

		validNameStateLow = "A";
		validNameStateHigh = "A".repeat(30);

		invalidNameStateLow = "";

		validIntLow = 0;
		validIntHigh = 100000;
		invalidIntLow = -1;

		c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
				validIntHigh, validIntHigh, validIntHigh, validIntHigh);

	}

	@Test
	void testCityCrimeDefaultConstructor() {
		assertNotNull(c);
	}

	@Test
	void testCityCrimeConstructorWithArgsValid() {
		assertEquals(validNameStateHigh, c.getState());
		assertEquals(validNameStateHigh, c.getCity());
		assertEquals(validIntHigh, c.getPopulation());
		assertEquals(validIntHigh, c.getMurder());
		assertEquals(validIntHigh, c.getRobbery());
		assertEquals(validIntHigh, c.getAssault());
		assertEquals(validIntHigh, c.getBurglary());
		assertEquals(validIntHigh, c.getLarceny());
		assertEquals(validIntHigh, c.getMotorTheft());
	}
	
	@Test
	void testCityCrimeConstructorWithArgsInValid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(invalidNameStateLow, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
					validIntHigh, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID CITY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, invalidNameStateLow, validIntHigh, validIntHigh, validIntHigh,
					validIntHigh, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID STATE", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, invalidIntLow, validIntHigh, validIntHigh,
					validIntHigh, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID POPULATION", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, invalidIntLow, validIntHigh,
					validIntHigh, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID MURDER", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, invalidIntLow,
					validIntHigh, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID ROBBERY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
					invalidIntLow, validIntHigh, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID ASSAULT", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
					validIntHigh, invalidIntLow, validIntHigh, validIntHigh);
		});
		
		assertEquals("INVALID BURGLARY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
					validIntHigh, validIntHigh, invalidIntLow, validIntHigh);
		});
		
		assertEquals("INVALID LARCENY", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			c = new CityCrime(validNameStateHigh, validNameStateHigh, validIntHigh, validIntHigh, validIntHigh,
					validIntHigh, validIntHigh, validIntHigh, invalidIntLow);
		});
		
		assertEquals("INVALID MOTOR THEFT", exp.getMessage());
		
	}

	@Test
	void testSetGetCityValid() {
		c.setCity(validNameStateLow);
		assertEquals(validNameStateLow, c.getCity());
		
		c.setCity(validNameStateHigh);
		assertEquals(validNameStateHigh, c.getCity());
	}

	@Test
	void testSetGetCityInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setCity(invalidNameStateLow);
		});
		
		assertEquals("INVALID CITY", exp.getMessage());
	}

	@Test
	void testSetGetStateValid() {
		c.setState(validNameStateLow);
		assertEquals(validNameStateLow, c.getState());
		
		c.setState(validNameStateHigh);
		assertEquals(validNameStateHigh, c.getState());
	}

	@Test
	void testSetGetStateInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setState(invalidNameStateLow);
		});
		
		assertEquals("INVALID STATE", exp.getMessage());
	}

	@Test
	void testSetGetPopulationValid() {
		c.setPopulation(validIntLow);
		assertEquals(validIntLow, c.getPopulation());
		
		c.setPopulation(validIntHigh);
		assertEquals(validIntHigh, c.getPopulation());
	}

	@Test
	void testSetGetPopulationInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setPopulation(invalidIntLow);
		});
		
		assertEquals("INVALID POPULATION", exp.getMessage());
	}

	@Test
	void testSetGetMurderValid() {
		c.setMurder(validIntLow);
		assertEquals(validIntLow, c.getMurder());
		
		c.setMurder(validIntHigh);
		assertEquals(validIntHigh, c.getMurder());
	}

	@Test
	void testSetGetMurderInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setMurder(invalidIntLow);
		});
		
		assertEquals("INVALID MURDER", exp.getMessage());
	}

	@Test
	void testSetGetRobberyValid() {
		c.setRobbery(validIntLow);
		assertEquals(validIntLow, c.getRobbery());
		
		c.setRobbery(validIntHigh);
		assertEquals(validIntHigh, c.getRobbery());
	}

	@Test
	void testSetGetRobberyInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setRobbery(invalidIntLow);
		});
		
		assertEquals("INVALID ROBBERY", exp.getMessage());
	}

	@Test
	void testSetGetAssaultValid() {
		c.setAssault(validIntLow);
		assertEquals(validIntLow, c.getAssault());
		
		c.setAssault(validIntHigh);
		assertEquals(validIntHigh, c.getAssault());
	}

	@Test
	void testSetGetAssaultInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setAssault(invalidIntLow);
		});
		
		assertEquals("INVALID ASSAULT", exp.getMessage());
	}

	@Test
	void testSetGetBurglaryValid() {
		c.setBurglary(validIntLow);
		assertEquals(validIntLow, c.getBurglary());
		
		c.setBurglary(validIntHigh);
		assertEquals(validIntHigh, c.getBurglary());
	}

	@Test
	void testSetGetBurglaryInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setBurglary(invalidIntLow);
		});
		
		assertEquals("INVALID BURGLARY", exp.getMessage());
	}

	@Test
	void testSetGetLarcenyValid() {
		c.setLarceny(validIntLow);
		assertEquals(validIntLow, c.getLarceny());
		
		c.setLarceny(validIntHigh);
		assertEquals(validIntHigh, c.getLarceny());
	}

	@Test
	void testSetGetLarcenyInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setLarceny(invalidIntLow);
		});
		
		assertEquals("INVALID LARCENY", exp.getMessage());
	}

	@Test
	void testGetMotorTheft() {
		c.setMotorTheft(validIntLow);
		assertEquals(validIntLow, c.getMotorTheft());
		
		c.setMotorTheft(validIntHigh);
		assertEquals(validIntHigh, c.getMotorTheft());
	}

	@Test
	void testSetMotorTheft() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			c.setMotorTheft(invalidIntLow);
		});
		
		assertEquals("INVALID MOTOR THEFT", exp.getMessage());
	}

	@Test
	void testGetViolentCrime() {
		assertEquals(300000, c.getViolentCrime());
	}

	@Test
	void testGetPossessionCrimes() {
		assertEquals(300000, c.getPossessionCrimes());
	}

}
