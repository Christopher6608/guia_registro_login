import java.util.HashMap;
import java.util.Map;

/**
 * Gestión de datos de usuarios en memoria (simulación de base de datos).
 */
public class UsuarioDatos {

    private static final Map<String, String> usuarios = new HashMap<>();

    static {
        // Usuario por defecto
        usuarios.put("admin", "1234");
    }

    /**
     * Registra un nuevo usuario en memoria.
     */
    public static void registrar(String usuario, String clave) {
        if (usuario != null && !usuario.trim().isEmpty()) {
            usuarios.put(usuario.trim().toLowerCase(), clave);
        }
    }

    /**
     * Valida si las credenciales de inicio de sesión son correctas.
     */
    public static boolean validar(String usuario, String clave) {
        if (usuario == null || clave == null) {
            return false;
        }
        String claveGuardada = usuarios.get(usuario.trim().toLowerCase());
        return claveGuardada != null && claveGuardada.equals(clave);
    }
}
