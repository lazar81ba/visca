package main.service;

import jssc.SerialPortException;
import main.component.ViscaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViscaServiceImpl implements ViscaService{

    @Autowired
    ViscaComponent viscaComponent;

    private int seconds=1;

    public ViscaServiceImpl(ViscaComponent viscaComponent){
        this.viscaComponent = viscaComponent;
    }

    @Override
    public void up() {
        try {
            viscaComponent.sendPanTiltUp();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void down() {
        try {
            viscaComponent.sendPanTiltDown();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void right() {
        try {
            viscaComponent.sendPanTiltRight();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void left() {
        try {
            viscaComponent.sendPanTiltLeft();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void zoomTele() {
        try {
            viscaComponent.sendZoomTeleStd();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void zoomWide() {
        try {
            viscaComponent.sendZoomWideStd();
            viscaComponent.sleep(seconds);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSleep(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void home() {
        try {
            viscaComponent.sendPanTiltHome();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
