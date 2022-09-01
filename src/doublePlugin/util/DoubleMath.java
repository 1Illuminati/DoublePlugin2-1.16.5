package doublePlugin.util;

import java.security.SecureRandom;

public class DoubleMath {
	private static final SecureRandom rand = new SecureRandom();
	
	public static int rand(int bound) {
		return Math.abs(rand.nextInt()) % bound;
	}
	
	public static boolean per(double per) {
		double rand = Math.abs(rand(10000000) / 100000D);
		
		return rand < per;
	}
}
