package Day01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day01 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;
	
	public static void main(String[] args)   {
		Day01 day01 = new Day01();
		Day01.solution(day01);
		System.out.println("Solution 1: " + day01.getSolution1());

	}

	private static void solution(Day01 day01) {
		
		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day01/Day01.txt"));
			while(in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day01.setSolution1(day01.getSolution1() + calculateNumberFromString(sb.toString()));		
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	
	private static int calculateNumberFromString(String string) {
		String result = "";
		char[] temp = string.toCharArray();
		for (char c : temp) {
			
			if (Character.isDigit(c)) {
				result += c;
			}
		}
		result = result.substring(0,1) + result.substring(result.length()-1, result.length());
		
		return Integer.parseInt(result);
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
