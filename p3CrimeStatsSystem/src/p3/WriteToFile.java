/**
 * 
 */
package p3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class WriteToFile implements Runnable {

	@Override
	public void run() {
		
		File file = new File("RobberyStats.csv");
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Collections.sort(StartApp.cityCrimes, new CompareByRobbery().reversed());
			
			StringBuilder sb = buildRequiredString();
			
			bw.write(sb.toString());
			
			if (Thread.currentThread().isInterrupted()) {
				bw.close();
				fw.close();
			}
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * This method builds and returns the required string to be printed
	 * 
	 * @return
	 */
	public StringBuilder buildRequiredString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Robbery, City");
		sb.append("\n");
		
		for (CityCrime c : StartApp.cityCrimes) {
			sb.append(c.getRobbery() + "," + c.getCity());
			sb.append("\n");
		}
		return sb;
	}

}
