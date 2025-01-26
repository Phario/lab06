package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ITanker;

@Getter
@Setter
public class Tanker implements ITanker{
    private final int maxCapacity;
    private final int id;
    private int contents;
    private static int staticId = 0;
    private final int officeId;
    public Tanker(int maxCapacity, int officeId) {
        this.maxCapacity = maxCapacity;
        this.id = staticId++;
        this.officeId = officeId;
    }

    @Override
    public void setJob(String host, String port) {

    }
}
