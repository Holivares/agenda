package edu.model;
/**
 *@author Evrard Holivares Ngali(20030188)
 *@author Candice Leslie Malimeta(20027009)
 */
public class Persona implements Comparable<Persona> {
	
	private String nome;
	private String cognome;
	
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}



	public Persona() {
    	
    }
	@Override
	public String toString() {
		return "[nome=" + nome + ", cognome=" + cognome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



 // verifica se oggetto persona � lo stesso per altro
	// ritorna 0 se lo stesso
	@Override
	public int compareTo(Persona pers) {
		if(this.cognome.compareTo(pers.cognome)==0) {
			return this.nome.compareTo(pers.nome);
		}else {
		return this.cognome.compareTo(pers.cognome);
		}
	}


	

}
