import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Ventana de bienvenida tras un inicio de sesión exitoso.
 */
public class VentanaBienvenida extends JFrame {

    private String nombreUsuario;
    private JButton btnCerrarSesion;

    public VentanaBienvenida(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        setTitle("Panel Principal - Bienvenida");
        setSize(450, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));

        // Panel Contenedor Principal
        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.setBackground(new Color(245, 247, 250));
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Tarjeta Central
        JPanel panelTarjeta = new JPanel(new GridBagLayout());
        panelTarjeta.setBackground(Color.WHITE);
        panelTarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // Icono
        gbc.gridy = 0;
        JLabel lblIcono = new JLabel();
        ImageIcon icono = loadIcon("usuario.png", 64, 64);
        if (icono == null) {
            icono = loadIcon("candado.png", 64, 64);
        }
        if (icono != null) {
            lblIcono.setIcon(icono);
            lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
            panelTarjeta.add(lblIcono, gbc);
        }

        // Mensaje de Saludo
        gbc.gridy = 1;
        JLabel lblSaludo = new JLabel("¡Hola, " + nombreUsuario + "!", SwingConstants.CENTER);
        lblSaludo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblSaludo.setForeground(new Color(46, 125, 50));
        panelTarjeta.add(lblSaludo, gbc);

        // Mensaje de Agradecimiento
        gbc.gridy = 2;
        JLabel lblMensaje = new JLabel("¡Gracias por iniciar sesión!", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblMensaje.setForeground(new Color(80, 80, 80));
        panelTarjeta.add(lblMensaje, gbc);

        // Subtexto
        gbc.gridy = 3;
        JLabel lblSubtexto = new JLabel("Has accedido correctamente al sistema.", SwingConstants.CENTER);
        lblSubtexto.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblSubtexto.setForeground(new Color(130, 130, 130));
        panelTarjeta.add(lblSubtexto, gbc);

        // Botón Cerrar Sesión
        gbc.gridy = 4;
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCerrarSesion.setBackground(new Color(211, 47, 47));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        btnCerrarSesion.addActionListener(e -> {
            LoginGrafico login = new LoginGrafico();
            login.setVisible(true);
            dispose();
        });

        panelTarjeta.add(btnCerrarSesion, gbc);
        panelContenedor.add(panelTarjeta, BorderLayout.CENTER);
        add(panelContenedor, BorderLayout.CENTER);
    }

    private ImageIcon loadIcon(String fileName, int width, int height) {
        String[] posiblesRutas = {
            "EjerciciosJava/resources/" + fileName,
            "resources/" + fileName,
            "../EjerciciosJava/resources/" + fileName,
            fileName
        };
        for (String ruta : posiblesRutas) {
            File f = new File(ruta);
            if (f.exists()) {
                ImageIcon icono = new ImageIcon(ruta);
                Image imagen = icono.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(imagen);
            }
        }
        return null;
    }
}
