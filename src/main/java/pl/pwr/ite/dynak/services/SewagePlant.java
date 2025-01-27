package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ISewagePlant;
import pl.pwr.ite.dynak.utils.Method;

@Getter
@Setter
public class SewagePlant extends SocketUser implements ISewagePlant {
    public SewagePlant(int port) {
        super(port);
    }

    @Override
    public void handleRequest(Method method) {

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
