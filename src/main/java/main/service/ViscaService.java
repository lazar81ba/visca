package main.service;



public interface ViscaService {
    void up();
    void down();
    void right();
    void left();
    void zoomTele();
    void zoomWide();
    void home();
    void absolute();
    void getMaxSpeed();
    void clearAll();
    void sendAddress();
    void focusNear();
    void focusFar();
}
