package robotService.entities.services;

public class SecondaryService extends BaseService{
    private static final int CAPACITY = 15;
    public SecondaryService(String name) {
        super(name, CAPACITY);
    }
}
