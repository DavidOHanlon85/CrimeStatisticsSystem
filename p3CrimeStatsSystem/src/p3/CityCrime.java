/**
 * 
 */
package p3;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CityCrime {

	// Instance Variables

	private String city;
	private String state;
	private int population;
	private int murder;
	private int robbery;
	private int assault;
	private int burglary;
	private int larceny;
	private int motorTheft;

	// Constructors

	/**
	 * Default constructor
	 * 
	 * @throws IllegalArgumentException
	 */
	public CityCrime() throws IllegalArgumentException {

	}

	/**
	 * Constructor with args
	 * 
	 * @param city
	 * @param state
	 * @param population
	 * @param murder
	 * @param robbery
	 * @param assault
	 * @param burglary
	 * @param larceny
	 * @param motorTheft
	 */
	public CityCrime(String city, String state, int population, int murder, int robbery, int assault, int burglary,
			int larceny, int motorTheft) throws IllegalArgumentException {
		super();
		this.setCity(city);
		this.setState(state);
		this.setPopulation(population);
		this.setMurder(murder);
		this.setRobbery(robbery);
		this.setAssault(assault);
		this.setBurglary(burglary);
		this.setLarceny(larceny);
		this.setMotorTheft(motorTheft);
	}

	// Getters and Setters

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 * @throws IllegalArgumentException
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if (city.equals("")) {
			throw new IllegalArgumentException("INVALID CITY");
		} else {
			this.city = city;
		}

	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 * @throws IllegalArgumentException
	 */
	public void setState(String state) throws IllegalArgumentException {
		if (state.equals("")) {
			throw new IllegalArgumentException("INVALID STATE");
		} else {
			this.state = state;
		}
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * 
	 * @param population
	 * @throws IllegalArgumentException
	 */
	public void setPopulation(int population) throws IllegalArgumentException {
		if (population >= 0) {
			this.population = population;
		} else {
			throw new IllegalArgumentException("INVALID POPULATION");
		}

	}

	/**
	 * @return the murder
	 */
	public int getMurder() {
		return murder;
	}

	/**
	 * 
	 * @param murder
	 * @throws IllegalArgumentException
	 */
	public void setMurder(int murder) throws IllegalArgumentException {
		if (murder >= 0) {
			this.murder = murder;
		} else {
			throw new IllegalArgumentException("INVALID MURDER");
		}
	}

	/**
	 * @return the robbery
	 */
	public int getRobbery() {
		return robbery;
	}

	/**
	 * 
	 * @param robbery
	 * @throws IllegalArgumentException
	 */
	public void setRobbery(int robbery) throws IllegalArgumentException {
		if (robbery >= 0) {
			this.robbery = robbery;
		} else {
			throw new IllegalArgumentException("INVALID ROBBERY");
		}
	}

	/**
	 * @return the assault
	 */
	public int getAssault() {
		return assault;
	}

	/**
	 * 
	 * @param assault
	 * @throws IllegalArgumentException
	 */
	public void setAssault(int assault) throws IllegalArgumentException {
		if (assault >= 0) {
			this.assault = assault;
		} else {
			throw new IllegalArgumentException("INVALID ASSAULT");
		}
	}

	/**
	 * @return the burglary
	 */
	public int getBurglary() {
		return burglary;
	}

	/**
	 * 
	 * @param burglary
	 * @throws IllegalArgumentException
	 */
	public void setBurglary(int burglary) throws IllegalArgumentException {
		if (burglary >= 0) {
			this.burglary = burglary;
		} else {
			throw new IllegalArgumentException("INVALID BURGLARY");
		}

	}

	/**
	 * @return the larceny
	 */
	public int getLarceny() {
		return larceny;
	}

	/**
	 * 
	 * @param larceny
	 * @throws IllegalArgumentException
	 */
	public void setLarceny(int larceny) throws IllegalArgumentException {
		if (larceny >= 0) {
			this.larceny = larceny;
		} else {
			throw new IllegalArgumentException("INVALID LARCENY");
		}
	}

	/**
	 * @return the motorTheft
	 */
	public int getMotorTheft() {
		return motorTheft;
	}

	/**
	 * 
	 * @param motorTheft
	 * @throws IllegalArgumentException
	 */
	public void setMotorTheft(int motorTheft) throws IllegalArgumentException {
		if (motorTheft >= 0) {
			this.motorTheft = motorTheft;
		} else {
			throw new IllegalArgumentException("INVALID MOTOR THEFT");
		}
	}

	// Methods

	public int getViolentCrime() {

		return getMurder() + getRobbery() + getAssault();
	}

	public int getPossessionCrimes() {

		return getBurglary() + getLarceny() + getMotorTheft();
	}

	public void displayAllCrimeData() {
		System.out.println("City               : " + getCity());
		System.out.println("State              : " + getState());
		System.out.println("Population         : " + getPopulation());
		System.out.println("Murder             : " + getMurder());
		System.out.println("Robbery            : " + getRobbery());
		System.out.println("Assault            : " + getAssault());
		System.out.println("Burglary           : " + getBurglary());
		System.out.println("Larceny            : " + getLarceny());
		System.out.println("Car theft          : " + getMotorTheft());
		System.out.println("Violent crime      : " + getViolentCrime());
		System.out.println("Possession crime   : " + getPossessionCrimes());

	}

}
