package CoA2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Day02 {

	public static void main(String[] args) {
		Path filePath = Path.of("Input2016_02.txt");
		List<String> input = new LinkedList<String>();
		int[][] keypad = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line;
			while ((line = reader.readLine()) != null) {
				input.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Ergebnis Teil 1: " + calculateCode(input, keypad));
	}

	private static String calculateCode(List<String> input, int[][] keypad) {
		String result = "";
		int x = 1;
		int y = 1;
	
		for (String instruction : input) {
			for (char c : instruction.toCharArray()) {
				switch (c) {
					case 'U' -> { if (y > 0) { y--; } }	
					case 'D' -> { if (y < 2) { y++; } }
					case 'L' -> { if (x > 0) { x--; } }
					case 'R' -> { if (x < 2) { x++; } }
				}
				
			}
			result += keypad[y][x];
		}
		return result;
	}
}
