package ro.siit;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {   //declarat 3 persoane cu hobby-uri si adrese
        Persoana ion = new Persoana("Ion",38);
        Hobby fishing = new Hobby("Fishing", 1);
        //In tema ni se cere sa adaugam si tara unde se practica hobby-ul. pt simplitate am updatat adresa sa contina
        //si tara, pentru a nu mai face inca o clasa. Alte exemple de hobby se practica oriunde, deci nu am inclus tara.
        Adresa fishingRiverBega = new Adresa("Romania - Timisoara -Bega River");
        Adresa fishingLakeSurduc = new Adresa(" Romania - Lake Surduc");
        fishing.getAddresses().add(fishingRiverBega);
        fishing.getAddresses().add(fishingLakeSurduc);
        ion.getHobbys().add(fishing);

        Persoana petronela = new Persoana("Petronela",38);
        Hobby soapOperaWatching = new Hobby("Telenovele",7);
        Adresa soapOperaLivingRoom = new Adresa("Living Room TV");
        Adresa soapOperaKitchen = new Adresa("Kitchen TV");
        soapOperaWatching.getAddresses().add(soapOperaLivingRoom);
        soapOperaWatching.getAddresses().add(soapOperaKitchen);
        petronela.getHobbys().add(soapOperaWatching);

        Persoana fane = new Persoana("Fane Patent", 43);
        Hobby seminte = new Hobby("spartSeminte", 14);
        Adresa seminteEatingHome = new Adresa("Front bench of bloc");
        Adresa seminteEatingBus = new Adresa("Bus 33");
        seminte.getAddresses().add(seminteEatingHome);
        seminte.getAddresses().add(seminteEatingBus);
        fane.getHobbys().add(seminte);

        //Treeset using name comparator
        TreeSet<Persoana> persoaneSetByName = new TreeSet(new MyNameComp());
        persoaneSetByName.add(ion);
        persoaneSetByName.add(petronela);
        persoaneSetByName.add(fane);
        for(Persoana persoana: persoaneSetByName){
            System.out.println(persoana.getName() + " " + persoana.getAge());
        }
        System.out.println("==============================");

        //Treeset using age comparator. aici ion si petronela fiind de aceeasi varsta, petronela nu mai e adaugata
        //deoarece avem MyAgeComp() selectat si intr-un set nu au voie intrari cu aceeasi valoare.
        TreeSet<Persoana> persoaneSetByAge = new TreeSet(new MyAgeComp());
        persoaneSetByAge.add(ion);
        persoaneSetByAge.add(petronela);
        persoaneSetByAge.add(fane);
        for(Persoana persoana: persoaneSetByAge){
            System.out.println(persoana.getName() + " " + persoana.getAge());
        }
        System.out.println("===============================");
        //Hashmap adding and printing
        HashMap<Persoana, List<Hobby>> persoanaListHashMap = new HashMap<>();
        persoanaListHashMap.put(ion,ion.getHobbys());
        persoanaListHashMap.put(petronela,petronela.getHobbys());
        persoanaListHashMap.put(fane, fane.getHobbys());
        //aici daca override-ul de equals si hashcode nu e "activat" in persoana, apar toate 3 intrarile. Daca se
        // activeaza, Persoana petronela nu mai este adaugata fiind-ca e "egala" cu ion ca si varsta.
        for (Map.Entry<Persoana,List<Hobby>> entry: persoanaListHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        //aici verificam metoda .equals ce e overrided in clasa persoana, si egaleaza daca 2 pers au aceeasi varsta.
        // in clasa Persoana trebuie "activat" codul de override equals si hascode.

        System.out.println("=============================");
        if (ion.equals(petronela)) System.out.println("Ion si Petronela au aceeasi varsta.");

    }
}
    class MyNameComp implements Comparator<Persoana>{
    @Override
    public int compare(Persoana e1, Persoana e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
class MyAgeComp implements Comparator<Persoana>{
    @Override
    public int compare(Persoana e1, Persoana e2) { return Integer.compare(e1.getAge(), e2.getAge()); }
}
