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
    
    public CSV_Reader(String csv1, String csv2){
        this.csvFilePathA = csv1;
        this.csvFilePathB = csv2;
    }
    
    /**
     * Parses the data from the two CSV files and returns the EPC codes as a List.
     * @return A list of EPC Codes representing the Inventory.
     */
    public List<Item> parse() {
        
        CSVReader reader = null;
        this.inventory = new ArrayList();
        this.secondInventory = new ArrayList();
        int num = 1;
        
        //First Inventory
        try {
            reader = new CSVReader(new FileReader(csvFilePathA));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] nextLine;
        try {
            while((nextLine = reader.readNext()) != null) { 
                
            Item item = new Item(nextLine[0]);
//            System.out.println(num + " " + item);
            inventory.add(item);
            num += 1;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        System.out.println("Second Inventory");
        num = 1;
        //Second Inventory
        try {
            reader = new CSVReader(new FileReader(csvFilePathB));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while((nextLine = reader.readNext()) != null) { 
                
            Item item = new Item(nextLine[0]);
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
    public List<Item> uniqueACodes(CSV_Reader c1){
        c1.parse();
        List <Item> uniqueA = new ArrayList();
        for(int i = 0; i < inventory.size(); i++){
            boolean code = true;
            for (int j = 0; j < secondInventory.size(); j++){
                if(inventory.get(i).getEPCCode().equals(secondInventory.get(j).getEPCCode()))
                    code = false;
                    }
            if(code)
                uniqueA.add(inventory.get(i));
        }
//        for(int i = 0; i < inventory.size(); i++){
//            for(int j = 0; j < secondInventory.size(); j++){
//                if(!secondInventory.get(j).equals(inventory.get(i))){
//                    uniqueA.add(inventory.get(i));
//                    break;
//                }
//            }
//        }
        return uniqueA;
    }
    /**
     * Compares EPC codes from the two CSV files and verifies whether they are
     * equivalent or contain different EPC codes
     * @param c1
     * @return boolean output whether files are equivalent
     */
    public boolean equivalency(CSV_Reader c1){
        c1.parse();
        
        return secondInventory.containsAll(inventory);
    }
    /**
     * Compares EPC codes from the two CSV files and verifies what codes have 
     * been removed
     * @param c1, the csv reader
     * @return the list of removed EPC codes
     */
    public List<Item> uniqueBCodes(CSV_Reader c1){
        c1.parse(); 
        //find missing epc codes
        List <Item> uniqueB = new ArrayList();
        for(int i = 0; i < secondInventory.size(); i++){
            boolean code = true;
            for( int  j = 0; j < inventory.size(); j++){
                if(secondInventory.get(i).getEPCCode().equals(inventory.get(j).getEPCCode()))
                    code = false;
            }
            if(code)
                uniqueB.add(secondInventory.get(i));
        }
        return uniqueB;
    }
    
    public List<Item> similarCodes(CSV_Reader cl){
        cl.parse();
        List<Item> similar = new ArrayList();
        for(int i = 0; i < inventory.size(); i++){
            boolean code = false;
            for(int j = 0; j < secondInventory.size(); j++){
                if(inventory.get(i).getEPCCode().equals(secondInventory.get(j).getEPCCode()))
                    code = true;
            }
            if(code)
                similar.add(inventory.get(i));
        }
        return similar;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getSecondInventory() {
        return secondInventory;
    }

    public void setSecondInventory(List<Item> secondInventory) {
        this.secondInventory = secondInventory;
    }
}