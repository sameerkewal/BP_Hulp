package sr.unasat.jdbc.crud.entities;


public class Klant {
    private Integer id;
    private String bedrijfsnaam;
    private String gebruikersnaam;
    private Integer klantnummer;
    private String postcode;
    private Persoon persoon;

    public Klant(Integer id, String bedrijfsnaam, String gebruikersnaam, int klantnummer, String postcode, Persoon persoon) {
        this.id = id;
        this.bedrijfsnaam = bedrijfsnaam;
        this.gebruikersnaam = gebruikersnaam;
        this.klantnummer = klantnummer;
        this.postcode = postcode;
        this.persoon = persoon;
    }

    public Klant(String bedrijfsnaam, String gebruikersnaam, int klantnummer, String postcode, Persoon persoon) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.gebruikersnaam = gebruikersnaam;
        this.klantnummer = klantnummer;
        this.postcode = postcode;
        this.persoon = persoon;

    }

    public Klant(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public Integer getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(Integer klantnummer) {
        this.klantnummer = klantnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "id=" + id +
                ", bedrijfsnaam='" + bedrijfsnaam + '\'' +
                ", gebruikersnaam='" + gebruikersnaam + '\'' +
                ", klantnummer=" + klantnummer +
                ", postcode='" + postcode + '\'' +
                ", persoon=" + persoon +
                '}';
    }

}