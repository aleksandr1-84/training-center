package patterns;

public class Programmer implements Person {

    private Project project;
    private String helloPhrase = "Hi, I'm working at ";

    public Programmer(Project project) {
        this.project = project;
    }

    @Override
    public String introduce() {
        return helloPhrase + project.getName();
    }

    @Override
    public void hireOn(String projectName) {
        project.setName(projectName);
    }


}
