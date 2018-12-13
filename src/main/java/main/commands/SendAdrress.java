package main.commands;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;

public class SendAdrress extends ViscaCommand{
    private final byte[] adrCommmandData = new byte[]{48,2};

    public SendAdrress(SerialPort serialPort) {
        super(serialPort);
    }

    @Override
    public void execute() {
        this.commandData = duplicateArray(adrCommmandData);
        this.destinationAdr=8;
        System.out.println("Send address 1");
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
