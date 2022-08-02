package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Klant;
import sr.unasat.jdbc.crud.entities.Persoon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlantRepository {
    private Connection connection;

    public KlantRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/klant";
            String USER = "root";
            String PASS = "sadk2005";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Klant> findAllRecords() {
        List<Klant> klantList = new ArrayList<Klant>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select kl.id, kl.bedrijfsnaam, kl.gebruikersnaam, kl.klantnummer, kl.postcode, p.id pid, p.naam pnaam" +
                    " from klant kl" +
                    " join persoon p"+
                    " on p.id = kl.persoon_id";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String bedrijfsnaam = rs.getString("bedrijfsnaam");
                String gebruikersnaam = rs.getString("gebruikersnaam");
                int klantnummer = rs.getInt("klantnummer");
                String postcode = rs.getString("postcode");


                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                klantList.add(new Klant(id, bedrijfsnaam, gebruikersnaam, klantnummer, postcode, persoon));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return klantList;
    }

    public Klant findOneRecord(String Bnaam, String Gnaam) {
        Klant klant = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select kl.id, kl.bedrijfsnaam, kl.gebruikersnaam, kl.klantnummer, kl.postcode, p.id pid, p.naam pnaam" +
                    " from klant kl" +
                    " join persoon p"+
                    " on p.id = kl.persoonID where kl.bedrijfsnaam = ? or kl.gebruikersnaam = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Bnaam);
            stmt.setString(2, Gnaam);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String bedrijfsnaam = rs.getString("bedrijfsnaam");
                String gebruikersnaam = rs.getString("gebruikersnaam");
                int klantnummer = rs.getInt("klantnummer");
                String postcode = rs.getString("postcode");


                int persoonId = rs.getInt("pid");
                String persoonNaam = rs.getString("pnaam");
                Persoon persoon = new Persoon(persoonId, persoonNaam);

                klant = new Klant(id, bedrijfsnaam, gebruikersnaam, klantnummer, postcode, persoon);
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return klant;
    }


    public int insertOneRecord(Klant klant) {



        PreparedStatement stmt;
        int result;
        int insertId = 0;
        try {
            String sql = "insert into klant (bedrijfsnaam, gebruikersnaam, klantnummer, postcode, persoonID) values(?,?,?,?,?)";
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, klant.getBedrijfsnaam());
            stmt.setString(2, klant.getGebruikersnaam());
            stmt.setInt(3, klant.getKlantnummer());
            stmt.setString(4, klant.getPostcode());
            stmt.setInt(5, klant.getPersoon().getId());
            result = stmt.executeUpdate();


            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertId = generatedKeys.getInt(1);
                    System.out.println(insertId);
                } else {
                    throw new SQLException("Aanmaken gebruiker mislukt, geen ID verkregen.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertId;

    }



    public int updateOneRecord(Klant klant) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update klant kl set kl.bedrijfsnaam = ?, kl.persoonID= ? where kl.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, klant.getBedrijfsnaam());
            stmt.setInt(2, klant.getPersoon().getId());
            stmt.setInt(3, klant.getId());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }


    public int deleteOneRecord(Klant klant) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM klant WHERE klant.gebruikersnaam = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, klant.getGebruikersnaam());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + klant.getGebruikersnaam());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }





}
