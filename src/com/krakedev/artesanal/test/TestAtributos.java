package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina ("M01","Pilsener", "cerveza normal" , 0.02, 10000 );
		rubia.imprimir();
	
		rubia.setNombreCerveza("Golden");
		rubia.imprimir();
		
	}
	
		
}
