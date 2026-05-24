package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

	private static final Logger LOGGER = LogManager.getLogger(UpdateVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """
				UPDATE vehiculos
				SET marca=?, modelo=?, anio=?, precio=?, color=?, disponible=?
				WHERE placa=?
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "KIA");
			ps.setString(2, "SOLUTO");
			ps.setInt(3, 2021);
			ps.setDouble(4, 18000);
			ps.setString(5, "NEGRO");
			ps.setBoolean(6, true);
			ps.setString(7, "PDD-7485");
			
			int filas = ps.executeUpdate();
			LOGGER.info("Filas actualizadas: "+filas);
			LOGGER.info("Se actualizo el Vehiculo");
		} catch (Exception e) {
			
			LOGGER.error("Error al actualizar: "+e.getMessage());
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				LOGGER.error("Error al cerrar la conexion: "+e2.getMessage());
			}
		}
	}

}
