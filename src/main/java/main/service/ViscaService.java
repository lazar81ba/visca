package main.service;



public interface ViscaService {
    void up();
    void down();
    void right();
    void left();
    void zoomTele();
    void zoomWide();
    void setSleep(int seconds);
    void home();
}
