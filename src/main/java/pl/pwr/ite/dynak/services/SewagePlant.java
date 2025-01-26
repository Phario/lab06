package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.ISewagePlant;

@Getter
@Setter
public class SewagePlant implements ISewagePlant {
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
