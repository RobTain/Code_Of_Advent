package day_01;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import util.CoA_Interface;

public class Day01 implements CoA_Interface {
	
	
	public static void main(String[] args) throws Exception {
		
		Day01 day01 = new Day01();
		LinkedList<String> input = new LinkedList<String>();

		day01.readInput(input);
		
		System.out.println("Solution - Part 1: " + day01.result01(input));
		System.out.println("Solution - Part 2: " + day01.result02(input));
		
	}

	public void readInput(LinkedList<String> input) throws Exception {
		Scanner in = new Scanner(new File("src/" + this.getClass().getPackageName() + "/" + this.getClass().getSimpleName() + "_input.txt")); 
		while(in.hasNextLine()) {
			input.add((String) in.nextLine());
		}
	}

	public String result01(LinkedList<String> input) {
		int result = 0,temp = 0;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).equals("")) {
				if (result < temp) { result = temp; }
				temp = 0;
			} else { temp += Integer.parseInt(input.get(i)); }
		}
		return String.valueOf(result);
	}

	public String result02(LinkedList<String> input) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int temp = 0;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).equals("")) { 
				list.add(temp); 
				temp = 0;
			} else { temp += Integer.parseInt(input.get(i)); }
		}
		
		Collections.sort(list, Collections.reverseOrder());
		return String.valueOf(list.get(0) + list.get(1) + list.get(2));

		
		
	}
}
