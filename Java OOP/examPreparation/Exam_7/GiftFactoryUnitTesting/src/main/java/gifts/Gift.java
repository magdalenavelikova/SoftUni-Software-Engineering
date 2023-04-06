package gifts;

public class Gift {
    private String type;
    private double magic;

    public Gift(String type, double magic){
        this.setType(type);
        this.setMagic(magic);
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setMagic(double magic) {
        this.magic = magic;
    }

    public String getType() {
        return type;
    }

    public double getMagic() {
        return magic;
    }
}
