import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex6P1 {
	
	public static void main(String[] args) throws SQLException {
		Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ejemplo? UseSSL=true & serverTimezone =UTC", "holaaaa", "admin");
		String query = "SELECT apellidos, salario, departamentos.dept FROM empleados"
				+ " JOIN departamentos ON (departamentos.id = empleados.departamentos_no)"
				+ " WHERE salario=(SELECT max(salario) FROM empleados);";
		Statement sentencia = conexion.createStatement();
		boolean valor = sentencia.execute(query);

		if (valor) {
			ResultSet rs = sentencia.getResultSet();
			while (rs.next())
				System.out.printf("%s, %d, %s %n", rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getString(3));
		}
	}
}

