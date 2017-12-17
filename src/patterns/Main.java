package patterns;

public class Main {
    public static void main(String[] args) {
        Person progger = PersonFactory.getProgrammer();
        progger.hireOn("odnoklassniki");
        System.out.println(progger.introduce());
    }
}
