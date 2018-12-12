package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltRight extends ViscaCommand implements PanSpeed,TiltSpeed {
    private final byte[] ptRightCommandData = new byte[]{1, 6, 1, 0, 0, 2, 3};

    public PanTiltRight(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptRightCommandData);
        changePanSpeed((byte) 4);
        changeTiltSpeed((byte) 1);
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePanSpeed(byte speed) {
        this.commandData[3] = speed;

    }

    @Override
    public void changeTiltSpeed(byte speed) {
        this.commandData[4] = speed;
    }
}
