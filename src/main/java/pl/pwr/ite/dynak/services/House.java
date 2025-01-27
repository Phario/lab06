package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IHouse;
import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;

import java.net.ServerSocket;

@Getter
@Setter
public class House extends SocketUser implements IHouse, Runnable{
    private final int maxCapacity;
    private int sewageLevel;
    private final int officePort;
    private final String officeHost;
    private final int tickSpeed;
    public House(int port, int maxCapacity, int officePort, String officeHost, int tickSpeed) {
        super(port);
        this.maxCapacity = maxCapacity;
        this.officePort = officePort;
        this.officeHost = officeHost;
        this.tickSpeed = tickSpeed;
    }
    private void raiseSewageLevel() {
        sewageLevel++;
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
    public int handleRequest(Method method) throws InvalidMethodException {
        if (method.methodName().equals("gp")) {
            return getPumpOut(Integer.parseInt(method.parameter()));
        }
        else throw new InvalidMethodException();
    }
    public void sendSewageAlert(ServerSocket serverSocket) {
        sendRequest("o:" + serverSocket.getInetAddress().getHostAddress() + "," + port,officeHost,officePort);
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                raiseSewageLevel();
                if (sewageLevel >= 0.75*maxCapacity) {
                    sendSewageAlert(serverSocket);
                }
                Thread.sleep(tickSpeed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
