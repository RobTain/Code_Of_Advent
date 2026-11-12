package Day04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day04 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Day04 day04 = new Day04();
		Day04.solution(day04);
		System.out.println("Solution 1: " + day04.getSolution1());
		System.out.println("Solution 2: " + day04.getSolution2());
	}

	private static void solution(Day04 day04) throws NoSuchAlgorithmException {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day04/Day04.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day04.setSolution1(day04.getSolution1() + solution1(sb.toString()));
				day04.setSolution2(day04.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String tmp = string + String.valueOf(i);
			byte[] hash = md5.digest(tmp.getBytes());
			
			StringBuilder hex = new StringBuilder();
		    for (byte b : hash) { hex.append(String.format("%02x", b)); }
		    tmp = hex.toString();
		    if (tmp.substring(0, 5).equals("00000")) { return i; }
		}
		return 0;
	}

	private static int solution2(String string) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String tmp = string + String.valueOf(i);
			byte[] hash = md5.digest(tmp.getBytes());
			
			StringBuilder hex = new StringBuilder();
		    for (byte b : hash) { hex.append(String.format("%02x", b)); }
		    tmp = hex.toString();
		    if (tmp.substring(0, 6).equals("000000")) { return i; }
		}
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
