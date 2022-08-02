package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Persoon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersoonRepository {
    private Connection connection;

    public PersoonRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost:3306/klant";
            String USER = "root";
            String PASS = "";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persoon> findAllRecords() {
        List<Persoon> persoonList = new ArrayList<Persoon>();
        Statement stmt = null;
        try {


            stmt = connection.createStatement();
            String sql = "select * from persoon";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String naam = rs.getString("naam");
            /*    //Display values
               System.out.print("ID: " + id);
               System.out.print(", Age: " + naam);*/
                persoonList.add(new Persoon(id, naam));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return persoonList;
    }

    public int insertOneRecord(Persoon persoon) {
        int result;
        int insertId = 0;
        PreparedStatement stmt;


        try {
            String sql = "insert into persoon (naam) values(?)";
            stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, persoon.getNaam());
            result = stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Aanmaken gebruiker mislukt, geen ID verkregen.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertId;
    }


    public int updateOneRecord(Persoon persoon) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update persoon (id, naam) values(?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, persoon.getId());
            stmt.setString(2, persoon.getNaam());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Persoon persoon) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "DELETE FROM persoon WHERE persoon.naam = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, persoon.getNaam());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + persoon.getNaam());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}
