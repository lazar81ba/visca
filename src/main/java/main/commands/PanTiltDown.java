package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltDown extends ViscaCommand{
    private final byte[] ptUpCommandData = new byte[]{1, 6, 1, 0, 0, 3, 2};

    public PanTiltDown(SerialPort serialPort) {
        super(serialPort);
    }


    @Override
    public void execute() {
        this.commandData = duplicateArray(ptUpCommandData);
        this.commandData[3] = panSpeed;
        this.commandData[4] = tiltSpeed;
        System.out.println("Pan tilt down");
        try {
            serialPort.writeBytes(getCommandData());
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void changeDestination(byte dest) {
        this.destinationAdr = dest;
    }
}
