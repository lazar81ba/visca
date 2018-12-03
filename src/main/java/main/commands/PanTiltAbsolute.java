package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class PanTiltAbsolute extends ViscaCommand{
    private final byte[] ptAbsolutePosCommandData = new byte[]{1, 6, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public PanTiltAbsolute(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(ptAbsolutePosCommandData);
        this.commandData[3] = 1;
        this.commandData[5] = 0;
        this.commandData[6] = 3;
        this.commandData[7] = 7;
        this.commandData[8] = 5;
        this.commandData[9] = 0;
        this.destinationAdr = 1;
        System.out.println("@ " + ByteArrayToStringConverter.convert(getCommandData()));
        try {
            serialPort.writeBytes(this.commandData);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
