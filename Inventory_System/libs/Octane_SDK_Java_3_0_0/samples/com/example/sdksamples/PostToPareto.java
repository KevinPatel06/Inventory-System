package com.example.sdksamples;

import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.net.MalformedURLException;
import java.io.IOException;

// -----------------------------------
// To compile: javac PostToPareto.java
// To run: java PostToPareto
// -----------------------------------
public class PostToPareto {

//= "ff112233445566778899aabbccddee00"
  public static final String TARGET_URL = "http://pareto.reelyactive.com:80/events";
  public static  String DEVICE_ID="ff112233445566778899aabbccddee77";
  public static final String RECEIVER_ID = "001bc50940820000";
  public static final int DEFAULT_RSSI = 123;

  // This method creates the JSON that will be sent to Pareto
  public static byte[] createJSON(String deviceId,
                                  String receiverId,
                                  int rssi) {
    Date now = new Date();
    String json = "{\"event\":\"appearance\",";
    json += "\"tiraid\":{";
    json += "\"identifier\":{";
    json += "\"type\":\"EPC-24\",";
    json += "\"value\":\"" + deviceId + "\"},";
    json += "\"timestamp\":" + now.getTime() + ",";
    json += "\"radioDecodings\":[{";
    json += "\"rssi\":" + rssi + ",";
    json += "\"identifier\":{";
    json += "\"type\":\"EUI-64\",";
    json += "\"value\":\"" + receiverId + "\"}}]}}";
    return json.getBytes();
  }

  // This method performs the HTTP POST to Pareto
  public static void main(String[] args) {
    try {
      URL url = new URL(TARGET_URL);
      URLConnection con = url.openConnection();
      HttpURLConnection http = (HttpURLConnection)con;
      http.setRequestMethod("POST");
      http.setDoOutput(true);

      // ---------------------------------------------------------------
      // This is where you would replace DEVICE_ID with the 128-bit EPC,
      // all lowercase, no spaces or separators!
      byte[] json = createJSON(DEVICE_ID, RECEIVER_ID, DEFAULT_RSSI);
      // ---------------------------------------------------------------

      http.setFixedLengthStreamingMode(json.length);
      http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      http.connect();
      try(OutputStream os = http.getOutputStream()) {
        os.write(json);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(http.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();
        System.out.println(http.getResponseCode() + ": " + response.toString());
      }
    }
    catch(MalformedURLException e) {
      System.err.println(e.getMessage());
    }
    catch(IOException e) {
      System.err.println(e.getMessage());
    }
  }

}
