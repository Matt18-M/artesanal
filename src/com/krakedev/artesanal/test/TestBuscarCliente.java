package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestBuscarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
NegocioMejorado negocio = new NegocioMejorado();
        
        negocio.registrarCliente("Mateo", "12345678");
        negocio.registrarCliente("Roberto", "87654321");
        negocio.registrarCliente("Carlos", "11122233");
        
        System.out.println("=BÚSQUEDA POR CÉDULA=");
        
        Cliente encontrado;
        encontrado = negocio.buscarClientePorCedula("87654321");
        
        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado.getNombre() + 
                             ", Código: " + encontrado.getCodigo());
        } else {
            System.out.println("Cliente no encontrado");
        }
        
        
        System.out.println("=BÚSQUEDA DE CLIENTE=");
        encontrado = negocio.buscarClientePorCedula("99999999");
        
        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Cliente no encontrado");
        }
        

        System.out.println("=BÚSQUEDA POR CÓDIGO=");
        encontrado = negocio.buscarClientePorCodigo(101);
        
        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado.getNombre() + 
                             ", Cédula: " + encontrado.getCedula());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}


