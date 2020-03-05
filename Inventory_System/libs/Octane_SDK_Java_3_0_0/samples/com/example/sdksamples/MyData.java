
package com.example.sdksamples;

class MyData {
    private String id;
    private String epc;
    private String reader_ip;
    private String reader_name;
    private short ant_port;
    private String first_seen;
    private String last_seen;
    private short count;
    private double rssi;
    private double channel;
    private double doppler;
   
    
    
    
    public String get_ID(){
        return id;
    }

    public String get_EPC() {
        return epc;
    }
    
    
    public String get_reader_ip() {
        return reader_ip;
    }
    
    public String get_reader_name() {
        return reader_name;
    }
    
     public short get_ant_port() {
        return ant_port;
    }
      public String get_first_seen() {
        return first_seen;
    }
       public String get_last_seen() {
        return last_seen;
    }
     public short get_count() {
        return count;
    }
      public double get_rssi() {
        return rssi;
    }
       public double get_channel() {
        return channel;
    }
        public double get_doppler() {
        return doppler;
    }
    
      public void set_ID(String id1){
        id=id1;
    } 
     public void set_epc(String epc1){
        epc=epc1;
    } 
      public void set_reader_ip(String reader_ip1){
        reader_ip=reader_ip1;
    } 
       public void set_reader_name(String reader_name1){
        reader_name=reader_name1;
    } 
        public void set_ant_port(short ant_port1){
       ant_port=ant_port1;
    } 
         public void set_first_seen(String first_seen1){
        first_seen=first_seen1;
    } 
          public void set_last_seen(String last_seen1){
        last_seen=last_seen1;
    } 
           public void set_count(short count1){
        count=count1;
    } 
            public void set_rssi(double rssi1){
        rssi=rssi1;
    } 
             public void set_channel(double channel1){
        channel=channel1;
    } 
       public void set_doppler(double doppler1){
        doppler=doppler1;
    } 
       
    public String toString() {
    return ("********************\n" + "ID= "+ id+"\nEPC= "+epc+"\nFirst Seen= "+ first_seen+"\nantenna= "
            +ant_port);
  }  
        
}