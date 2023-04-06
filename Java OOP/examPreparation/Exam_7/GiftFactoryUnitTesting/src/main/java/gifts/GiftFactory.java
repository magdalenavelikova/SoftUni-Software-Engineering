package gifts;

import gifts.Gift;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GiftFactory {
    private Collection<Gift> data;

    public GiftFactory() {
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public String createGift(Gift gift) {
        if (this.data.stream().anyMatch(p -> p.getType().equals(gift.getType()))) {
            throw new IllegalArgumentException(
                    String.format("gifts. Gift with name %s already exists.", gift.getType()));
        }
        this.data.add(gift);
        return String.format("Successfully added gift %s with magic %.2f.", gift.getType(), gift.getMagic());
    }

    public boolean removeGift(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null.");
        }
        boolean isRemoved = this.data.removeIf(p -> p.getType().equals(name));
        return isRemoved;
    }

    public Gift getPresentWithLeastMagic() {
        Gift gift = this.data
                .stream()
                .min(Comparator.comparingDouble(Gift::getMagic))
                .orElse(null);

        return gift;
    }

    public Gift getPresent(String name) {
        Gift gift = this.data
                .stream()
                .filter(p -> p.getType().equals(name))
                .findFirst()
                .orElse(null);

        return gift;
    }

    public Collection<Gift> getPresents() {
        return Collections.unmodifiableCollection(this.data);
    }

}
