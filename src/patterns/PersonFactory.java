package patterns;

public class PersonFactory {
    public static Person getProgrammer(){
        return new Programmer(new SimpleProject());
    }
}
