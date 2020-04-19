package com.example.sdksamples;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import inventory_system.controllers.FXMLOnlineInventoryController;
import inventory_system.models.Item;
import java.util.List;

public class TagReportListenerImplementation implements TagReportListener {
    private static int i=0;
    private String EPCcode;
    private String imagePath;
    
    public void setEPCcode(){
        this.EPCcode = FXMLOnlineInventoryController.EPCcode;
    }
    
    public void setImage(){
        this.imagePath = FXMLOnlineInventoryController.primePath;
    }
  
    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        
        setEPCcode();
        setImage();
       
        Search[] mySearch=new Search[1000000];
        for (int k=0;k<1000000;k++)
        {
           mySearch[k]=new Search();
        }
        MyData[] tagArray=new MyData[1000000];   
        for (int j=0;j<1000000;j++)
        {
            tagArray[j]=new MyData();
        }
        
        List<Tag> tags = report.getTags();
       
        Item item;
        
        for (Tag t : tags)
        {
            String epcCode = t.getEpc().toString();
            item = new Item(epcCode);

            if(epcCode.equalsIgnoreCase(this.EPCcode)){
                System.out.println(EPCcode);
                System.out.println(reader.getAddress());
                System.out.println(imagePath);
                break;
            }      
            else{
                System.out.println("EPC codes do not match");
            } 
            
            tagArray[i].set_epc(t.getEpc().toString());
            /*
            if (reader.getAddress() != null){
               
               System.out.println(" Reader_ip: " + reader.getAddress());
               tagArray[i].set_reader_ip(reader.getAddress());
              
            }
            else {
                 
                System.out.print(" Reader_name: " + reader.getName());
                 tagArray[i].set_reader_name(reader.getName());
                
            } 

            if (t.isAntennaPortNumberPresent()) {
                System.out.print(" antenna: " + t.getAntennaPortNumber());
                tagArray[i].set_ant_port(t.getAntennaPortNumber());
               
             
            }

            if (t.isFirstSeenTimePresent()) {
                System.out.print(" first: " + t.getFirstSeenTime().ToString());
                tagArray[i].set_first_seen(t.getFirstSeenTime().ToString());
                 
            }

            if (t.isLastSeenTimePresent()) {
                System.out.print(" last: " + t.getLastSeenTime().ToString());
                tagArray[i].set_last_seen(t.getLastSeenTime().ToString());
                 
            }

            if (t.isSeenCountPresent()) {
                System.out.print(" count: " + t.getTagSeenCount());
               tagArray[i].set_count(t.getTagSeenCount());
               
            }
            if (t.isRfDopplerFrequencyPresent()) {
                System.out.print(" doppler: " + t.getRfDopplerFrequency());
               tagArray[i].set_doppler(t.getRfDopplerFrequency());
              
            }

            if (t.isPeakRssiInDbmPresent()) {
                System.out.print(" peak_rssi: " + t.getPeakRssiInDbm());
               tagArray[i].set_rssi(t.getPeakRssiInDbm());
              
                
            }

            if (t.isChannelInMhzPresent()) {
                System.out.print(" chan_MHz: " + t.getChannelInMhz());
               tagArray[i].set_channel(t.getChannelInMhz());
              
            }

            if (t.isFastIdPresent()) {
                System.out.print("\n     fast_id: " + t.getTid().toHexString());

                System.out.print(" model: " +
                        t.getModelDetails().getModelName());

                System.out.print(" epcsize: " +
                        t.getModelDetails().getEpcSizeBits());

                System.out.print(" usermemsize: " +
                        t.getModelDetails().getUserMemorySizeBits());
            }

            */
        //  System.out.println("");
       //   System.out.println(tagArray[i].toString());
           
         /*  if (t.getEpc().toString().equals("0000 0000 0000 0000 1005 0895"))
           {
                try {
                    reader.setGpo(2, true);
                } catch (OctaneSdkException ex) {
                    Logger.getLogger(TagReportListenerImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
 
           */
        // tagArray[i].get_EPC().replaceAll(" ","");
        // System.out.println("+++++++++++++++++++++++++++++++++++");
        // System.out.println(tagArray[i].get_EPC().replaceAll(" ","+"));
        /*  String[] args=null;
         PostToPareto.DEVICE_ID=tagArray[i].get_EPC().replaceAll(" ","8");
         PostToPareto.createJSON(PostToPareto.DEVICE_ID,"001bc50940820000", 123);
         PostToPareto.main(args);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TagReportListenerImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        /*
        
            try {
                
                try {
                    mySearch[i].epcSearch(tagArray[i].get_EPC());
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(TagReportListenerImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TagReportListenerImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
             */
            ++i;
        }
        
    }
   }