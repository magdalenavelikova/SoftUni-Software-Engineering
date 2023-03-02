package reflectionAndAnnotations;

public class Main {

    @Subject(categories = {"Test","Annotation"})
    public class TestClass{

    }
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }


}
