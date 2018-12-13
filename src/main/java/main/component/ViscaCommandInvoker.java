package main.component;

import jssc.SerialPort;
import jssc.SerialPortException;
import main.converters.ByteArrayToStringConverter;
import main.commands.ViscaCommand;
import main.readers.ViscaResponseReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ViscaCommandInvoker {

    private SerialPort serialPort;
    private byte destinationAddress = 1;
    private byte tiltSpeed=4;
    private byte panSpeed=4;
    private int timeSec = 1;

    @Autowired
    public ViscaCommandInvoker(SerialPort serialPort){
        this.serialPort = serialPort;
    }


    private final List<ViscaCommand> commandHistory = new LinkedList<>();



    public String executeCommand(ViscaCommand viscaCommand){
        viscaCommand.changeDestination(this.destinationAddress);
        viscaCommand.changePanSpeed(this.panSpeed);
        viscaCommand.changeTiltSpeed(this.tiltSpeed);
        viscaCommand.execute();
        commandHistory.add(viscaCommand);
        byte[] response;
        String responseToReturn = "";
        try {
            response = ViscaResponseReader.readResponse(serialPort);
            if((ByteArrayToStringConverter.convert(response)).charAt(3) == '4'){
                System.out.println("> ACK" );
                responseToReturn = "ACK";
            }
            else if((ByteArrayToStringConverter.convert(response)).charAt(3) == '5'){
                System.out.println("> Completion" );
                responseToReturn = "Completion";
            }
            else if((ByteArrayToStringConverter.convert(response)).charAt(3) == '3'){
                System.out.println("> Address set" );
                responseToReturn = "Address set";
            }
            else if((ByteArrayToStringConverter.convert(response)).charAt(3) == '6'){
                System.out.println("> Error" );
                responseToReturn = "error";
            }
            else{
                System.out.println(">Unknown" );
                responseToReturn = "unknown";
            }

        } catch (ViscaResponseReader.TimeoutException var17) {
            System.out.println("! TIMEOUT exception");
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep((long)(timeSec * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
        return responseToReturn;
    }

    public void setSleepTime(int seconds){
        this.timeSec = seconds;
    }

    public byte getPanSpeed() {
        return panSpeed;
    }

    public void setPanSpeed(byte panSpeed) {
        this.panSpeed = panSpeed;
    }

    public byte getTiltSpeed() {
        return tiltSpeed;
    }

    public void setTiltSpeed(byte tiltSpeed) {
        this.tiltSpeed = tiltSpeed;
    }

    public byte getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(byte destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
