import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JButton girişYapButton;
    private JButton kayıtOlButton;
    private JPanel panel1;

    private boolean validateUser(String username, String password) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "136934";


        try {
            Class.forName("org.postgresql.Driver"); // PostgreSQL JDBC sürücüsünü
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            String query = "SELECT * FROM kullanic WHERE isim = ? AND sifre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Eğer sonuç varsa kullanıcı doğrudur
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public Login(){

        add(panel1);
        setSize(500,400); //panel genişiliği
        setTitle("Kullanıcı Giriş Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);



        girişYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kadi,sifre;
                kadi=textField1.getText().toString();
                sifre=textField2.getText().toString();
                if (validateUser(kadi, sifre)) {
                    dispose(); // Kullanıcı girişi başarılıysa bu pencereyi kapat
                    Form1 form2 = new Form1();
                    form2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

//                dispose(); // Kullanıcı girişi başarılıysa bu pencereyi kapat
//                Form1 form2 = new Form1();
//                form2.setVisible(true);

            }
        });
        kayıtOlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Register register=new Register();
                register.setVisible(true);
            }
        });
    }


}
