package pl.pwr.ite.dynak.services.interfaces;

public interface ISewagePlant {
    void setPumpIn(int number, int volume);
    int getStatus(int number);
    void setPayoff(int number);
}
