package mastermind;

public class generaterandomnumber {
	
	public static int random() {
	
		double randomvalue = Math.round(Math.random() * 10) % 10 + 1;
		while(randomvalue > 6) {
			randomvalue = Math.round(Math.random() * 10) % 10 + 1;
		}
		int random = (int) randomvalue;
		return random;

}
}
