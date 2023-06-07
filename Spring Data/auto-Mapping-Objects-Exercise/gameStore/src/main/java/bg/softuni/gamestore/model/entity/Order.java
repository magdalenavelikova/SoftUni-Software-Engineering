package bg.softuni.gamestore.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User buyer;
    private Set<Game> games;

    public Order() {
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
