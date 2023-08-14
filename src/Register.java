import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Register extends JFrame{
    private JPanel panelregister;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton kayıtButton;
    private JButton Guncelle;

    public Register() {
    add(panelregister);
    setSize(500,400); //panel genişiliği
    setTitle("Kullanıcı Giriş Ekranı");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    kayıtButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ad,soyad,sifre;
            ad=textField1.getText().toString();
            soyad=textField2.getText().toString();
            sifre=textField3.getText().toString();
            String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
            String dbUsername = "postgres";
            String dbPassword = "136934";


            try {
                Class.forName("org.postgresql.Driver"); // PostgreSQL JDBC sürücüsünü
                Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                String query = "INSERT INTO kullanic (isim, soyisim, sifre) VALUES (?, ?, ?) ";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ad);
                preparedStatement.setString(2, soyad);
                preparedStatement.setString(3, sifre);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(Register.this, "Kayıt başarıyla eklendi.");

                preparedStatement.close();
                connection.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Register.this, "Kayıt eklenirken bir hata oluştu."); }
            catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex); }

        }
    });
        Guncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {@Override
                public void actionPerformed(ActionEvent e) {
                    String ad,soyad,sifre;
                    ad=textField1.getText().toString();
                    soyad=textField2.getText().toString();
                    sifre=textField3.getText().toString();
                    String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
                    String dbUsername = "postgres";
                    String dbPassword = "136934";


                    try {
                        Class.forName("org.postgresql.Driver"); // PostgreSQL JDBC sürücüsünü
                        Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                        String query = "Update ";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, ad);
                        preparedStatement.setString(2, soyad);
                        preparedStatement.setString(3, sifre);
                        preparedStatement.executeUpdate();

                        JOptionPane.showMessageDialog(Register.this, "Kayıt başarıyla eklendi.");

                        preparedStatement.close();
                        connection.close();
                    }
                    catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Register.this, "Kayıt eklenirken bir hata oluştu."); }
                    catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex); }


                }
        });
    }
}