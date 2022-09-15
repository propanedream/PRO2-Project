package opgave6;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\PRO2-Project\\L05  - Java collections\\src\\opgave6\\output.txt"));
//        writer.write("Writing to file.");
//        writer.write("\nWriting to file.");
//        writer.close();


public class App {
    public static void main(String[] args) throws IOException {

        Map<String, ArrayList<String>> movieGrades = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\PRO2-Project\\L05  - Java collections\\src\\opgave6\\film"));
        String lines = reader.readLine();
        System.out.println("antal karakterer givet: " + lines);
        String key;
        while ((key = reader.readLine()) != null) {
            ArrayList<String> list;

            if (!key.equalsIgnoreCase("")) {
                if (movieGrades.containsKey(key)) {
                    list = movieGrades.get(key);
                    list.add(reader.readLine());
                } else {
                    list = new ArrayList<>();
                    list.add(reader.readLine());
                    movieGrades.put(key, list);
                }
            }
        }
        System.out.println(movieGrades.entrySet());
        for (Map.Entry<String, ArrayList<String>> entry : movieGrades.entrySet()) {
            double averageGrade = 0;
            double counter = 0;
            for (String s : entry.getValue()) {
                averageGrade += Integer.parseInt(s);
                counter++;
            }
            System.out.println(entry.getKey() + averageGrade / counter);
        }
        reader.close();
    }
}
