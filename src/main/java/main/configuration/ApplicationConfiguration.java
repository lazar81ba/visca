package main.configuration;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public SerialPort serialPort(){
        SerialPort serialPort = new SerialPort("COM3");
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
        return serialPort;
    }
}
