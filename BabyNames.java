/**
 * babys names queried in csv files
 * 
 * @author:  Victor Pereira
 * @version: 27/12/2019
 * 
 */

import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

class BabyNames {
    
    public void PrintAllNames(int year){
        String FILENAME = "us_babynames/us_babynames_by_year/" + "yob" + year+ ".csv";

        FileResource fr = new FileResource(FILENAME);

        for (CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));

            if (numBorn <= 100){
                System.out.println( "name: "+ record.get(0)+
                                    "\tGender: " + record.get(1)+
                                    "\tNum born : " + record.get(2));
            }
        }
    }

    public void TotalBirths(int year){
        String FILENAME = "us_babynames/us_babynames_test/example-small.csv";

        FileResource fr = new FileResource(FILENAME);
        Long TotalB = 0L;

        for (CSVRecord record : fr.getCSVParser()){
            TotalB += Long.parseLong(record.get(2));
        }   

        System.out.println(TotalB);
    }

    public static void main(String[] args) {
        BabyNames ForTest = new BabyNames();
        // ForTest.PrintAllNames(1999);
        ForTest.TotalBirths(1);
    }
}