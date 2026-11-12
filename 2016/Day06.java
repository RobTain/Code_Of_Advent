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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String solution01 = getHighestLetterCount(sortVertical(input));
		String solution02 = getLowestLetterCount(sortVertical(input));
		
		
		System.out.println("Ergebnis Teil 1: " + solution01);
		System.out.println("Ergebnis Teil 2: " + solution02);
	}
	
	

	private static String getHighestLetterCount(String[] strings) {
		String result = ""; 
		
		// Vorkommen von Buchstaben berechnen
		for (int i = 0; i < strings.length; i++) {
			String tmp = strings[i];
			
			// Vorkommen der Buchstaben zählen
			int[] anzahl = new int[256];
			Arrays.fill(anzahl, 0);
			for (int j = 0; j < tmp.length(); j++) {
				anzahl[(int) tmp.charAt(j)]++;
			}

			// Größten Buchstaben finden
			int max = 0;
			char c = 0;
		    for (int j = 0; j < anzahl.length; j++) {
		            if (anzahl[j] > max) {
		                max = anzahl[j];
		                c = (char) j;
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

	private static String getLowestLetterCount(String[] strings) {
		String result = ""; 
		
		// Vorkommen von Buchstaben berechnen
		for (int i = 0; i < strings.length; i++) {
			String tmp = strings[i];
			
			// Vorkommen der Buchstaben zählen
			int[] anzahl = new int[256];
			Arrays.fill(anzahl, 0);
			for (int j = 0; j < tmp.length(); j++) {
				anzahl[(int) tmp.charAt(j)]++;
			}
			
			// Größten Buchstaben finden
			int min = Integer.MAX_VALUE;
			char c = 0;
		    for (int j = 0; j < anzahl.length; j++) {
		            if (anzahl[j] < min && anzahl[j] > 0) {
		                min = anzahl[j];
		                c = (char) j;
		            }
		        }
		    result += c;
		}	
	
		return result;
	}
	
}
