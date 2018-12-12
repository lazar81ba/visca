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
        viscaCommandInvoker.setSleepTime(10);
        viscaCommandInvoker.executeCommand(new PanTiltUp(serialPort));
    }

    @Override
    public void down() {
        viscaCommandInvoker.setSleepTime(10);
        viscaCommandInvoker.executeCommand(new PanTiltDown(serialPort));
    }

    @Override
    public void right() {

        viscaCommandInvoker.setSleepTime(16);
        viscaCommandInvoker.executeCommand(new PanTiltRight(serialPort));
    }

    @Override
    public void left() {
        viscaCommandInvoker.setSleepTime(16);
        viscaCommandInvoker.executeCommand(new PanTiltLeft(serialPort));
    }

    @Override
    public void zoomTele() {
        viscaCommandInvoker.setSleepTime(10);
        viscaCommandInvoker.executeCommand(new ZoomTele(serialPort));

    }

    @Override
    public void zoomWide() {
        viscaCommandInvoker.setSleepTime(10);
        viscaCommandInvoker.executeCommand(new ZoomWide(serialPort));

    }

    @Override
    public void home() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new PanTiltHome(serialPort));

    }

    @Override
    public void absolute() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new PanTiltAbsolute(serialPort));

    }

    @Override
    public void getMaxSpeed() {
        viscaCommandInvoker.setSleepTime(10);
        viscaCommandInvoker.executeCommand(new GetPanTiltMaxSpeed(serialPort));
    }

    @Override
    public void clearAll() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new ClearAll(serialPort));

    }

    @Override
    public void sendAddress() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new SendAdrress(serialPort));
    }

    @Override
    public void focusNear() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new FocusNear(serialPort));
    }

    @Override
    public void focusFar() {
        viscaCommandInvoker.setSleepTime(5);
        viscaCommandInvoker.executeCommand(new FocusFar(serialPort));
    }
}
