package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;

public interface Region {
    String start(Collection<Magician> magicians);

}
