package enums;

public enum CurseName {
    FRONT_END("Front-end Basic"),
    CSHARP("C# Basic");


    private String name;

    CurseName(String name) {
        this.name=name;
    }


    @Override
    public String toString() {
        return name;
    }
}
