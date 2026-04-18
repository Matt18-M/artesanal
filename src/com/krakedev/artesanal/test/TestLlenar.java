package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("M01","Pilsener", "cerveza agria", 0.02, 8000);
		rubia.imprimir();
		
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("M02","Club" , "cerveza buena", 0.03);
		negra.imprimir();
		
		negra.llenarMaquina();
		negra.imprimir();
	}

}
