package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ITanker;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;

@Getter
@Setter
public class Tanker extends SocketUser implements ITanker{
    private final int maxCapacity;
    private final int id;
    private int contents;
    private final int officePort;
    private final String officeHost;
    private final int tankerPort;
    public Tanker(int maxCapacity, int port, int id,int officePort,  String officeHost, int tankerPort) {
        super(port);
        this.maxCapacity = maxCapacity;
        this.id = id;
        this.officePort = officePort;
        this.officeHost = officeHost;
        this.tankerPort = tankerPort;
    }

    @Override
    public void setJob(String host, String port) {

    }

    @Override
    public void handleRequest(Method method) throws InvalidMethodException {
        if (method.methodName().equals("sj")) {
            setJob(method.host(), method.parameter());
        }
        else throw new InvalidMethodException();
    }
}
