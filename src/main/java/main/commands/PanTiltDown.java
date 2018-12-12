package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltDown extends ViscaCommand implements PanSpeed,TiltSpeed{
    private final byte[] ptUpCommandData = new byte[]{1, 6, 1, 0, 0, 3, 2};

    public PanTiltDown(SerialPort serialPort) {
        super(serialPort);
    }


    @Override
    public void execute() {
        this.commandData = duplicateArray(ptUpCommandData);
        changePanSpeed((byte) 3);
        changeTiltSpeed((byte) 2);
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
