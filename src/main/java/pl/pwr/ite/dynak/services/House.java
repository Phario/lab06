package pl.pwr.ite.dynak.services;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.dynak.services.interfaces.IHouse;

@Getter
@Setter
public class House implements IHouse{
    @Override
    public int getPumpOut(int max) {
        return 0;
    }
}
