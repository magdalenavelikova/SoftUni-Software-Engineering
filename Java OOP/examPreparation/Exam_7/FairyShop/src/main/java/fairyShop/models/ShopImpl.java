package fairyShop.models;

import java.util.Collection;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) {
        Collection<Instrument> instruments = helper.getInstruments().stream().filter(i -> !i.isBroken()).collect(Collectors.toList());

        while (helper.canWork() && instruments.iterator().hasNext()&&!present.isDone()) {
           Instrument current = instruments.iterator().next();
            while (!current.isBroken()  && !present.isDone() && helper.canWork()) {
                helper.work();
                current.use();
                present.getCrafted();
            }
            instruments.remove(current);
        }

        }
    }

