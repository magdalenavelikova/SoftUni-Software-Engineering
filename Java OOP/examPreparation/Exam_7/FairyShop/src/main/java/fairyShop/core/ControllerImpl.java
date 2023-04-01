package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Collection;
import java.util.List;
import java.util.logging.Handler;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository helpers;
    private PresentRepository presents;
    private int counter;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
        counter = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helpers.add(helper);
        return String.format(String.format(ADDED_HELPER, type, helperName));
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helpers.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName));
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presents.add(present);
        return String.format(String.format(SUCCESSFULLY_ADDED_PRESENT, presentName));

    }

    @Override
    public String craftPresent(String presentName) {
        Shop shop = new ShopImpl();
        Present present = presents.findByName(presentName);
        List<Helper> suitable = helpers.getModels().stream().filter(h -> h.getEnergy() > 50).collect(Collectors.toList());
        int brokenInstrumentsCount = 0;
        String output = "not done";
        if (suitable.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        while (!suitable.isEmpty() && !present.isDone()) {
            Helper helper = suitable.get(0);

            while (!present.isDone() &&
                    helper.canWork() &&
                    helper.getInstruments().stream().filter(i -> !i.isBroken()).count() > 0) {
                shop.craft(present, helper);
            }
            if (present.isDone()) {
                counter++;
                output = "done";
            }
            brokenInstrumentsCount += helper.getInstruments().stream().filter(i -> i.isBroken()).count();
            if (helper.getEnergy() == 0 || helper.getInstruments().stream().filter(i -> !i.isBroken()).count() == 0) {
                suitable.remove(0);
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRESENT_DONE, presentName, output));
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstrumentsCount));
        return sb.toString();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", counter)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        helpers.getModels().forEach(h -> sb.append(h.toString()).append(System.lineSeparator()));
        return sb.toString().trim();

    }
}
