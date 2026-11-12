package day_06;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import util.CoA_Interface;

public class Day06 implements CoA_Interface {
	
	
	public static void main(String[] args) throws Exception {
		
		Day06 day06 = new Day06();
		LinkedList<String> input = new LinkedList<String>();

		day06.readInput(input);
		
		System.out.println("Solution - Part 1: " + day06.result01(input));
		System.out.println("Solution - Part 2: " + day06.result02(input));
		
	}

	public void readInput(LinkedList<String> input) throws Exception {
		Scanner in = new Scanner(new File("src/" + this.getClass().getPackageName() + "/" + this.getClass().getSimpleName() + "_input.txt")); 
		while(in.hasNextLine()) {
			input.add((String) in.nextLine());
		}
	}

	public String result01(LinkedList<String> input) {
		int result = 0, leftboundary = 0, rightBoundary = 4;
		String dataStream = input.element();
		
		while (true) {
			String subString = dataStream.substring(leftboundary, rightBoundary);
			
			boolean check = false;
			for (int i = 0; i < subString.length(); i++) {
				char currentChar = subString.charAt(i);
			     
			    if (subString.indexOf(currentChar, i + 1) != -1) { check = true; }
			}
			
			if (!check) { result = rightBoundary; break;}
			
			leftboundary++;
			rightBoundary++;
		}
		return String.valueOf(result);
	}

	public String result02(LinkedList<String> input) {
		int result = 0, leftboundary = 0, rightBoundary = 14;
		String dataStream = input.element();
		
		while (true) {
			String subString = dataStream.substring(leftboundary, rightBoundary);
			
			boolean check = false;
			for (int i = 0; i < subString.length(); i++) {
				char currentChar = subString.charAt(i);
			     
			    if (subString.indexOf(currentChar, i + 1) != -1) { check = true; }
			}
			
			if (!check) { result = rightBoundary; break;}
			
			leftboundary++;
			rightBoundary++;
		}
		return String.valueOf(result);
	}
}
