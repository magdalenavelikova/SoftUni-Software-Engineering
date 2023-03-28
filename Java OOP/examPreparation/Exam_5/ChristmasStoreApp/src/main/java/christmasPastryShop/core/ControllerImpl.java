package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy == null) {
            if (type.equals("Gingerbread")) {
                delicacy = new Gingerbread(name, price);
            } else if (type.equals("Stolen")) {
                delicacy = new Stolen(name, price);
            }
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail == null) {
            if (type.equals("Hibernation")) {
                cocktail = new Hibernation(name, size, brand);
            } else if (type.equals("MulledWine")) {
                cocktail = new MulledWine(name, size, brand);

            }
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth == null) {
            if (type.equals("OpenBooth")) {
                booth = new OpenBooth(boothNumber, capacity);
            } else if (type.equals("PrivateBooth")) {
                booth = new PrivateBooth(boothNumber, capacity);

            }
        } else {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }
        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        List<Booth> freeTables = boothRepository.getAll().stream().filter(b -> b.isReserved() == false && b.getCapacity() >= numberOfPeople).collect(Collectors.toList());
        if (freeTables.isEmpty()) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        freeTables.get(0).reserve(numberOfPeople);
        return (String.format(BOOTH_RESERVED, freeTables.get(0).getBoothNumber(), numberOfPeople));

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double amount = booth.getBill();
        totalIncome += amount;
        booth.clear();
        return String.format(BILL, boothNumber, amount);

    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
