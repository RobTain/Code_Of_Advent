package Day03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day03 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;

	public static void main(String[] args) {
		Day03 day03 = new Day03();
		Day03.solution(day03);
		System.out.println("Solution 1: " + day03.getSolution1());
		System.out.println("Solution 2: " + day03.getSolution2());
	}

	private static void solution(Day03 day03) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day03/Day03.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.next());
				day03.setSolution1(day03.getSolution1() + solution1(sb.toString()));
				day03.setSolution2(day03.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int solution1(String string) {
		int right = 0, down = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '>') { right++; } 
			if (string.charAt(i) == 'v') { down++; }
		}
		
		int[][] map = new int[right*2][down*2];
	
		for (int i = 0; i < string.length(); i++) {
			map[right][down]++;
			switch (string.charAt(i)) {
			case '>': { right++; break;}
			case '<': { right--; break;}
			case '^': { down--; break;}
			case 'v': { down++; break;}
			}
		}
		
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) { count++; } 
			}
		}
		
		return count;
	}

	private static int solution2(String string) {
		int right = 0, down = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '>') { right++; } 
			if (string.charAt(i) == 'v') { down++; }
		}
		
		int tmpRight = right;
		int tmpDown = down;
		
		int[][] map = new int[right*2][down*2];
	
		for (int i = 0; i < string.length(); i=i+2) {
			map[right][down]++;
			switch (string.charAt(i)) {
			case '>': { right++; break;}
			case '<': { right--; break;}
			case '^': { down--; break;}
			case 'v': { down++; break;}
			}
		}
		
		for (int i = 1; i < string.length(); i=i+2) {
			map[tmpRight][tmpDown]++;
			switch (string.charAt(i)) {
			case '>': { tmpRight++; break;}
			case '<': { tmpRight--; break;}
			case '^': { tmpDown--; break;}
			case 'v': { tmpDown++; break;}
			}
		}
		
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) { count++; } 
			}
		}
		return count;
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
