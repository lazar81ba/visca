package main.commands;

import jssc.SerialPort;

public abstract class ViscaCommand implements Destination, TiltSpeed,PanSpeed{
    protected byte sourceAdr = 0;
    protected byte destinationAdr = 1;
    protected byte[] commandData;
    protected byte panSpeed = 6;
    protected byte tiltSpeed = 6;

    SerialPort serialPort;

    public ViscaCommand(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public abstract void execute();

    protected byte[] getCommandData() {
        int cmdLen = this.commandData.length + 1 + 1;
        byte[] cmdData = new byte[cmdLen];
        byte head = (byte)(128 | (this.sourceAdr & 7) << 4 | this.destinationAdr & 15);
        byte tail = -1;
        System.arraycopy(this.commandData, 0, cmdData, 1, this.commandData.length);
        cmdData[0] = head;
        cmdData[cmdData.length - 1] = tail;
        return cmdData;
    }

    protected byte[] duplicateArray(byte[] src) {
        byte[] dest = new byte[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }

    @Override
    public void changePanSpeed(byte speed) {
        this.panSpeed = speed;

    }

    @Override
    public void changeTiltSpeed(byte speed) {
        this.tiltSpeed = speed;
    }

}
