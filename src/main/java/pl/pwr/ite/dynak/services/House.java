package pl.pwr.ite.dynak.services;

import pl.pwr.ite.dynak.services.interfaces.IHouse;
import pl.pwr.ite.dynak.services.interfaces.IOffice;

public class House implements IHouse, IOffice {
    @Override
    public int getPumpOut(int max) {
        return 0;
    }

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
}
