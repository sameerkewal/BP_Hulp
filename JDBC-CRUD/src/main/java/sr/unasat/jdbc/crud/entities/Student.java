package sr.unasat.jdbc.crud.entities;

public class Student {
    private Integer id;
    private Persoon persoon;
    private String studentnummer;
    private String geslacht;
    private Integer leeftijd;
    //richting?


    public Student(Integer id, Persoon persoon, String studentnummer, String geslacht, Integer leeftijd) {
        this.id = id;
        this.persoon = persoon;
        this.studentnummer = studentnummer;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public String getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(String studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", persoon=" + persoon +
                ", studentnummer='" + studentnummer + '\'' +
                ", geslacht='" + geslacht + '\'' +
                ", leeftijd=" + leeftijd +
                '}';
    }
}




