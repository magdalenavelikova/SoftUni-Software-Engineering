package christmasPastryShop.repositories.interfaces;


import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(booths);
    }


    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }


    @Override
    public Booth getByNumber(int number) {
        return booths.stream()
                .filter(b -> b.getBoothNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
