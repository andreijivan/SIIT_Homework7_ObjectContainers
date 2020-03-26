package ro.siit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persoana {
    private String name;
    private int age;
    private List<Hobby> hobbys;

    public Persoana(String name, int age) {
        this.name = name;
        this.age = age;
        this.hobbys = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Hobby> getHobbys() {
        return hobbys;
    }

    @Override
    public String toString() {
        return "Persoana "  + name;
    }

        //mai jos facem Override metodei equals care returneaza true pt 2 persoane cu acceasi varsta.
 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;
        Persoana persoana = (Persoana) o;
        return age == persoana.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }*/
}
