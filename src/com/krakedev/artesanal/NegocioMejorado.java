package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
    private int ultimoCodigo = 100;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    

    public NegocioMejorado() {
        this.maquinas = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public int getUltimoCodigo() {
        return ultimoCodigo;
    }

    public void setUltimoCodigo(int ultimoCodigo) {
        this.ultimoCodigo = ultimoCodigo;
    }
    

    public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
    }


    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();
        

       Maquina existente = recuperarMaquina(codigo);
        if (existente != null) {
            return false; 
        }
        
        Maquina maquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
        maquinas.add(maquina);
        return true;
    }


    public void cargarMaquinas() {
        for (Maquina maquina : maquinas) {
            maquina.llenarMaquina();
        }
    }


    public Maquina recuperarMaquina(String codigo) {
        for (Maquina maquina : maquinas) {
            if (maquina.getCodigo().equals(codigo)) {
                return maquina;
            }
        }
        return null;
    }
    
    
    public void registrarCliente(String nombre, String cedula) {
        Cliente cliente = new Cliente(nombre, cedula);
        cliente.setCodigo(ultimoCodigo);
        ultimoCodigo++;
        clientes.add(cliente);
    }
    
    
    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    
    public Cliente buscarClientePorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }
    
    
 
    public void registrarConsumo(Cliente cliente, double valor) {
        if (cliente != null) {
            cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
        }
    }

 
    public double consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);
        
        if (maquina == null || cliente == null) {
            return 0;
        }
        
        double valor = maquina.servirCerveza(cantidad);
        if (valor > 0) {
            registrarConsumo(cliente, valor);
        }
        return valor;
    }


    public double consultarValorVendido() {
        double total = 0;
        for (Cliente cliente : clientes) {
            total += cliente.getTotalConsumido();
        }
        return total;
    }
}
