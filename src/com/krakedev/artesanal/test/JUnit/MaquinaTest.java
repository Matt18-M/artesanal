package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class MaquinaTest {
    
    // Pruebas para el método llenarMaquina
    @Test
    void testLlenarMaquina() {
        Maquina maquina = new Maquina("M-001", "IPA", "Cerveza India Pale Ale", 0.05, 10000);
        maquina.llenarMaquina();
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    @Test
    void testLlenarMaquinaConCapacidadDiferente() {
        Maquina maquina = new Maquina("M-002", "Stout", "Cerveza Stout", 0.06, 8000);
        maquina.llenarMaquina();
        assertEquals(7800, maquina.getCantidadActual());
    }
    
    @Test
    void testLlenarMaquinaMultiplesVeces() {
        Maquina maquina = new Maquina("M-003", "Pale Ale", "Cerveza Pale Ale", 0.04);
        maquina.llenarMaquina();
        assertEquals(9800, maquina.getCantidadActual());
        
        maquina.llenarMaquina();
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    // Pruebas para el método servirCerveza
    @Test
    void testServirCervezaExitoso() {
        Maquina maquina = new Maquina("M-001", "IPA", "Cerveza India Pale Ale", 0.05, 10000);
        maquina.llenarMaquina();
        double valor = maquina.servirCerveza(500);
        assertEquals(25.0, valor);
        assertEquals(9300, maquina.getCantidadActual());
    }
    
    @Test
    void testServirCervezaCantidadExacta() {
        Maquina maquina = new Maquina("M-002", "Stout", "Cerveza Stout", 0.06, 10000);
        maquina.llenarMaquina();
        double valor = maquina.servirCerveza(9800);
        assertEquals(588.0, valor);
        assertEquals(0, maquina.getCantidadActual());
    }
    
    @Test
    void testServirCervezaSinSuficienteStock() {
        Maquina maquina = new Maquina("M-003", "Pale Ale", "Cerveza Pale Ale", 0.04, 10000);
        maquina.llenarMaquina();
        double valor = maquina.servirCerveza(10000);
        assertEquals(0, valor);
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    @Test
    void testServirCervezaMaquinaVacia() {
        Maquina maquina = new Maquina("M-004", "Lager", "Cerveza Lager", 0.03, 10000);
        double valor = maquina.servirCerveza(100);
        assertEquals(0, valor);
        assertEquals(0, maquina.getCantidadActual());
    }
    
    @Test
    void testServirCervezaMultiplesVeces() {
        Maquina maquina = new Maquina("M-005", "IPA", "Cerveza IPA", 0.05, 10000);
        maquina.llenarMaquina();
        
        double valor1 = maquina.servirCerveza(1000);
        assertEquals(50.0, valor1);
        assertEquals(8800, maquina.getCantidadActual());
        
        double valor2 = maquina.servirCerveza(2000);
        assertEquals(100.0, valor2);
        assertEquals(6800, maquina.getCantidadActual());
        
        double valor3 = maquina.servirCerveza(3000);
        assertEquals(150.0, valor3);
        assertEquals(3800, maquina.getCantidadActual());
    }
    
    @Test
    void testServirCervezaCantidadCero() {
        Maquina maquina = new Maquina("M-006", "Porter", "Cerveza Porter", 0.07, 10000);
        maquina.llenarMaquina();
        double valor = maquina.servirCerveza(0);
        assertEquals(0, valor);
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    // Pruebas para el método recargarCerveza
    @Test
    void testRecargarCervezaExitoso() {
        Maquina maquina = new Maquina("M-001", "IPA", "Cerveza IPA", 0.05, 10000);
        boolean resultado = maquina.recargarCerveza(500);
        assertTrue(resultado);
        assertEquals(500, maquina.getCantidadActual());
    }
    
    @Test
    void testRecargarCervezaSuperaLimite() {
        Maquina maquina = new Maquina("M-002", "Stout", "Cerveza Stout", 0.06, 10000);
        maquina.llenarMaquina();
        boolean resultado = maquina.recargarCerveza(100);
        assertFalse(resultado);
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    @Test
    void testRecargarCervezaDesdeCero() {
        Maquina maquina = new Maquina("M-003", "Pale Ale", "Cerveza Pale Ale", 0.04, 10000);
        boolean resultado = maquina.recargarCerveza(9500);
        assertTrue(resultado);
        assertEquals(9500, maquina.getCantidadActual());
    }
    
    @Test
    void testRecargarCervezaLimiteExacto() {
        Maquina maquina = new Maquina("M-004", "Lager", "Cerveza Lager", 0.03, 10000);
        maquina.llenarMaquina();
        boolean resultado = maquina.recargarCerveza(0);
        assertTrue(resultado);
        assertEquals(9800, maquina.getCantidadActual());
    }
    
    @Test
    void testRecargarCervezaNegativa() {
        Maquina maquina = new Maquina("M-005", "IPA", "Cerveza IPA", 0.05, 10000);
        maquina.llenarMaquina();
        boolean resultado = maquina.recargarCerveza(-100);
        assertTrue(resultado);
        assertEquals(9700, maquina.getCantidadActual());
    }
}