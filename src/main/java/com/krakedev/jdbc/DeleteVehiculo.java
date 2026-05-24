package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	
	private static final Logger LOGGER = LogManager.getLogger(DeleteVehiculo.class);

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """
				DELETE FROM vehiculos
				WHERE placa = ?
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "PDD-7485");
			
			int filas = ps.executeUpdate();
			LOGGER.info("Filas eliminadas: "+filas);
			LOGGER.info("Vehiculo eliminado");
		} catch (Exception e) {
			
			LOGGER.error("Error al eliminar vehiculo "+e.getMessage());
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				LOGGER.error("Error al cerrar la conexion: "+e2.getMessage());
			}
		}

	}

}
