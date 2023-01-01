package definingClassesExercise.google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;

    private Car car;
    private List<Parent> parentList;
    private List<Child> childList;
    private List<Pokemon> pokemonList;

    public Person(String name) {
        this.name = name;
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }


    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getOutputForCompany(Company company) {
        if (company != null) {
            return String.format("Company:%n%s %s %.2f", company.getCompanyName(), company.getDepartment(), company.getSalary());
        } else {
            return "Company:";
        }
    }

    public String getOutputForCar(Car car) {
        if (car != null) {
            return String.format("Car:%n%s %d", car.getCarModel(), car.getCarSpeed());
        } else {
            return "Car:";
        }
    }

    public String getOutputForParent(List<Parent> parentList) {
        if (!parentList.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Parents:%n"));
            for (Parent parent : parentList) {
                output.append(String.format("%s%n", parent.toString()));
            }
            return String.format("%s", output);
        } else {
            return String.format("Parents:%n");
        }
    }

    public String getOutputForPokemon(List<Pokemon> pokemonList) {
        if (!pokemonList.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Pokemon:%n"));
            for (Pokemon pokemon : pokemonList) {
                output.append(String.format("%s%n", pokemon.toString()));
            }
            return String.format("%s", output);
        } else {
            return String.format("Pokemon:%n");
        }
    }

    public String getOutputForChildren(List<Child> childList) {
        if (!childList.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Children:%n"));
            for (Child child : childList) {
                output.append(String.format("%s%n", child.toString()));
            }
            return String.format("%s", output);
        } else {
            return String.format("Children:%n");
        }
    }


    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n%s%s%s", name
                , getOutputForCompany(company)
                , getOutputForCar(car),
                getOutputForPokemon(pokemonList)
                , getOutputForParent(parentList)
                , getOutputForChildren(childList));


    }
}
