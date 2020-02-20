package inventory_system.models;
/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 18/02/2020
 */
public class Item {
    private String EPCcode;
    
    /**
     * Creates an Item using the Serial Number of the product, as a String.
     * @param EPCcode The EPC Code of the product being entered 
     * as a String.
    */
    public Item(String EPCcode){
        setEPCCode(EPCcode);
    }
    
    /**
     * Sets a new Serial Number of a product as a String.
     * @param EPCcode The new Serial Number of the product as a String.
     */
    public void setEPCCode(String EPCcode){
        this.EPCcode = EPCcode;
    }
    
    /**
     * Returns the Serial Number of the product as a String.
     * @return The Serial Number of the product as a String.
     */
    public String getEPCCode(){
        return this.EPCcode;
    }
    
    @Override
    public String toString(){
        String str = "";
        str += "EPC Code : " + getEPCCode();
        return str;
    }
}