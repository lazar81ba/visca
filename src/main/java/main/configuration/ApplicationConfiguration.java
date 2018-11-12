package main.configuration;

import jssc.SerialPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public SerialPort serialPort(){
        return new SerialPort("COM3");
    }
}
