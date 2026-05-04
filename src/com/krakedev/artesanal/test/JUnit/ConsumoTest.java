package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class ConsumoTest {
    
    // Prueba 15 y 17: Método consumirCerveza
    @Test
    void testConsumirCerveza() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        // Preparar máquina
        negocio.agregarMaquina("IPA", "Cerveza IPA", 0.05);
        negocio.cargarMaquinas();
        Maquina maquina = negocio.getMaquinas().get(0);
        
        // Preparar cliente
        negocio.registrarCliente("Juan Perez", "12345678");
        Cliente cliente = negocio.getClientes().get(0);
        
        // Consumir
        double valor = negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 200);
        
        // Validar cliente actualizado
        assertEquals(10.0, cliente.getTotalConsumido());
        // Validar máquina afectada
        assertEquals(9600, maquina.getCantidadActual());
        // Validar valor correcto
        assertEquals(10.0, valor);
    }
    
    // Prueba: Cliente con múltiples consumos (acumula)
    @Test
    void testRegistrarConsumoAcumula() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.registrarCliente("Juan Perez", "12345678");
        Cliente cliente = negocio.getClientes().get(0);
        
        negocio.registrarConsumo(cliente, 100.0);
        negocio.registrarConsumo(cliente, 50.0);
        
        assertEquals(150.0, cliente.getTotalConsumido());
    }
    
    // Prueba 19: Método consultarValorVendido
    @Test
    void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        // Registrar clientes
        negocio.registrarCliente("Juan Perez", "12345678");
        negocio.registrarCliente("Maria Lopez", "87654321");
        
        // Agregar máquina
        negocio.agregarMaquina("IPA", "Cerveza IPA", 0.05);
        negocio.cargarMaquinas();
        Maquina maquina = negocio.getMaquinas().get(0);
        
        // Realizar consumos
        Cliente juan = negocio.buscarClientePorCedula("12345678");
        Cliente maria = negocio.buscarClientePorCedula("87654321");
        
        negocio.consumirCerveza(juan.getCodigo(), maquina.getCodigo(), 200);  // 10.0
        negocio.consumirCerveza(maria.getCodigo(), maquina.getCodigo(), 300); // 15.0
        
        // Validar suma total
        double total = negocio.consultarValorVendido();
        assertEquals(25.0, total);
    }
}