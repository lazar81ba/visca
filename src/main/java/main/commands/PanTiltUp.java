package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltUp extends ViscaCommand {
    private final byte[] ptUpCommandData = new byte[]{1, 6, 1, 0, 0, 3, 1};

    public PanTiltUp(SerialPort serialPort) {
        super(serialPort);
    }


    @Override
    public void execute() {
        this.commandData = duplicateArray(ptUpCommandData);
        this.commandData[3] = 1;
        this.commandData[4] = 2;
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
