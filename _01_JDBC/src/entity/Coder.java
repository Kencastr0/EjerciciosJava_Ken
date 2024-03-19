package entity;

public class Coder {

    private int id;
    private String name;
    private int edad;
    private String clan;

    public Coder() {
    }

    public Coder(int id, String name, int edad, String clan) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.clan = clan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", clan='" + clan + '\'' +
                '}';
    }
}
