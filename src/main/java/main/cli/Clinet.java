package main.cli;
import jssc.SerialPort;
import jssc.SerialPortException;
import main.commands.*;
import main.component.ViscaCommandInvoker;

import java.util.Scanner;

public class Clinet {
    public static void main(String [] args){
        SerialPort serialPort = new SerialPort("COM3");
        byte destinationAddress = 1;
        byte tiltSpeed=4;
        byte panSpeed=4;

        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
        Scanner reader = new Scanner(System.in);
        ViscaCommandInvoker viscaCommandInvoker = new ViscaCommandInvoker(serialPort);
        viscaCommandInvoker.setDestinationAddress(destinationAddress);
        viscaCommandInvoker.setPanSpeed(panSpeed);
        viscaCommandInvoker.setTiltSpeed(tiltSpeed);
        System.out.println("Witaj w programie do obsługi kamery VISCA!");
        System.out.println("Komendy, które możesz użyć:");
        System.out.println("ClearAll,PanTiltHome,PanTiltLeft,PanTiltRight,PanTiltUp,ZoomTele,ZoomWide,PanTiltAbsolute," +
                "changeTiltSpeed, changePanSpeed, destination ");
        while(true){
            System.out.print("Podaj komendę : ");
            String s = reader.next();
            switch (s){
                case "ClearAll":
                    viscaCommandInvoker.executeCommand(new ClearAll(serialPort));
                    break;
                case "PanTiltHome":
                    viscaCommandInvoker.executeCommand(new PanTiltHome(serialPort));
                    break;
                case "PanTiltRight":
                    viscaCommandInvoker.executeCommand(new PanTiltRight(serialPort));
                    break;
                case "PanTiltLeft":
                    viscaCommandInvoker.executeCommand(new PanTiltLeft(serialPort));
                    break;
                case "PanTiltUp":
                    viscaCommandInvoker.executeCommand(new PanTiltUp(serialPort));
                    break;
                case "PanTiltDown":
                    viscaCommandInvoker.executeCommand(new PanTiltDown(serialPort));
                    break;
                case "ZoomTele":
                    viscaCommandInvoker.executeCommand(new ZoomTele(serialPort));
                    break;
                case "ZoomWide":
                    viscaCommandInvoker.executeCommand(new ZoomWide(serialPort));
                    break;
                case "SendAddress1":
                    viscaCommandInvoker.executeCommand(new SendAdrress(serialPort));
                    break;
                case "SendAddress2":
                    viscaCommandInvoker.executeCommand(new SendAddress2(serialPort));
                    break;

                case "PanTiltAbsolute":
                    viscaCommandInvoker.executeCommand(new PanTiltAbsolute(serialPort));
                    break;
                case "changePanSpeed":
                    System.out.println("Podaj speed 1-16");
                    s = reader.next();
                    viscaCommandInvoker.setPanSpeed(Byte.parseByte(s));
                    break;
                case "changeTiltSpeed":
                    System.out.println("Podaj speed 1-16");
                    s = reader.next();
                    viscaCommandInvoker.setTiltSpeed(Byte.parseByte(s));
                    break;
                case "destination":
                    System.out.println("Podaj destination 1-8");
                    s = reader.next();
                    viscaCommandInvoker.setDestinationAddress(Byte.parseByte(s));
                    break;
            }
        }
    }

}
