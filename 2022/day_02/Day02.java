package day_02;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import util.CoA_Interface;

// A for Rock, B for Paper, and C for Scissors
// X for Rock, Y for Paper, and Z for Scissors
public class Day02 implements CoA_Interface {
	
	
	public static void main(String[] args) throws Exception {
		
		Day02 day02 = new Day02();
		LinkedList<String> input = new LinkedList<String>();

		day02.readInput(input);
		
		System.out.println("Solution - Part 1: " + day02.result01(input));
		System.out.println("Solution - Part 2: " + day02.result02(input));
		
	}

	public void readInput(LinkedList<String> input) throws Exception {
		Scanner in = new Scanner(new File("src/" + this.getClass().getPackageName() + "/" + this.getClass().getSimpleName() + "_input.txt")); 
		while(in.hasNextLine()) {
			input.add((String) in.nextLine());
		}
	}

	public String result01(LinkedList<String> input) {
		int result = 0;
		
		for (int i = 0; i < input.size(); i++) {
			switch (input.get(i)) {
				case "A X": result += 4; break;
				case "A Y": result += 8; break;
				case "A Z": result += 3; break;
				case "B X": result += 1; break;
				case "B Y": result += 5; break;
				case "B Z": result += 9; break;
				case "C X": result += 7; break;
				case "C Y": result += 2; break;
				case "C Z": result += 6; break;
			}	
		}
		return String.valueOf(result);
	}

	public String result02(LinkedList<String> input) {
		int result = 0;
		
		for (int i = 0; i < input.size(); i++) {
			switch (input.get(i)) {
				case "A X": result += 3; break;
				case "A Y": result += 4; break;
				case "A Z": result += 8; break;
				case "B X": result += 1; break;
				case "B Y": result += 5; break;
				case "B Z": result += 9; break;
				case "C X": result += 2; break;
				case "C Y": result += 6; break;
				case "C Z": result += 7; break;
			}	
		}
		return String.valueOf(result);
	}
}
