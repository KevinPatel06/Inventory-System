package inventory_system.readers;
import com.opencsv.CSVReader;
import inventory_system.drivers.Driver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import inventory_system.models.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 18/02/2020
 */
public class CSV_Reader {
    
    private List<Item> inventory;
    private List<Item> secondInventory;
    private final String csvFilePathA;
    private final String csvFilePathB;
    
    public CSV_Reader(String csv){
        this.csvFilePathA = "data/Inventory_A.csv";
        this.csvFilePathB = "data/Inventory_B.csv";
    }
    
    /**
     * Parses the data from the two CSV files and returns the EPC codes as a List.
     * @return A list of EPC Codes representing the Inventory.
     */
    public List<Item> parse(String pathA, String pathB) {
        
        CSVReader reader = null;
        this.inventory = new ArrayList();
        this.secondInventory = new ArrayList();
        int num = 1;
        
        //First Inventory
        try {
            reader = new CSVReader(new FileReader(pathA));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] nextLine;
        try {
            while((nextLine = reader.readNext()) != null) { 
                
            Item item = new Item(nextLine[0]);
            System.out.println(num + " " + item);
            inventory.add(item);
            num += 1;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Second Inventory");
        num = 1;
        //Second Inventory
        try {
            reader = new CSVReader(new FileReader(pathB));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while((nextLine = reader.readNext()) != null) { 
                
            Item item = new Item(nextLine[0]);
            System.out.println(num + " " + item);
            secondInventory.add(item);
            num += 1;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventory;
    }
    
    /**
     * Compares EPC codes from the two CSV files and verifies what EPC codes have
     * been added
     * @param c1, the csv reader
     * @return list of added codes
     */
    public List<Item> addedCodes(CSV_Reader c1, String pathA, String pathB){
        c1.parse(pathA, pathB);
        //find any added epc codes
        inventory.removeAll(secondInventory);
       
        return inventory;
    }
    /**
     * Compares EPC codes from the two CSV files and verifies whether they are
     * equivalent or contain different EPC codes
     * @param c1
     * @return boolean output whether files are equivalent
     */
    public boolean equivalency(CSV_Reader c1, String pathA, String pathB){
        c1.parse(pathA, pathB);
        
        return secondInventory.containsAll(inventory);
    }
    /**
     * Compares EPC codes from the two CSV files and verifies what codes have 
     * been removed
     * @param c1, the csv reader
     * @return the list of removed EPC codes
     */
    public List<Item> removedCodes(CSV_Reader c1, String pathA, String pathB){
        c1.parse(pathA, pathB); 
        //find missing epc codes
        secondInventory.removeAll(inventory);
        
        return secondInventory;
    }
}