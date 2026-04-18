package com.krakedev.artesanal.test.JUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

    private static final double TOL = 0.0001;

    /**
     * Caso 1: servir con cantidad suficiente (constructor completo)
     * Lógica nueva: capacidad - 200
     */
    @Test
    public void testServirConSuficiente_ConstructorCompleto() {
        Maquina m = new Maquina("M01", "Rubia", "Cerveza suave", 0.05, 5000);

        m.llenarMaquina(); // ahora debe ser 4800

        double valor = m.servirCerveza(1000);

        assertEquals(1000 * 0.05, valor, TOL);
        assertEquals(3800, m.getCantidadActual(), TOL);  // ← CORREGIDO
        assertEquals("M01", m.getCodigo());
    }

    /**
     * Caso 2: no servir por falta de cantidad
     */
    @Test
    public void testNoSirvePorqueNoHay() {
        Maquina m = new Maquina("M02", "Negra", "Oscura", 0.08);

        double valor = m.servirCerveza(500);

        assertEquals(0, valor, TOL);
        assertEquals(0, m.getCantidadActual(), TOL);
        assertEquals("M02", m.getCodigo());
    }

    /**
     * Caso 3: servir exactamente lo disponible
     */
    @Test
    public void testServirExacto() {
        Maquina m = new Maquina("M03", "IPA", "Amarga", 0.06, 3000);

        m.recargarCerveza(1000);

        double valor = m.servirCerveza(1000);

        assertEquals(1000 * 0.06, valor, TOL);
        assertEquals(0, m.getCantidadActual(), TOL);
    }

    /**
     * Caso 4: servir 0
     */
    @Test
    public void testServirCero() {
        Maquina m = new Maquina("M04", "Roja", "Fuerte", 0.07, 2000);

        m.recargarCerveza(500);

        double valor = m.servirCerveza(0);

        assertEquals(0, valor, TOL);
        assertEquals(500, m.getCantidadActual(), TOL);
    }

    /**
     * Caso 5: servicios múltiples
     */
    @Test
    public void testServiciosMultiples() {
        Maquina m = new Maquina("M05", "Clara", "Ligera", 0.04);

        m.recargarCerveza(2000);

        double v1 = m.servirCerveza(500);
        double v2 = m.servirCerveza(300);

        assertEquals(500 * 0.04, v1, TOL);
        assertEquals(300 * 0.04, v2, TOL);
        assertEquals(1200, m.getCantidadActual(), TOL);
    }

    /**
     * Caso 6: no servir por falta después de servir antes
     */
    @Test
    public void testNoSirvePorFaltaLuegoDeServir() {
        Maquina m = new Maquina("M06", "Especial", "Premium", 0.10, 4000);

        m.recargarCerveza(1000); // tiene 1000

        m.servirCerveza(700); // queda 300

        double valor = m.servirCerveza(500); // no alcanza

        assertEquals(0, valor, TOL);
        assertEquals(300, m.getCantidadActual(), TOL);
    }
}