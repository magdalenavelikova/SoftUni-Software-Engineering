package bg.softuni.gamestore.model.dto;

public class OwnedGamesDto {
    private  String title;

    public OwnedGamesDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  title;
    }
}
