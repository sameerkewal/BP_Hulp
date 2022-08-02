package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.ContactInformatie;
import sr.unasat.jdbc.crud.entities.Klant;
import sr.unasat.jdbc.crud.entities.Land;
import sr.unasat.jdbc.crud.entities.Persoon;
import sr.unasat.jdbc.crud.repositories.ContactInformatieRepository;
import sr.unasat.jdbc.crud.repositories.KlantRepository;
import sr.unasat.jdbc.crud.repositories.LandRepository;
import sr.unasat.jdbc.crud.repositories.PersoonRepository;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        /*PersoonRepository persoonRepo = new PersoonRepository();
        List<Persoon> persoonList = persoonRepo.findAllRecords();
        for (Persoon persoon : persoonList) {
            System.out.println(persoon);
        }

        ContactInformatieRepository ciRepo = new ContactInformatieRepository();
        List<ContactInformatie> contactList = ciRepo.findAllRecords();
        for (ContactInformatie contact : contactList) {
            System.out.println(contact);
        }

        LandRepository landRepo = new LandRepository();
        List<Land> landList = landRepo.findAllRecords();
        for (Land land : landList) {
            System.out.println(land);
        }

        /*
        KlantRepository kl = new KlantRepository();
        Klant foundRecord = kl.findOneRecord("AFOBAKA RESORT", "Ella");
        System.out.println("single record: " + kl);

        foundRecord.setBedrijfsnaam("Test bedrijf");
        foundRecord.getPersoon().setId(2);
        kl.updateOneRecord(foundRecord); **ONZE DELETE FUNCTIE**
*/
        /*KlantRepository klantRepo = new KlantRepository();
        List<Klant> klantList = klantRepo.findAllRecords();
        for (Klant klant : klantList) {
            System.out.println(klant);
        }
       // Persoon person2 = new Persoon("Kesia");
       // int person2Id = persoonRepo.insertOneRecord(person2);
       // person2.setId(person2Id);
       // System.out.println(person2Id);
       // System.out.println(person2);


      //  Klant klant = new Klant("testing", "keskes", 56749, "AA1237",person2);
       // klantRepo.insertOneRecord(klant); //**ONZE INSERT FUNCTIE***/

        //Klant client = new Klant("qwerty");
        //klantRepo.deleteOneRecord(client); **ONZE DELETE FUNCTIE**


/*
        int result = persoonRepo.insertOneRecord(new Persoon("Ellen"));
        System.out.println(result);
        ContactInformatieRepository ci = new ContactInformatieRepository();
        ContactInformatie recordFound = ci.findOneRecord(6546654, "Soelastraat  12");
        System.out.println("single record: " + ci);

        recordFound.setTelefoonNummer(8888);
        recordFound.getPersoon().setId(1);
        ci.updateOneRecord(recordFound);



        List<ContactInformatie> contactInformatieList = new ArrayList<ContactInformatie>();
        contactInformatieList = ci.findAllRecords();
        for (ContactInformatie contactInformatie : contactInformatieList) {
            System.out.println(contactInformatie);*/


        PersoonRepository pr = new PersoonRepository();
        Persoon testPerson = new Persoon(6, "sjjsjs");
        //System.out.println(pr.findAllRecords());
       // pr.insertOneRecord(testPerson);
        KlantRepository kr = new KlantRepository();
       Klant toAdd = new Klant
              (12, "updatetest", "newtestforupdate", 262662, "66669", testPerson);
       toAdd.setBedrijfsnaam("pogggggers");
        System.out.println(toAdd);

        //kr.insertOneRecord(toAdd);

        kr.updateOneRecord(toAdd);


        System.out.println(kr.findOneRecord("new", "newtest"));
        }






    }



