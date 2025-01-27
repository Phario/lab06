package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IOffice;
import pl.pwr.ite.dynak.utils.Method;

import java.util.ArrayList;

@Getter
@Setter
public class Office extends SocketUser implements IOffice{
    private static int staticTankerId = 0;
    private ArrayList<Tanker> tankers;
    private ArrayList<Integer> readyTankerIds;
    public Office(int port) {
        super(port);
    }

    @Override
    public void handleRequest(Method method) {

    }

    @Override
    public int register(String host, String port) {

        return staticTankerId++;
    }

    @Override
    public int order(String host, String port) {
        return 0;
    }

    @Override
    public void setReadyToServe(int number) {

    }
}
