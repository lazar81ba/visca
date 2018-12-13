package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltHome extends ViscaCommand {
    private final byte[] ptHomeCommandData = new byte[]{1, 6, 4};

    public PanTiltHome(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptHomeCommandData);
        System.out.println("Pan tilt home");
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

    @Override
    public void changePanSpeed(byte speed) {

    }

    @Override
    public void changeTiltSpeed(byte speed) {

    }
}
