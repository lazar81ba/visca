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
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }


}
