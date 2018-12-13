package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class ZoomWide extends ViscaCommand {

    private final byte[] ptWideStdCommandData = new byte[]{1, 4, 7, 3};

    public ZoomWide(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptWideStdCommandData);
        System.out.println("Zooming wide");
        try {
            serialPort.writeBytes(getCommandData());
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void changeDestination(byte dest) {
        this.destinationAdr=dest;
    }


    @Override
    public void changePanSpeed(byte speed) {

    }

    @Override
    public void changeTiltSpeed(byte speed) {

    }
}
