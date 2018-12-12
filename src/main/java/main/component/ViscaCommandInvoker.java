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

    @Autowired
    private SerialPort serialPort;

    private int timeSec = 1;


    private final List<ViscaCommand> commandHistory = new LinkedList<>();

    public void executeCommand(ViscaCommand viscaCommand){
        viscaCommand.execute();
        commandHistory.add(viscaCommand);
        byte[] response;
        try {
            response = ViscaResponseReader.readResponse(serialPort);
            System.out.println("> " + ByteArrayToStringConverter.convert(response));
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
    }

    public void setSleepTime(int seconds){
        this.timeSec = seconds;
    }
}
