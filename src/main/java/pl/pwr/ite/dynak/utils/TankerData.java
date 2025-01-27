package pl.pwr.ite.dynak.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TankerData {
    private final int tankerPort;
    private final String tankerHost;
    private final int id;
    private boolean isReady;
    public TankerData(int tankerPort, String tankerHost, int id, boolean isReady) {
        this.tankerPort = tankerPort;
        this.tankerHost = tankerHost;
        this.id = id;
        this.isReady = isReady;
    }
}
