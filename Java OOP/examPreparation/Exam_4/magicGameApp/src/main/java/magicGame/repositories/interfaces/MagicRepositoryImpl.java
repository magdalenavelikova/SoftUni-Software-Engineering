package magicGame.repositories.interfaces;


import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;


import static magicGame.common.ExceptionMessages.*;

public class MagicRepositoryImpl implements MagicRepository {
    Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
       return data.remove(model);
    }

    @Override
    public Object findByName(String name) {
        return data.stream()
                .filter(m->name.equals(m.getName()))
                .findFirst()
                .orElse(null);
    }
}
