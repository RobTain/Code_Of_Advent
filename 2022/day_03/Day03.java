package day_03;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import util.CoA_Interface;

public class Day03 implements CoA_Interface {
	
	
	public static void main(String[] args) throws Exception {
		
		Day03 day03 = new Day03();
		LinkedList<String> input = new LinkedList<String>();

		day03.readInput(input);
		
		System.out.println("Solution - Part 1: " + day03.result01(input));
		System.out.println("Solution - Part 2: " + day03.result02(input));
		
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
			String firstCompartment = input.get(i).substring(0, input.get(i).length()/2);
			String secondCompartment = input.get(i).substring(input.get(i).length()/2, input.get(i).length());

			boolean found = false; 
			for (int j = 0; j < firstCompartment.length(); j++) {
				for (int k = 0; k < secondCompartment.length(); k++) {
					if (firstCompartment.charAt(j) == secondCompartment.charAt(k)) {
						found = true;
						if (Character.isLowerCase(firstCompartment.charAt(j))) { result += (firstCompartment.charAt(j) - 96); } else { result += (firstCompartment.charAt(j) - 38);}
						break;
					}
				}
				if (found) { break; }
			}
		}
		return String.valueOf(result);
	}

	public String result02(LinkedList<String> input) {
		int result = 0;
		for (int i = 0; i < input.size(); i+=3) {
			String firstElf = input.get(i);
			String secondElf = input.get(i+1);
			String thirdElf = input.get(i+2);
			
			boolean found = false; 
			for (int j = 0; j < firstElf.length(); j++) {
				for (int k = 0; k < secondElf.length(); k++) {
					for (int l = 0; l < thirdElf.length(); l++) {
						if (firstElf.charAt(j) == secondElf.charAt(k) && firstElf.charAt(j) == thirdElf.charAt(l)) {
							found = true;
							if (Character.isLowerCase(firstElf.charAt(j))) { result += (firstElf.charAt(j) - 96); } else { result += (firstElf.charAt(j) - 38);}
							break;
						}
					}
					if (found) {break;}
				}
				if (found) {break;}
			}
		}
		return String.valueOf(result);
	}
}
