package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ClearAll extends ViscaCommand {

    private final byte[] clearAllCommandData = new byte[]{1, 0, 1};

    public ClearAll(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(clearAllCommandData);
        this.destinationAdr = 8;
        System.out.println("@ " + byteArrayToString(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
