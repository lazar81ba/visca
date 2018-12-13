package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class FocusFar extends ViscaCommand {

    private final byte[] ptFocusFarCommandData = new byte[]{1, 4, 8, 2};

    public FocusFar(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptFocusFarCommandData);
        System.out.println("Focusing far");
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
