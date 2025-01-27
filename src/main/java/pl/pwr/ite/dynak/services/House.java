package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IHouse;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;

@Getter
@Setter
public class House extends SocketUser implements IHouse{
    private final int maxCapacity;
    private int sewageLevel;
    private final int officePort;
    private final String officeHost;
    public House(int port, int maxCapacity, int officePort, String officeHost) {
        super(port);
        this.maxCapacity = maxCapacity;
        this.officePort = officePort;
        this.officeHost = officeHost;
    }
    @Override
    public int getPumpOut(int max) {
        if (max > sewageLevel) {
            try {
                return sewageLevel;
            }
            finally {
                sewageLevel = 0;
            }
        }
        else return sewageLevel - max;
    }
    @Override
    public void handleRequest(Method method) throws InvalidMethodException {
        if (method.methodName().equals("gp")) {
            getPumpOut(Integer.parseInt(method.parameter()));
        }
        else throw new InvalidMethodException();
    }
    public void sendSewageAlert() {
        sendRequest("o:"+,officeHost,officePort);//TODO: finish this line first
    }
}
