package inventory_system.drivers;
import inventory_system.readers.CSV_Reader;
/**
 * @author Gianni Coladonato
 * @version 1.1
 * @since 18/02/2020
 */
public class Driver {

    public static void main(String[] args) {
        CSV_Reader c1 = new CSV_Reader("data/Inventory_A.csv","data/Inventory_B.csv");
        c1.parse();
    }
}