package pl.pwr.ite.dynak.services;

import pl.pwr.ite.dynak.services.interfaces.IOffice;
import pl.pwr.ite.dynak.services.interfaces.ISewagePlant;
import pl.pwr.ite.dynak.services.interfaces.ITanker;

public class Office implements IOffice, ITanker, ISewagePlant {

    @Override
    public int register(String host, String port) {
        return 0;
    }

    @Override
    public int order(String host, String port) {
        return 0;
    }

    @Override
    public void setReadyToServe(int number) {

    }

    @Override
    public void setPumpIn(int number, int volume) {

    }

    @Override
    public int getStatus(int number) {
        return 0;
    }

    @Override
    public void setPayoff(int number) {

    }

    @Override
    public void setJob(String host, String port) {

    }
}
