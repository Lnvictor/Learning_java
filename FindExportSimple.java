/**
 * This program gets a product export and find wich country
 * export it
 * 
 * @author: Victor Pereira
 * @version: 27/12/2019
 */

import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class FindExportSimple {
    public StorageResource FindContryExporters(CSVParser parser, String exportOfInterest) {

        StorageResource countries = new StorageResource();

        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportOfInterest)) {
                countries.add(record.get("Country"));
            }
        }

        return countries;
    }

    private void test_FindCountryExporters() {
        FileResource csvdata = new FileResource("/home/victor/Learning_java/exports/exports_small_Ms.csv");
        CSVParser parser = csvdata.getCSVParser();

        for (String country : FindContryExporters(parser, "whisky").data()) {
            if (!country.isEmpty()) {
                System.out.println("TESTS FAILED");
            }
        }

        System.out.println("Tests finish");
    }

    public static void main(String[] args) {
        FindExportSimple f = new FindExportSimple();

        f.test_FindCountryExporters();
    }
}