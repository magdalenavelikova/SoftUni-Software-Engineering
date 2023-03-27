package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;


public class MagicianRepositoryImpl implements MagicianRepository{
    Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

    @Override
    public Object findByUsername(String name) {
        return data.stream()
                .filter(m->name.equals(m.getUsername()))
                .findFirst()
                .orElse(null);
    }
}
