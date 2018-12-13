package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltLeft extends ViscaCommand {
    private final byte[] ptLeftCommandData = new byte[]{1, 6, 1, 0, 0, 1, 3};

    public PanTiltLeft(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptLeftCommandData);
        this.commandData[3] = panSpeed;
        this.commandData[4] = tiltSpeed;
        System.out.println("Pan tilt left");
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
