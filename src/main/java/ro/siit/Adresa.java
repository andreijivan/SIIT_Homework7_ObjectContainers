package ro.siit;

public class Adresa {
    private String practiceAdress;

    public Adresa(String practiceAdress) {
        this.practiceAdress = practiceAdress;
    }

    @Override
    public String toString() {
        return  practiceAdress;
    }
}
