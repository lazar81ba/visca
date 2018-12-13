package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class GetPanTiltMaxSpeed extends ViscaCommand {
    private final byte[] maxSpeedCommandData = new byte[]{9, 6, 17};

    public GetPanTiltMaxSpeed(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(maxSpeedCommandData);
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
