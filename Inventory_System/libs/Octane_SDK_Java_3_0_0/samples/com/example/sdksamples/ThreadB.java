package com.example.sdksamples;

/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 19/04/2020
 */
public class ThreadB extends Thread {
    
    @Override
    public void run() {
        String[] args=null;
        ImageSceneLoader.main(args);
        
        }
}