package CoA2015;

public class Day10 {
	
	public static void main(String[] args) {
		System.out.println("Ergebnis Teil 1: " + calculateLookAndSay("3113322113", 40).length());
		System.out.println("Ergebnis Teil 2: " + calculateLookAndSay("3113322113", 50).length());
	}

	private static String calculateLookAndSay(String input, int factor) {
		String result = input;
		
		for (int i = 0; i < factor; i++) {
			 int count = 1;
			 String tmp = "";
			 for (int j = 0; j < result.length(); j++) {
				if (j+1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					count++;
				} else {
					tmp += String.valueOf(count) + result.charAt(j);
					count = 1;
				}
			}
			result = tmp;
			System.out.println("Durchlauf: " + (i+1));
		}
		return result;
	}
}
