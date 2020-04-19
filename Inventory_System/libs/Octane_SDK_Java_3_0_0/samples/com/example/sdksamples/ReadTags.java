package com.example.sdksamples;

import com.impinj.octane.*;

import java.util.Scanner;


public class ReadTags {

    private static ImpinjReader reader;
    
    private static String EPCcode;
    
    public static void setEPC(String epcCode){
        ReadTags.EPCcode = epcCode;
    }
    
    public static void main(String[] args) {

        try {
            String hostname = System.getProperty(SampleProperties.hostname);

            if (hostname == null) {
                throw new Exception("Must specify the '"
                        + SampleProperties.hostname + "' property");
            }

            reader = new ImpinjReader();

            System.out.println("Connecting");
            reader.connect("192.168.2.225");

            Settings settings = reader.queryDefaultSettings();

            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(true);
            report.setMode(ReportMode.Individual);
            //GpoConfigGroup gpos = settings.getGpos();
           // gpos.getGpo((short) 1).setMode(GpoMode.ReaderInventoryStatus);

            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments.
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader’s configuration
            settings.setReaderMode(ReaderMode.AutoSetDenseReader);
            settings.setSearchMode(SearchMode.DualTarget);

            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            //antennas.disableAll();
            antennas.enableById(new short[]{1,2,3,4});
            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
            antennas.getAntenna((short) 1).setTxPowerinDbm(12.0);
            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);
             antennas.getAntenna((short) 2).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 2).setIsMaxTxPower(false);
            antennas.getAntenna((short) 2).setTxPowerinDbm(12.0);
            antennas.getAntenna((short) 2).setRxSensitivityinDbm(-70);
             antennas.getAntenna((short) 3).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 3).setIsMaxTxPower(false);
            antennas.getAntenna((short) 3).setTxPowerinDbm(12.0);
            antennas.getAntenna((short) 3).setRxSensitivityinDbm(-70);
             antennas.getAntenna((short) 4).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 4).setIsMaxTxPower(false);
            antennas.getAntenna((short) 4).setTxPowerinDbm(12.0);
            antennas.getAntenna((short) 4).setRxSensitivityinDbm(-70);

            TagReportListenerImplementation tagOne = new TagReportListenerImplementation();
            reader.setTagReportListener(tagOne);
            

            System.out.println("Applying Settings");
            reader.applySettings(settings);

            System.out.println("Starting");
            reader.start();

            System.out.println("Press Enter to exit.");
            Scanner s = new Scanner(System.in);
            s.nextLine();

            reader.stop();
            reader.disconnect();
        } catch (OctaneSdkException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}
