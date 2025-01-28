package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IOffice;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;
import pl.pwr.ite.dynak.utils.TankerData;

import java.util.ArrayList;

@Getter
@Setter
public class Office extends SocketUser implements IOffice{
    private static int staticTankerId = 0;
    private ArrayList<TankerData> tankers;
    private final int sewagePlantPort;
    private final String sewagePlantHost;
    public Office(int port, int sewagePlantPort, String sewagePlantHost) {
        super(port);
        tankers = new ArrayList<>();
        this.sewagePlantPort = sewagePlantPort;
        this.sewagePlantHost = sewagePlantHost;
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
        tankers.add(new TankerData(staticTankerId, port, host, true));
        return staticTankerId++;
    }

    @Override
    public int order(String host, String port) {
        //find available tanker
        for (TankerData tanker : tankers) {
            //send tanker on a job if it's ready
            if (tanker.isReady()) {
                sendRequest("sj:" + host + "," + port,tanker.getTankerHost(), Integer.parseInt(tanker.getTankerPort()));
                //set its state to not ready
                tanker.setReady(false);
                //return 1 if successful
                return 1;
            }
        }
        return 0;
    }

    @Override
    public void setReadyToServe(int number) {
        for (TankerData tanker : tankers) {
            if (tanker.getId() == number) {
                tanker.setReady(true);
                break;
            }
        }
    }
}
