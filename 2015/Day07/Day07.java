package Day07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;



public class Day07 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;
	static LinkedList<Test> result = new LinkedList<>();

	public static void main(String[] args) {
		Day07 day07 = new Day07();
		Day07.solution(day07);
		System.out.println("Solution 1: " + day07.getSolution1());
		System.out.println("Solution 2: " + day07.getSolution2());
	}

	private static void solution(Day07 day07) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day07/Day07.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.nextLine());
				day07.setSolution1(day07.getSolution1() + solution1(sb.toString()));
				day07.setSolution2(day07.getSolution2() + solution2(sb.toString()));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
		
		for (Test test : result) {
			System.out.println(test.getLetter() + ": " + test.getValue());
		}
	}

	private static int solution1(String string) {
		if (string.contains("AND")) {
			String wire1 = string.split(" -> ")[0].split(" AND ")[0];
			String wire2 = string.split(" -> ")[0].split(" AND ")[1];
			String wire3 = string.split(" -> ")[1];
			
			// check wire exist
			boolean checkValue = false;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					checkValue = true;
				}
			}
			
			// add non existing wire
			if (!checkValue) {
				result.add(new Test(string.split(" -> ")[1], 0));
			}
			
			// get information
			int value1 = 0, value2 = 0, value3 = 0;
			for (Test test : result) {
				if (test.getLetter().equals(wire1)) {
					value1 = test.getValue();
				}
				
				if (test.getLetter().equals(wire2)) {
					value2 = test.getValue();
				}
			}
			
			// calculate and store information
			value3 = value1 & value2;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					test.setValue(value3);
				}
			}
		} else if (string.contains("OR")) {
			String wire1 = string.split(" -> ")[0].split(" OR ")[0];
			String wire2 = string.split(" -> ")[0].split(" OR ")[1];
			String wire3 = string.split(" -> ")[1];
			
			// check wire exist
			boolean checkValue = false;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					checkValue = true;
				}
			}
			
			// add non existing wire
			if (!checkValue) {
				result.add(new Test(string.split(" -> ")[1], 0));
			}
			
			// get information
			int value1 = 0, value2 = 0, value3 = 0;
			for (Test test : result) {
				if (test.getLetter().equals(wire1)) {
					value1 = test.getValue();
				}
				
				if (test.getLetter().equals(wire2)) {
					value2 = test.getValue();
				}
			}
			
			// calculate and store information
			value3 = value1 | value2;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					test.setValue(value3);
				}
			}
			
		} else if (string.contains("LSHIFT")) {
			String wire1 = string.split(" -> ")[0].split(" LSHIFT ")[0];
			int value2 = Integer.parseInt(string.split(" -> ")[0].split(" LSHIFT ")[1]);
			String wire3 = string.split(" -> ")[1];
			
			// check wire exist
			boolean checkValue = false;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					checkValue = true;
				}
			}
			
			// add non existing wire
			if (!checkValue) {
				result.add(new Test(string.split(" -> ")[1], 0));
			}
			
			// get information
			int value1 = 0, value3 = 0;
			for (Test test : result) {
				if (test.getLetter().equals(wire1)) {
					value1 = test.getValue();
				}
			}
			
			// calculate and store information
			value3 = value1 << value2;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					test.setValue(value3);
				}
			}			
		} else if (string.contains("RSHIFT")) {
			String wire1 = string.split(" -> ")[0].split(" RSHIFT ")[0];
			int value2 = Integer.parseInt(string.split(" -> ")[0].split(" RSHIFT ")[1]);
			String wire3 = string.split(" -> ")[1];
			
			// check wire exist
			boolean checkValue = false;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					checkValue = true;
				}
			}
			
			// add non existing wire
			if (!checkValue) {
				result.add(new Test(string.split(" -> ")[1], 0));
			}
			
			// get information
			int value1 = 0, value3 = 0;
			for (Test test : result) {
				if (test.getLetter().equals(wire1)) {
					value1 = test.getValue();
				}
			}
			
			// calculate and store information
			value3 = value1 >> value2;
			for (Test test : result) {
				if (test.getLetter().equals(wire3)) {
					test.setValue(value3);
				}
			}	
		} else if (string.contains("NOT")) {
			String wire1 = string.split(" -> ")[0].replace("NOT ", "");
			System.out.println(wire1);
			String wire2 = string.split(" -> ")[1];
						
			// check wire exist
			boolean checkValue = false;
			for (Test test : result) {
				if (test.getLetter().equals(wire2)) {
					checkValue = true;
				}
			}
			
			// add non existing wire
			if (!checkValue) {
				result.add(new Test(string.split(" -> ")[1], 0));
			}
			
			// get information
			int value1 = 0;
			for (Test test : result) {
				if (test.getLetter().equals(wire1)) {
					value1 = test.getValue();
				}
			}
			
			// calculate and store information
			for (Test test : result) {
				if (test.getLetter().equals(wire2)) {
					test.setValue(u16neg(value1));
				}
			}	
		} else {
			// new element
			result.add(new Test(string.split(" -> ")[1], Integer.parseInt(string.split(" -> ")[0])));
		}
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
	
	public static int u16neg(int i) {
	    return ~i & 0xFFFF;
	}

}

class Test {
	private String letter;
	private int value;
	
	public Test(String letter, int value) {
		this.setLetter(letter);
		this.setValue(value);
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
