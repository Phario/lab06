package pl.pwr.ite.dynak.services;

import pl.pwr.ite.dynak.utils.InvalidMethodException;
import pl.pwr.ite.dynak.utils.Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class SocketUser {
    protected ServerSocket serverSocket;
    int port;
    protected SocketUser(int port) {
        this.port = port;
    }
    public Method parseRequest(String request) {
        if (request != null) {
            String[] parts = request.split(":");
            String methodName = parts[0];
            String params = parts[1];
            String[] methodParams = params.split(",");
            if (methodName.equals("sj") || methodName.equals("r") || methodName.equals("o")) {
                return new Method(methodName, methodParams[0], methodParams[1], null);
            }
            else if (methodName.equals("spi")) {
                return new Method(methodName, null, methodParams[0], methodParams[1]);
            }
            else if (methodName.equals("gp") || methodName.equals("gs") || methodName.equals("sr") || methodName.equals("spo")) {
                return new Method(methodName, null, methodParams[0], null);
            }
            else return null;
        }
        return null;
    }
    protected String sendRequest(String request, String host, int port){
        try (Socket socket = new Socket(host, port);
             PrintWriter outbound = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader inbound = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             ) {
            outbound.println(request);
            return inbound.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public abstract void handleRequest(Method method) throws InvalidMethodException;
}
