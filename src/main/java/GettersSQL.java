import java.sql.*;

public class GettersSQL {
	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "holaaaa", "admin");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet result = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
			System.out.printf("Nombre %s %n", nombre);
			System.out.printf("Driver %s %n", driver);
			System.out.printf("URL %s %n", url);
			System.out.printf("Usuario %s %n", usuario);
			result = dbmd.getTables("ejemplo", null, null, null);
			while (result.next()) {
				String catalogo = result.getString(1);
				String esquema = result.getString(2);
				String tabla = result.getString(3);
				String tipo = result.getString(4);
				System.out.printf("%s %s %s %s", catalogo, esquema, tabla, tipo);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
