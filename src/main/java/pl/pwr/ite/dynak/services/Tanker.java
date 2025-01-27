package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ITanker;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;

import java.net.ServerSocket;

@Getter
@Setter
public class Tanker extends SocketUser implements ITanker{
    private final int maxCapacity;
    private int id;
    private int contents;
    private final int officePort;
    private final String officeHost;
    private final int sewagePlantPort;
    private final String sewagePlantHost;
    private final int tankerPort;
    public Tanker(int maxCapacity, int port, int officePort, String officeHost, int sewagePlantPort, String sewagePlantHost, int tankerPort) {
        super(port);
        this.maxCapacity = maxCapacity;
        this.officePort = officePort;
        this.officeHost = officeHost;
        this.sewagePlantPort = sewagePlantPort;
        this.sewagePlantHost = sewagePlantHost;
        this.tankerPort = tankerPort;
    }
    public void registerAtOffice(ServerSocket serverSocket) {
        this.id = Integer.parseInt(sendRequest("r:"+ serverSocket.getInetAddress().getHostAddress() + "," + tankerPort, officeHost, officePort));
    }
    @Override
    public void setJob(String host, String port) {
        //get house's sewage
        contents += Integer.parseInt(sendRequest("gp:"+maxCapacity,host, Integer.parseInt(port)));
        //go to the sewage plant and offload
        sendRequest("spi:"+ offloadCargo() + "," + id, sewagePlantHost, sewagePlantPort);
        //tell the office you're done
        sendRequest("sr:"+id, officeHost, officePort);
    }
    public int offloadCargo() {
        try {
            return contents;
        }
        finally {
            contents = 0;
        }
    }

    @Override
    public int handleRequest(Method method) throws InvalidMethodException {
        if (method.methodName().equals("sj")) {
            setJob(method.host(), method.parameter());
            return 0;
        }
        else throw new InvalidMethodException();
    }
}
