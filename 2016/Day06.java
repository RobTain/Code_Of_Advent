package CoA2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day06 {
	
	public static void main(String[] args) {
		Path filePath = Path.of("Input2016_06.txt");
		List<String> input = new LinkedList<String>();

		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line;
			while ((line = reader.readLine()) != null) {
				input.add(line);
			}
		} catch (IOException e) { e.printStackTrace(); }
		
		System.out.println("Ergebnis Teil 1: " + getHighestLetterCount(sortVertical(input)));
		System.out.println("Ergebnis Teil 2: " + getLowestLetterCount(sortVertical(input)));
	}
	

	private static String getHighestLetterCount(String[] strings) {
		String result = ""; 
		
		for (int[] occurance : occuranceLetters(strings)) {
			int max = 0;
			char c = 0;
			for (int i = 0; i < occurance.length; i++) {
				if (occurance[i] > max) {
		                max = occurance[i];
		                c = (char) i;
		            }
		        }
			result += c;
		}
		return result;
	}


	private static String getLowestLetterCount(String[] strings) {
		String result = ""; 
		
		for (int[] occurance : occuranceLetters(strings)) {
			int min = Integer.MAX_VALUE;
			char c = 0;
			for (int i = 0; i < occurance.length; i++) {
				if (occurance[i] < min && occurance[i] > 0) {
		                min = occurance[i];
		                c = (char) i;
		            }
		        }
			result += c;
		}
		return result;
	}
	
	private static String[] sortVertical(List<String> input) {
		String[] vertical = new String[input.getFirst().length()];
		Arrays.fill(vertical, "");
		for (String string : input) {
			for (int i = 0; i < vertical.length; i++) {
				vertical[i] += string.charAt(i);
			}		
		}
		return vertical;
	}
	
	private static List<int[]> occuranceLetters(String[] strings) {
		List<int[]> results = new LinkedList<int[]>();
		
		for (int i = 0; i < strings.length; i++) {
			String tmp = strings[i];
			
			int[] anzahl = new int[256];
			Arrays.fill(anzahl, 0);
			for (int j = 0; j < tmp.length(); j++) {
				anzahl[(int) tmp.charAt(j)]++;
			}
			results.add(anzahl);
		}
		return results;
	}
}
