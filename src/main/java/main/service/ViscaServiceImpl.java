package main.service;

import jssc.SerialPort;
import main.commands.*;
import main.component.ViscaCommandInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViscaServiceImpl implements ViscaService{

    @Autowired
    ViscaCommandInvoker viscaCommandInvoker;

    @Autowired
    private SerialPort serialPort;

    public ViscaServiceImpl(ViscaCommandInvoker viscaCommandInvoker){
        this.viscaCommandInvoker = viscaCommandInvoker;
    }

    @Override
    public void up() {
        viscaCommandInvoker.executeCommand(new PanTiltUp(serialPort));
    }


    @Override
    public void right() {
        viscaCommandInvoker.executeCommand(new PanTiltRight(serialPort));
    }

    @Override
    public void left() {
        viscaCommandInvoker.executeCommand(new PanTiltLeft(serialPort));

    }

    @Override
    public void zoomTele() {
        viscaCommandInvoker.executeCommand(new ZoomTele(serialPort));

    }

    @Override
    public void zoomWide() {
        viscaCommandInvoker.executeCommand(new ZoomWide(serialPort));

    }

    @Override
    public void home() {
        viscaCommandInvoker.executeCommand(new PanTiltHome(serialPort));

    }

    @Override
    public void absolute() {
        viscaCommandInvoker.executeCommand(new PanTiltAbsolute(serialPort));

    }

    @Override
    public void getMaxSpeed() {
        viscaCommandInvoker.executeCommand(new GetPanTiltMaxSpeed(serialPort));
    }

    @Override
    public void clearAll() {
        viscaCommandInvoker.executeCommand(new ClearAll(serialPort));

    }

    @Override
    public void sendAddress() {
        viscaCommandInvoker.executeCommand(new SendAdrress(serialPort));
    }
}
