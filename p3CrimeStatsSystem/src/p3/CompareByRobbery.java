/**
 * 
 */
package p3;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByRobbery implements Comparator<CityCrime> {

	@Override
	public int compare(CityCrime o1, CityCrime o2) {
		// TODO Auto-generated method stub
		return o1.getRobbery() - o2.getRobbery();
	}

}
