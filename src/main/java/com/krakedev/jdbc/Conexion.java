package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
	private static final Logger LOGGER = LogManager.getLogger(Conexion.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
	private static final String USER = "postgres";
	private static final String PASSWORD = "erikRelunico";
	
	public Connection getConnection() throws Exception{
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			LOGGER.info("Conexion exitosa");
			return con;
		} catch (SQLException e) {
			
			LOGGER.error("Error en la conexion "+e.getMessage());
			throw new Exception("No se pudo estyablecer la conexion");
		}
	}
}
