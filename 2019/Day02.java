Paket CoA2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


öffentliche Klasse Day02 {


public static void main(String[] args) {
  Path filePath = Path.of("Input2019_02.txt");
  List<String> input = new LinkedList<String>();
  try (BufferedReader reader = Files.newBufferedReader(filePath)) {

Zeichenkette;

while ((line = reader.readLine()) != null) {

input.add(line);

}

} catch (IOException e) {

e.printStackTrace();

}


System.out.println("Ergebnis Teil 1: " + positionZero(input, 12, 2, -1));


for (int i = 0; i < 100; i++) {

for (int j = 0; j < 100; j++) {

String tmp = positionZero(input, i, j, 19690720);

if (tmp != null) {

System.out.println("Ergebnis Teil 2: " + tmp);

}

}

}

}


private static String positionZero(List<String> input, int position1, int position2, int checkResult) {

String result = null;

int[] values ​​= createValues(input);


Werte[1] = Position1;

values[2] = position2;


boolescher Wert: check = false;

for (int i = 0; i < values.length; i += 4) {

switch (values[i]) {

Fall 1 -> Werte[Werte[i + 3]] = Werte[Werte[i + 1]] + Werte[Werte[i + 2]];

Fall 2 -> Werte[Werte[i + 3]] = Werte[Werte[i + 1]] * Werte[Werte[i + 2]];

Fall 99 -> Prüfung = wahr;

}

if (check) { break; }

}


if (checkResult == -1) {

result = String.valueOf(values[0]);

} else if (checkResult == values[0]) {

result = String.valueOf(100 * values[1] + values[2]);

}


Ergebnis zurückgeben;

}


private static int[] createValues(List<String> input) {

return input.stream().flatMap(s -> Arrays.stream(s.split(","))).mapToInt(Integer::parseInt).toArray();

}

}
