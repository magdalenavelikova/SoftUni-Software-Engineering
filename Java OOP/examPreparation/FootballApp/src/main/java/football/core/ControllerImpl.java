package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;

import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.*;


import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.put(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);

    }

    @Override
    public String deliverySupplement(String type) {
        Supplement baseSupplement;
        if (type.equals("Powdered")) {
            baseSupplement = new Powdered();
        } else if (type.equals("Liquid")) {
            baseSupplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(baseSupplement);
        return String.format(String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type));
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement s = supplement.findByType(supplementType);
        if (s == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        fields.get(fieldName).addSupplement(s);
        supplement.remove(s);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        fields.get(fieldName).addPlayer(player);


        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        fields.get(fieldName).drag();
        int size = fields.get(fieldName).getPlayers().size();
        return String.format(PLAYER_DRAG, size);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int sum = fields.get(fieldName).getPlayers()
                .stream().map(Player::getStrength)
                .mapToInt(s->s).sum();
        return String.format(STRENGTH_FIELD, fieldName, sum);

    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        fields.values().stream().forEach(f->sb.append(f.getInfo()).append(System.lineSeparator()));
        return sb.toString();
    }
}
