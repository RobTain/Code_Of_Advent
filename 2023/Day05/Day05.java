package Day05;

import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.util.Arrays;
//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
import java.util.Scanner;

public class Day05 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;


	public static void main(String[] args) {
		Day05 day05 = new Day05();
		Day05.solution(day05);
		System.out.println("Solution 1: " + day05.getSolution1());
	}

	private static void solution(Day05 day05) {
		LinkedList<String> input = new LinkedList<String>();
		try {
			in = new Scanner(new FileReader("./src/Day05/Day05.txt"));
			while (in.hasNext()) {
				String tmp = in.nextLine();
				if (!tmp.isBlank()) {
					input.add(tmp);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
		
		day05.setSolution1(solution1(input));
	}

	private static int solution1(LinkedList<String> input) {
//		double[] seeds = Arrays.stream(input.get(0).split(": ")[1].split(" ")).mapToDouble(Double::parseDouble).toArray();
		
		// create Sublists
//		List<String> subListSoil = createSubList(input, "seed-to-soil map:", "soil-to-fertilizer map:");
//		List<String> subListFertilizer = createSubList(input, "soil-to-fertilizer map:", "fertilizer-to-water map:");
//		List<String> subListWater = createSubList(input, "fertilizer-to-water map:", "water-to-light map:");
//		List<String> subListLight = createSubList(input, "water-to-light map:", "light-to-temperature map:");
//		List<String> subListTemperature = createSubList(input, "light-to-temperature map:", "temperature-to-humidity map:");
//		List<String> subListHumidity = createSubList(input, "temperature-to-humidity map:", "humidity-to-location map:");
//		List<String> subListLocation = createSubList(input, "humidity-to-location map:", null);
		
//		for (String string : subListFertilizer) {
//			System.out.println(string);
//		}
//		
//		// Test
//		Map<Double, Double> test = new HashMap<>();
//		for (String string : subListFertilizer) {
//			String[] tmp = string.split(" ");
//			double source = Double.parseDouble(tmp[1]);
//			double destination = Double.parseDouble(tmp[0]);
//			for (double i = 0; i < Double.parseDouble(tmp[2]); i++) {
//				test.put(source, destination);
//				source++;
//				destination++;
//			}
//		}
//        
//        //fill map with additional values
//        for (double d = Arrays.stream(seeds).min().getAsDouble(); d <=  Arrays.stream(seeds).max().getAsDouble(); d++) {
//        	if (!test.containsKey(d)) {
//        		test.put(d, d);
//        	}
//        }
//		
//        for (Double i : test.keySet()) {
//            System.out.println(i + " - " + test.get(i));
//		}
		
		return 0;
	}

	
//	private static List<String> createSubList(LinkedList<String> input, String start, String end) {
//		if (end != null) {
//			return input.subList((input.indexOf(start) + 1), (input.indexOf(end)));
//		} else {
//			return input.subList((input.indexOf(start) + 1), input.size());
//		}
//	}

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
