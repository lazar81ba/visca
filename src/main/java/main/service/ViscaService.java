package main.service;



public interface ViscaService {
    String up();
    String down();
    String right();
    String left();
    String zoomTele();
    String zoomWide();
    String home();
    String absolute();
    String getMaxSpeed();
    String clearAll();
    String sendAddress();
    String focusNear();
    String focusFar();
}
