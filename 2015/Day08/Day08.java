package Day08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Day08 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day08 day08 = new Day08();
		Day08.solution(day08);
		System.out.println("Solution 1: " + day08.getSolution1());
		System.out.println("Solution 2: " + day08.getSolution2());
		System.out.println("Not Working");
	}

	private static void solution(Day08 day08) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day08/Day08.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.nextLine());
				day08.setSolution1(day08.getSolution1() + solution1(sb.toString()));
				day08.setSolution2(day08.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) {
		return 0;
	}

	private static int solution2(String string) {
		return 0; 
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

