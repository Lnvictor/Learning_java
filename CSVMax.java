/*
 *
 * 
 * This program consuting csv files wich indicates temperature a day
 * in a determined year, and returns the day wich contains a greather temperature
 * of the year
 * 
 * @author: Victor Pereira
 * version: 26/12/2019
 * 
 */

import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class CSVMax {
    
    public CSVRecord WhichMostLargestRecord(CSVRecord largest, CSVRecord                                                  currentRow){

        if(largest == null){
            return currentRow;
        }

        if (Double.parseDouble(currentRow.get("TemperatureF")) > Double.parseDouble(largest.get("TemperatureF"))){
            return currentRow;
        }
        return largest;
    }

    
    public CSVRecord whichMaxTempinDay(CSVParser parser){

        CSVRecord largestsofar = null;

        for (CSVRecord record : parser){
            
            largestsofar = WhichMostLargestRecord(largestsofar, record);
        }

        return largestsofar;
    }

    
    public CSVRecord whichMaxTempinDays(){
        DirectoryResource directory = new DirectoryResource();
        CSVRecord largest = null;

        for (File file : directory.selectedFiles()) {
            FileResource f = new FileResource(file);
            
            largest = WhichMostLargestRecord(largest, whichMaxTempinDay(f.getCSVParser()));
        }

        return largest;
    }
    
    
    private void test_whichMaxTemp(){
        FileResource f = new FileResource("/home/victor/Learning_java/data_airport/2014/weather-2014-02-19.csv");

        CSVRecord result = whichMaxTempinDay(f.getCSVParser());

        System.out.println(result.get("TemperatureF"));
    }

    
    private void test_whichMaxTempinDays(){
        CSVRecord record = whichMaxTempinDays();
        System.out.println  (record.get("DateUTC")+"\t"+record.get("TemperatureF")                       +"\t"+record.get("TimeEDT")
                            );
    }

    
    public static void main(String[] args) {
        CSVMax test = new CSVMax();
        test.test_whichMaxTempinDays();
    }
}