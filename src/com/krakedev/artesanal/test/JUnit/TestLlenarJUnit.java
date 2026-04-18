package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test
	public void testLlenarMaquina() {

		Maquina rubia = new Maquina("M01", "Pilsener", "Cerveza", 0.02, 8000);

		rubia.llenarMaquina();

		// Nueva lógica: 8000 - 200 = 7800
		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
	}
}