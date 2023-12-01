import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoEjemplo {

	public static void main(String[] args) throws SQLException {

		Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/ejemplo? UseSSL=true & serverTimezone =UTC", "holaaaa", "admin");
		String query = "SELECT * FROM departamentos";
		Statement sentencia = conexion.createStatement();
		boolean valor = sentencia.execute(query);

		if (valor) {
			ResultSet rs = sentencia.getResultSet();
			while (rs.next()) {
				System.out.printf("Fila %d: %d, %s, %s %n", rs.getRow(), rs.getInt(1), rs.getString(2),
						rs.getString(3));
			}
		}
		
		System.out.println("------------------------------------------------------------");
		
		Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tarde\\Desktop\\sqlite\\EmpresaIDK.db");
		String qry = "SELECT * FROM departamentos";
		Statement stm = con.createStatement();
		boolean val = stm.execute(qry);

		if (val) {
			ResultSet r = stm.getResultSet();
			while (r.next()) {
				System.out.printf("Fila %d: %d, %s, %s %n", r.getRow(), r.getInt(1), r.getString(2),
						r.getString(3));
			}
		}

	}
}