package inheritance.randomArrayList;

public class Main {

    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList=new RandomArrayList<>();
        randomArrayList.add(2);
        randomArrayList.add(3);
        randomArrayList.add(8);
        randomArrayList.add(9);
        randomArrayList.add(25);
        System.out.println(randomArrayList.getRandomElement());
    }
}
