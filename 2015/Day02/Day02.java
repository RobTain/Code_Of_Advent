package Day02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day02 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day02 day02 = new Day02();
		Day02.solution(day02);
		System.out.println("Solution 1: " + day02.getSolution1());
		System.out.println("Solution 2: " + day02.getSolution2());
	}

	private static void solution(Day02 day02) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day02/Day02.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day02.setSolution1(day02.getSolution1() + solution1(sb.toString()));
				day02.setSolution2(day02.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) {
		int result = 0;
		int[] input = Arrays.stream(string.split("x")).mapToInt(Integer::parseInt).toArray();
		int[] calculation = new int[input.length];

		calculation[0] = input[0] * input[1];
		calculation[1] = input[1] * input[2];
		calculation[2] = input[2] * input[0];
		
		for (int i : calculation) { result += i * 2; }
		return result + Arrays.stream(calculation).min().getAsInt();
	}

	private static int solution2(String string) {
		int[] input = Arrays.stream(string.split("x")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(input);
		return ((input[0]+input[0]+input[1]+input[1])+(input[0]*input[1]*input[2]));
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
