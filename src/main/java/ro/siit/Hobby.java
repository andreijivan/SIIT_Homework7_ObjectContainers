package ro.siit;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    private String hobbyName;
    private int frequency;
    private List<Adresa> addresses;

    public Hobby(String hobbyName, int frequency) {
        this.hobbyName = hobbyName;
        this.frequency = frequency;
        this.addresses = new ArrayList<>();
    }

    public List<Adresa> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "hobbyName='" + hobbyName + '\'' +", frequency=" + frequency + ", addresses=" + addresses;
    }
}
