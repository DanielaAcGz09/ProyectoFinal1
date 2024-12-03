import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;
    private JButton btnLimpiar;
    private JPanel miPanel;

    public Login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //harcodear
                String password = String.valueOf(txtPassword.getPassword());
                if (txtUsuario.getText().equals("admin") && password.equals("1234")) {
                    //bievenida
                    //JOptionPane.showMessageDialog(miPanel,"Bienvenido admin");
                      dispose();
                      String[] tipoUsuario={"admin"};
                      ventanaPaciente.main(tipoUsuario);
                }else if (txtUsuario.getText().equals("usuario") && password.equals("4567")){
                    //si es usuario
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido usuario");
                }else{
                    //usuario o contraseña no validas
                    JOptionPane.showMessageDialog(miPanel,"Usuario o contraseña incorrectos", "Login",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia los campos de texto
                txtUsuario.setText("");
                txtPassword.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Login vlogin = new Login();
        vlogin.setContentPane(vlogin.miPanel);
        vlogin.setSize(300, 300);
        vlogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vlogin.setVisible(true);
    }
}
