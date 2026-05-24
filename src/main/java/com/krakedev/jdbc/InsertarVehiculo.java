package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertarVehiculo {
	
	private static final Logger LOGGER = LogManager.getLogger(InsertarVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """
				insert into vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje)
				values (?,?,?,?,?,?,?,?)
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "PPP-8");
			ps.setString(2, "Mazda");
			ps.setString(3, "BT-50");
			ps.setInt(4, 2024);
			ps.setDouble(5, 15000);
			ps.setString(6, "Rojo");
			ps.setBoolean(7, true);
			ps.setInt(8, 0);
			
			int filas = ps.executeUpdate();
			
			LOGGER.info("Filas agregadas: "+filas);
			LOGGER.info("Vehiculo agregado exitosamente");
			
		} catch (Exception e) {
			LOGGER.error("Error al agregar el Vehiculo"+e.getMessage());
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				LOGGER.error("Error al cerrar la conexion"+e.getMessage());
			}
		}
		
	}
}
