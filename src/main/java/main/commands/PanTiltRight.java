package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltRight extends ViscaCommand {
    private final byte[] ptRightCommandData = new byte[]{1, 6, 1, 0, 0, 2, 3};

    public PanTiltRight(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptRightCommandData);
        this.commandData[3] = panSpeed;
        this.commandData[4] = tiltSpeed;
        System.out.println("Pan tilt right");
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
}
