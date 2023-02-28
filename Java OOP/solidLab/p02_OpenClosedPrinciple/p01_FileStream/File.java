package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class File {
    private String name;

    private int length;

    private int sent;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return this.sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }
}
