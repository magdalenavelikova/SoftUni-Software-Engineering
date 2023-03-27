package magicGame;

public class Main {
    public static void main(String[] args) {
        Magician magician = new Magician("Ozz", 100);

        Magic magic1 = new Magic("Iris", 12);
        Magic magic2 = new Magic("Sabrina ", 50);
        Magic magic3 = new Magic("Calypso ", 10);

        magician.addMagic(magic1);
        magician.addMagic(magic2);
        magician.addMagic(magic3);
    }
}
