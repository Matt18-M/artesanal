package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	 public static void main(String[] args) {
	        System.out.println("=== Probando registrarCliente ===");
	        NegocioMejorado negocio = new NegocioMejorado();
	        
	        negocio.registrarCliente("Mateo Molina", "12345678");
	        
	        System.out.println("Cliente registrado exitosamente");
	     }
}
