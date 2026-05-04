package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
    private int ultimoCodigo = 100;

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
}
