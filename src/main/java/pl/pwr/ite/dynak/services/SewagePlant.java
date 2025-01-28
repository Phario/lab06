package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ISewagePlant;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;
import pl.pwr.ite.dynak.utils.TankerData;

import java.util.ArrayList;

@Getter
@Setter
public class SewagePlant extends SocketUser implements ISewagePlant {
    ArrayList<TankerData> tankerData = new ArrayList<>();
    public SewagePlant(int port) {
        super(port);
    }
    @Override
    public int handleRequest(Method method) {
        return switch (method.methodName()) {
            case "gs" -> getStatus(Integer.parseInt(method.parameter()));
            case "spo" -> {
                setPayoff(Integer.parseInt(method.parameter()));
                yield 0;
            }
            case "spi" -> {
                setPumpIn(Integer.parseInt(method.parameter()), Integer.parseInt(method.optParameter()));
                yield 0;
            }
            default -> throw new InvalidMethodException();
        };
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
}
