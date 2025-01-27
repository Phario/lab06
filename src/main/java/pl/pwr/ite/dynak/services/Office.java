package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IOffice;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
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
    public int handleRequest(Method method) {
        return switch (method.methodName()) {
            case "r" -> register(method.host(), method.parameter());
            case "o" -> order(method.host(), method.parameter());
            case "sr" -> {
                setReadyToServe(Integer.parseInt(method.parameter()));
                yield 0;
            }
            default -> throw new InvalidMethodException();
        };
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
