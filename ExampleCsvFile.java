import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


class ExampleCsvFile {
    public static void read_food() {
        FileResource csvdata = new FileResource();

        CSVParser parser = csvdata.getCSVParser();

        for(CSVRecord record : parser){
            System.out.println(record.get("name"));
        }
    }

    public static void main(String[] args) {
        read_food();
    }
}
