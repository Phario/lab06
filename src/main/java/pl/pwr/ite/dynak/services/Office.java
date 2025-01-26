package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IOffice;

@Getter
@Setter
public class Office implements IOffice{

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
