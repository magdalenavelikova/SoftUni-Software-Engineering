package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present>{
    private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    @Override
    public void add(Present model) {
        if(findByName(model.getName())==null) {
            presents.add(model);
        }
    }

    @Override
    public boolean remove(Present model) {
        return presents.remove(model);
    }

    @Override
    public Present findByName(String name) {
        return presents.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
