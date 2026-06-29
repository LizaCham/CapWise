package src;

import java.io.*;
import java.util.ArrayList;

public class CollegeData {

    private ArrayList<College> colleges;

    public CollegeData() {

        colleges = new ArrayList<>();
        parseCSV();
    }

    private void parseCSV() {

        try {

            BufferedReader reader = new BufferedReader(
                new FileReader("src/ScoreBoardCollegeData.csv")
            );

            // ================= HEADER =================

            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            int schoolIndex = findColumn(headers, "INSTNM");
            int cityIndex = findColumn(headers, "CITY");
            int stateIndex = findColumn(headers, "STABBR");
            int tuitionIndex = findColumn(headers, "TUITIONFEE_IN");
            int satIndex = findColumn(headers, "SAT_AVG");
            int actIndex = findColumn(headers, "ACTCM25");

            // ================= DATA =================

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                String name = values[schoolIndex];
                String city = values[cityIndex];
                String state = values[stateIndex];

                double tuition = parseDouble(values[tuitionIndex]);
                int sat = parseInt(values[satIndex]);
                int act = parseInt(values[actIndex]);

                College school = new College(name, city, state, tuition, sat, act);

                colleges.add(school);
            }

            reader.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // ================= Helper Methods =================

    private int findColumn(String[] headers, String columnName) {

        for (int i = 0; i < headers.length; i++) {

            if (headers[i].equals(columnName)) {
                return i;
            }
        }

        return -1;
    }

    private int parseInt(String value) {

        if (value == null || value.equals("") || value.equals("NA")) {
            return -1;
        }

        return Integer.parseInt(value);
    }

    private double parseDouble(String value) {

        if (value == null || value.equals("") || value.equals("NA")) {
            return -1;
        }

        return Double.parseDouble(value);
    }

    // ================= Getter =================

    public ArrayList<College> getColleges() {

        return colleges;
    }
}