package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.IntegerConversion;

public class StartApp {

	public static ArrayList<CityCrime> cityCrimes = new ArrayList<CityCrime>();
	public static Map<String, String> cityStates = new HashMap<String, String>();

	/**
	 * Start point for app. Directs the reads from file and shows the menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			readStates();
			readCrimeData();
			System.out.println("Total cities read : " + cityCrimes.size());
			showMenu();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method reads in the stateAbbreviations file and maps the state to state
	 * code
	 * 
	 * @return
	 */
	private static void readStates() {

		File file = new File("OwnStates.csv");
		String line;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine(); // read header
			line = br.readLine(); // read first line

			while (line != null) {

				try {
					String[] splitDetails = line.split(",");

					String state = splitDetails[0];
					String code = splitDetails[1];

					cityStates.put(state, code);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				line = br.readLine();

			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Reads the crime data for each city from file
	 */
	public static void readCrimeData() {

		File file = new File("CrimeUSAlatest.csv");
		String line;
		int attemptedReads = 0;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine(); // read header
			line = br.readLine(); // read first line

			while (line != null) {

				try {
					try {
						attemptedReads++;
						String[] splitDetails = line.split(",");

						CityCrime c = new CityCrime();

						c.setCity(splitDetails[0]);
						c.setState(cityStates.get(splitDetails[1].toUpperCase()));
						c.setPopulation(Integer.parseInt(splitDetails[2]));
						c.setMurder(Integer.parseInt(splitDetails[3]));
						c.setRobbery(Integer.parseInt(splitDetails[4]));
						c.setAssault(Integer.parseInt(splitDetails[5]));
						c.setBurglary(Integer.parseInt(splitDetails[6]));
						c.setLarceny(Integer.parseInt(splitDetails[7]));
						c.setMotorTheft(Integer.parseInt(splitDetails[8]));

						cityCrimes.add(c);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				line = br.readLine();

			}

			System.out.println("Attempted reads: " + attemptedReads);

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Displays the menu
	 * 
	 */
	public static void showMenu() {

		Scanner sc = new Scanner(System.in);

		int input;

		do {
			System.out.println("1. Display all crime stats by city");
			System.out.println("2. Display all crime stats by selected city");
			System.out.println("3. Display the murder stats by selected state ");
			System.out.println("4. Display  highest crime city - all crimes");
			System.out.println("5. Display each state (in alphabetical order with the number of car thefts ");
			System.out.println("6. Write / export all cities in descending order of Robbery rate ");
			System.out.println("7. Quit");
			System.out.println("Enter option ...");
			input = sc.nextInt();

			switch (input) {

			case 1:
				displayAllCrimeDataInList(cityCrimes);
				break;
			case 2:
				String cityName = "Riverton";
				ArrayList<CityCrime> resultsFilterByCity = filterByCity(cityCrimes, cityName);
				displayAllCrimeDataInList(resultsFilterByCity);
				break;
			case 3:
				String state = "NY";
				int totalMurders = totalMurdersInAState(cityCrimes, state);
				System.out.printf("Total murders %d in %s\n", totalMurders, state);
				break;
			case 4:
				Collections.sort(cityCrimes, new CompareByCrimeStates().reversed());
				ArrayList<CityCrime> resultsForFilterByTopX = FilterTopXInList(cityCrimes, 1);
				displayAllCrimeDataInList(resultsForFilterByTopX);
				break;
			case 5:
				System.out.println("States and car theft");
				TreeMap<String, Integer> resultsForCarTheft = mapStatesToCarTheft(cityCrimes);
				displayStateVsCarTheft(resultsForCarTheft);

				break;
			case 6:
				WriteToFile w = new WriteToFile();
				Thread t = new Thread(w);
				
				t.start();
				break;
			default:
				System.out.println("Invalid entry");

			}

		} while (input != 7);

	}

	/**
	 * This method display stats vs car theft
	 * 
	 * @param resultsForCarTheft
	 */
	public static void displayStateVsCarTheft(TreeMap<String, Integer> resultsForCarTheft)
			throws IllegalArgumentException {

		if (resultsForCarTheft == null || resultsForCarTheft.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (String s : resultsForCarTheft.keySet()) {
			System.out.println(s + "           " + resultsForCarTheft.get(s));
		}
	}

	/**
	 * This method maps states to car theft
	 * 
	 * @param cityCrimes2
	 * @return
	 */
	private static TreeMap<String, Integer> mapStatesToCarTheft(ArrayList<CityCrime> cityCrimes2)
			throws IllegalArgumentException {
		if (cityCrimes2 == null || cityCrimes2.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		TreeMap<String, Integer> statestoCarTheft = new TreeMap<String, Integer>();

		for (CityCrime c : cityCrimes2) {
			if (statestoCarTheft.containsKey(c.getState())) {
				int totalToDate = statestoCarTheft.get(c.getState());
				statestoCarTheft.put(c.getState(), totalToDate + c.getMotorTheft());
			} else {
				statestoCarTheft.put(c.getState(), c.getMotorTheft());
			}

		}

		return statestoCarTheft;
	}

	/**
	 * This method filters the top x number of items in a list
	 * 
	 * @param cityCrimes2
	 * @param targetNumber
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static ArrayList<CityCrime> FilterTopXInList(ArrayList<CityCrime> cityCrimes2, int targetNumber)
			throws IllegalArgumentException {
		if (cityCrimes2 == null || cityCrimes2.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<CityCrime> results = new ArrayList<CityCrime>();

		for (int i = 0; i < targetNumber; i++) {
			results.add(cityCrimes2.get(i));
		}

		return results;

	}

	/**
	 * This method calculates total murders in a state and returns this as an int
	 * 
	 * @param cityCrimes2
	 * @param state
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static int totalMurdersInAState(ArrayList<CityCrime> cityCrimes2, String state)
			throws IllegalArgumentException {
		if (cityCrimes2 == null || cityCrimes2.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		int total = 0;

		for (CityCrime c : cityCrimes2) {
			if (c.getState().equalsIgnoreCase(state)) {
				total += c.getMurder();
			}
		}

		return total;
	}

	/**
	 * This method filters by city name
	 * 
	 * @param cityCrimes2
	 * @param cityName
	 * @return
	 */
	private static ArrayList<CityCrime> filterByCity(ArrayList<CityCrime> cityCrimes2, String cityName)
			throws IllegalArgumentException {

		if (cityCrimes2 == null || cityCrimes2.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<CityCrime> results = new ArrayList<CityCrime>();

		for (CityCrime c : cityCrimes2) {
			if (c.getCity().equalsIgnoreCase(cityName)) {
				results.add(c);
			}
		}

		return results;

	}

	/**
	 * This method displays all Crim Data in an ArrayList
	 * 
	 * @param cityCrimes2
	 * @throws IllegalArgumentException
	 */
	private static void displayAllCrimeDataInList(ArrayList<CityCrime> cityCrimes2) throws IllegalArgumentException {

		if (cityCrimes2 == null || cityCrimes2.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (CityCrime c : cityCrimes2) {
			c.displayAllCrimeData();
			System.out.println("____________________________");
		}

	}

}
