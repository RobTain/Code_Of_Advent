package CoA2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Day03 {

	public static void main(String[] args) {
		Path filePath = Path.of("Input2016_03.txt");
		List<String> input = new LinkedList<String>();

		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line;
			while ((line = reader.readLine()) != null) {
				input.add(line);
			}
		} catch (IOException e) { e.printStackTrace(); }

		System.out.println("Ergebnis Teil 1: " + calculatePossibleTriangles(input));
		System.out.println("Ergebnis Teil 2: " + calculateVerticalPossibleTriangles(input));
	}

	private static int calculateVerticalPossibleTriangles(List<String> input) {
		List<String> verticalInput = new LinkedList<String>();
		
		// Matrix anpassen
		for (int i = 0; i < input.size(); i=i+3) {
			String[] tmp0 = input.get(i).trim().split("\\s+");
			String[] tmp1 = input.get(i+1).trim().split("\\s+");
			String[] tmp2 = input.get(i+2).trim().split("\\s+");
			
			String newLine0 = tmp0[0] + " " + tmp1[0] + " " + tmp2[0];
			String newLine1 = tmp0[1] + " " + tmp1[1] + " " + tmp2[1];
			String newLine2 = tmp0[2] + " " + tmp1[2] + " " + tmp2[2];

			verticalInput.add(newLine0);
			verticalInput.add(newLine1);
			verticalInput.add(newLine2);
		}
		return calculatePossibleTriangles(verticalInput);
	}

	private static int calculatePossibleTriangles(List<String> input) {
		int result = 0;
		for (String string : input) {
			// Auslesen der einzelnen Variablen
			String[] parts = string.trim().split("\\s+");
	        int a = Integer.parseInt(parts[0]);
	        int b = Integer.parseInt(parts[1]);
	        int c = Integer.parseInt(parts[2]);
	        
	        // Prüfung des Dreiecks
	        if ((a + b > c) && (a + c > b) && (b + c > a)) {
	            result+= 1;
	        } 
		}
		return result;
	}

}
