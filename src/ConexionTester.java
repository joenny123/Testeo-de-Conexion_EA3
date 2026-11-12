// importamos las librerías necesarias para la interfaz gráfica
import javax.swing.*; 
import java.awt.*;
// importamos las librerías necesarias para la conexión a la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Creación de interfaz

public class ConexionTester extends JFrame {

    // Componentes o atributos de nuestra interfaz
    private JTextField txtUrl; // Campo de texto para la URL de conexión
    private JTextField txtUsuario; // Campo de texto para el nombre de usuario
    private JPasswordField txtContrasena; // Campo de texto para la contraseña
    private JTextArea txtResultado; // Área de texto para mostrar los resultados de la prueba de conexión
    private JButton btnProbarConexion; // Botón para iniciar la prueba de conexión

    // Constructor de la ventana
    public ConexionTester() {

        setTitle("ConexionTester - Prueba de conexión");
        setSize(550, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10)); // Usamos BorderLayout para organizar los componentes
        panelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Panel para los campos
        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 10, 10));

        // URL de conexión
        panelCampos.add(new JLabel("URL de conexión:"));
        txtUrl = new JTextField("jdbc:sqlite:inventario.db");
        panelCampos.add(txtUrl);

        // Usuario
        panelCampos.add(new JLabel("Nombre de usuario:"));
        txtUsuario = new JTextField();
        panelCampos.add(txtUsuario);

        // Contraseña
        panelCampos.add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        panelCampos.add(txtContrasena);

        // Botón
        btnProbarConexion = new JButton("Probar conexión");

        // Área de resultados
        txtResultado = new JTextArea(8, 30);
        txtResultado.setEditable(false); // No editable para que el usuario no pueda modificarlo
        txtResultado.setText("Esperando prueba de conexión...");

        JScrollPane scroll = new JScrollPane(txtResultado);

       // Acción del botón para probar la conexión entre la aplicación y la base de datos SQLite
       
btnProbarConexion.addActionListener(e -> { // Acción al hacer clic en el botón

    String url = txtUrl.getText().trim(); // Obtenemos la URL de conexión ingresada por el usuario

    // aplicación de try-catch-resources para manejar la conexión a la base de datos y capturar posibles excepciones cerrar automáticamente la conexión al finalizar el bloque try

    try {
        // Cargar el controlador JDBC de SQLite
        Class.forName("org.sqlite.JDBC");

        // Intentar establecer la conexión
        try (Connection conexion = DriverManager.getConnection(url)) {

            if (conexion.isValid(2)) {
                txtResultado.setForeground(Color.GREEN.darker());
                txtResultado.setText(
                    "¡Conexión establecida correctamente con SQLite!"
                );
            }
        }

    } catch (ClassNotFoundException ex) { // Captura la excepción si no se encuentra el controlador JDBC

        txtResultado.setForeground(Color.RED);
        txtResultado.setText(
            "No se encontró el controlador JDBC.\n" + ex.getMessage()
        );

    } catch (SQLException ex) { // Captura la excepción si ocurre un error al intentar conectarse a la base de datos

        txtResultado.setForeground(Color.RED);
        txtResultado.setText(
            "Fallo de conexión.\n" + ex.getMessage()
        );
    }
});


        // Organización de los paneles
        panelPrincipal.add(panelCampos, BorderLayout.NORTH); // Campos en la parte superior
        panelPrincipal.add(btnProbarConexion, BorderLayout.CENTER); // Botón en el centro
        panelPrincipal.add(scroll, BorderLayout.SOUTH); // Área de resultados en la parte inferior

        add(panelPrincipal);
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Asegura que la interfaz se ejecute en el hilo de eventos de Swing
            ConexionTester ventana = new ConexionTester();
            ventana.setVisible(true);
        });
    }
}

