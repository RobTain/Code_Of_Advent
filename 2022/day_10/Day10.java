package day_10;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import util.CoA_Interface;

public class Day10 implements CoA_Interface {
	
	
	public static void main(String[] args) throws Exception {
		
		Day10 day10 = new Day10();
		LinkedList<String> input = new LinkedList<String>();

		day10.readInput(input);
		
		System.out.println("Solution - Part 1: " + day10.result01(input));
		System.out.println("Solution - Part 2: " + day10.result02(input));
		
	}

	public void readInput(LinkedList<String> input) throws Exception {
		Scanner in = new Scanner(new File("src/" + this.getClass().getPackageName() + "/" + this.getClass().getSimpleName() + "_input.txt")); 
		while(in.hasNextLine()) {
			input.add((String) in.nextLine());
		}
	}

	public String result01(LinkedList<String> input) {
		int result = 0; 
	
		int time = 1, count = 1;

		
		for (String string : input) {
	
			time++;
			
			if (time == 20 || time == 60 || time == 100 || time == 140 || time == 180 || time == 220) {
				result += (time * count);
				System.out.println(time);
				System.out.println(count);
				System.out.println(time * count);
			} 
			
			if (string.contains("addx")) {
				time++;
				count += Integer.parseInt(string.split(" ")[1]);

				if ( time == 20 || time == 60 || time == 100 || time == 140 || time == 180 || time == 220) {

					result += (time * count);
					System.out.println(time);
					System.out.println(count);
					System.out.println(time * count);
				} 
				
			}
		}
			
		return String.valueOf(result);
	}

	public String result02(LinkedList<String> input) {
		int result = 0;
		return String.valueOf(result);
	}
}
