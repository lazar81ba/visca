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
    public String up() {
        return viscaCommandInvoker.executeCommand(new PanTiltUp(serialPort));
    }

    @Override
    public String down() {
        return viscaCommandInvoker.executeCommand(new PanTiltDown(serialPort));
    }

    @Override
    public String right() {
        return viscaCommandInvoker.executeCommand(new PanTiltRight(serialPort));
    }

    @Override
    public String left() {
        return viscaCommandInvoker.executeCommand(new PanTiltLeft(serialPort));
    }

    @Override
    public String zoomTele() {
        return viscaCommandInvoker.executeCommand(new ZoomTele(serialPort));

    }

    @Override
    public String zoomWide() {
        return viscaCommandInvoker.executeCommand(new ZoomWide(serialPort));

    }

    @Override
    public String home() {
        return viscaCommandInvoker.executeCommand(new PanTiltHome(serialPort));

    }

    @Override
    public String absolute() {
        return viscaCommandInvoker.executeCommand(new PanTiltAbsolute(serialPort));

    }

    @Override
    public String getMaxSpeed() {
        return viscaCommandInvoker.executeCommand(new GetPanTiltMaxSpeed(serialPort));
    }

    @Override
    public String clearAll() {
        return viscaCommandInvoker.executeCommand(new ClearAll(serialPort));

    }

    @Override
    public String sendAddress() {
        return viscaCommandInvoker.executeCommand(new SendAdrress(serialPort));
    }

    @Override
    public String focusNear() {
        return viscaCommandInvoker.executeCommand(new FocusNear(serialPort));
    }

    @Override
    public String focusFar() {
        return viscaCommandInvoker.executeCommand(new FocusFar(serialPort));
    }
}
