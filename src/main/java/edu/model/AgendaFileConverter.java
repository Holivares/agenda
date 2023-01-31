package edu.model;

import java.util.Vector;
/**
 *@author Evrard Holivares Ngali(20030188)
 *@author Candice Leslie Malimeta(20027009)
 */
public class AgendaFileConverter {
    private String agendaNome;
    private Integer numeroAppuntamenti;
    private Vector<Appuntamento> appuntamenti;

    public String getAgendaNome () {
        return agendaNome;
    }

    public void setAgendaNome ( String agendaNome ) {
        this.agendaNome = agendaNome;
    }

    public int getNumeroAppuntamenti () {
        return numeroAppuntamenti;
    }

    public void setNumeroAppuntamenti ( int numeroAppuntamenti ) {
        this.numeroAppuntamenti = numeroAppuntamenti;
    }

    public Vector<Appuntamento> getAppuntamenti () {
        return appuntamenti;
    }

    public void setAppuntamenti ( Vector<Appuntamento> appuntamenti ) {
        this.appuntamenti = appuntamenti;
    }
}
