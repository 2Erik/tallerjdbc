package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehiculo {

	private static final Logger LOGGER = LogManager.getLogger(SelectVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """
				SELECT * FROM vehiculos
				""";
		ResultSet rs = null;
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible"); 
				
				LOGGER.info("\nPlaca: "+placa
						+"\tMarca: "+marca
						+"\tModelo: "+modelo
						+"\tAño: "+anio
						+"\tPrecio: "+precio
						+"\tColor: "+color
						+"\tDosponible: "+disponible);
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al buscar: "+e.getMessage());
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
