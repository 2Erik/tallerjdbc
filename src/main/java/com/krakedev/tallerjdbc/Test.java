package com.krakedev.tallerjdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.krakedev.jdbc.Conexion;

public class Test {

	public static void main(String[] args) {
		
		Connection conexion = null;
		try {
			conexion = Conexion.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
