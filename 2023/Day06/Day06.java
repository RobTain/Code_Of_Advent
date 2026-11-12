package Day06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day06 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;


	public static void main(String[] args) {
		Day06 day06 = new Day06();
		Day06.solution(day06);
		System.out.println("Solution 1: " + day06.getSolution1());
		System.out.println("Solution 2: " + day06.getSolution2());
	}

	private static void solution(Day06 day06) {
		try {
			in = new Scanner(new FileReader("./src/Day06/Day06.txt"));
			String time = "", distance = "";
			while (in.hasNext()) {
				time = in.nextLine();
				distance = in.nextLine();
				break;
			}
			day06.setSolution1(day06.getSolution1() + firstSolution(time, distance));
			day06.setSolution2(day06.getSolution2() + secondSolution(time, distance));
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
	}

	private static int firstSolution(String time, String distance) {
		String[] timePerRaces = time.replace("Time: ", "").strip().split("     ");
		String[] distancePerRace = distance.replace("Distance: ", "").strip().split("   ");
		
		int solution = 1;
		for (int i = 0; i < timePerRaces.length; i++) {
			int timeForRace = Integer.parseInt(timePerRaces[i]);
			int distanceForRace = Integer.parseInt(distancePerRace[i]);
			
			int result = 0; 
			for (int j = 1; j < timeForRace; j++) {
				if (((timeForRace-j) * j) > distanceForRace) {
					System.out.println((timeForRace-j) * j + " : "+ distanceForRace);
					result++;
				}
			}
			System.out.println(result);
			solution *= result;
		}
		return solution;
	}
	
	private static int secondSolution(String time, String distance) {
		double timeRace = Double.parseDouble(time.replace("Time: ", "").strip().replace(" ", ""));
		double distanceRace = Double.parseDouble(distance.replace("Distance: ", "").strip().replace(" ", ""));
		
		
		int result = 0; 
		
		for (int j = 1; j < timeRace; j++) {
			if (((timeRace-j) * j) > distanceRace) {
				result++;
			}
		}
			
		return result;
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
