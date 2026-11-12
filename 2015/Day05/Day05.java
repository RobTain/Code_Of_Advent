package Day05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day05 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day05 day05 = new Day05();
		Day05.solution(day05);
		System.out.println("Solution 1: " + day05.getSolution1());
		System.out.println("Solution 2: " + day05.getSolution2());
	}

	private static void solution(Day05 day05) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day05/Day05.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day05.setSolution1(day05.getSolution1() + solution1(sb.toString()));
				day05.setSolution2(day05.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) {
		boolean check = false;
		int vowels = 0;
		int twiceLetter = 0;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' 
					|| string.charAt(i) == 'o' || string.charAt(i) == 'u') {
				vowels++;
			}

			if (i < (string.length() - 1) && string.charAt(i) == string.charAt(i + 1)) {
				twiceLetter++;
			}
		}
		
		if (vowels >= 3 && twiceLetter >= 1 && !string.contains("ab") && !string.contains("cd")
				&& !string.contains("pq") && !string.contains("xy")) {
			check = true;
		}
		
		return Boolean.compare(check, false);
	}

	private static int solution2(String string) {
		boolean checkPair = false;
		boolean checkSingle = false;
		for (int i = 0; i < string.length() - 3; i++) {
			String check = string.substring(i, i + 2);
			String searchString = (String) string.subSequence((i + 2), string.length());
			if (searchString.contains(check)) {
				checkPair = true;
				break;
			}	
		}
		
		for (int i = 0; i < string.length() - 2; i++) {
			if (string.charAt(i) == string.charAt(i + 2)) {
				checkSingle = true;
				break;
			}
		}

		if (checkPair && checkSingle) { return 1; } else { return 0; }
	}

	public int getSolution1() {
		return solution1;
	}

	public void setSolution1(int solution1) {
		this.solution1 = solution1;
	}

	public int getSolution2() {
		return solution2;
	}

	public void setSolution2(int solution2) {
		this.solution2 = solution2;
	}

}
