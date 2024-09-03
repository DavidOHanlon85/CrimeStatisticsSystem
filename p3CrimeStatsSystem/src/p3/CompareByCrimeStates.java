/**
 * 
 */
package p3;

import java.util.Comparator;

/**
 * 
 */
public class CompareByCrimeStates implements Comparator<CityCrime> {

	@Override
	public int compare(CityCrime o1, CityCrime o2) {
		// TODO Auto-generated method stub
		return (o1.getViolentCrime() + o1.getPossessionCrimes()) - (o2.getViolentCrime() + o2.getPossessionCrimes());
	}

}
