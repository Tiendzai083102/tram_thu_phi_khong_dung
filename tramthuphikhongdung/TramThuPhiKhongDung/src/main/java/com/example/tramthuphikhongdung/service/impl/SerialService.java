package com.example.tramthuphikhongdung.service.impl;

import com.fazecast.jSerialComm.SerialPort;

import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SerialService {

    private SerialPort serialPort;

    public void initializeSerialPort(String portName) {
        serialPort = SerialPort.getCommPort(portName);
        serialPort.openPort();
    }
    @Async
    public void readFromSerialPort() {
    	while(true) {
            Scanner sc  = new Scanner(serialPort.getInputStream());
            PrintWriter pw = new PrintWriter(serialPort.getOutputStream());
            String a = "";
    		while(sc.hasNextLine()){
                a = sc.nextLine();
                System.out.println(a);
                if(a.equals("6300284")){                                             
                    pw.write("123456");
                    pw.flush();
                }else{
                   pw.write("false");
                    pw.flush();                      
                }            
    		}
    	}	
    }

    public void closeSerialPort() {
        serialPort.closePort();
    }
}
