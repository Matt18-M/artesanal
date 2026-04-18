package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("M01", "Pilsener", "Cerveza", 0.02, 8000);

		boolean resultado = rubia.recargarCerveza(3000);

		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
	}

	@Test
	public void testRecargaFallidaPorDesborde() {
		Maquina negra = new Maquina("M02", "Club", "Cerveza", 0.03, 8000);

		// Primero recargamos dentro del límite
		negra.recargarCerveza(7000);

		// Intentamos exceder el límite (8000 - 200 = 7800)
		boolean resultado = negra.recargarCerveza(1000);

		assertFalse(resultado);
		assertEquals(7000, negra.getCantidadActual(), 0.0001); 
	}
}