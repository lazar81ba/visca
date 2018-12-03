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
        this.commandData[3] = 8;
        this.commandData[4] = 1;
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
