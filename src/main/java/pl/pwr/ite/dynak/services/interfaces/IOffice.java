package pl.pwr.ite.dynak.services.interfaces;

public interface IOffice {
    int register(String host, String port);
    int order(String host, String port);
    void setReadyToServe(int number);
}
