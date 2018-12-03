package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class ZoomTele extends ViscaCommand {

    private final byte[] ptTeleStdCommandData = new byte[]{1, 4, 7, 2};

    public ZoomTele(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptTeleStdCommandData);
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
