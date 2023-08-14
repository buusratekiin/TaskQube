import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Db {
    private String url;
    private String usr;
    private String pass;
    private String address;

    public Db() {
        url="jdbc:postgresql://ec2-174-129-231-116.compute-1.amazonaws.com:5432/d64q4qcqv826sg";
        usr = "postgres";
        pass = "136934";
    }

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usr, pass);
            System.out.println(con);
            return con;

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Problemas com a conex�o\n" + e);
            return null;
        }
    }

}
