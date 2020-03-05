
package com.example.sdksamples;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;


public class Search {
    
    
     public void epcSearch(String epc) throws SQLException, LineUnavailableException
    {
     
        Connection conn = null;
        Statement stmt = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beep","root","mahsa123"); 
        stmt = (Statement)conn.createStatement();
        
        
         String query="select * from items;";
         ResultSet rs = stmt.executeQuery(query);
                 
           while (rs.next())
                   {
                       if (epc.equals(rs.getString("EPC")))
                       {   
                           
                               SoundUtils.tone(1000,100);
                          
                       }
       
                   }   
          
    }
}
