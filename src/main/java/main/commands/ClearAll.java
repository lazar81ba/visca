package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class ClearAll extends ViscaCommand {

    private final byte[] clearAllCommandData = new byte[]{1, 0, 1};

    public ClearAll(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(clearAllCommandData);
        this.destinationAdr = 8;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
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
