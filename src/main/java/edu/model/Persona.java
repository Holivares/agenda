package para2023;

public class Persona implements Comparable<Persona> {
	
	private String nome;
	private String cognome;
	private String email;
	
	
	public Persona(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

    public String getEmail() {
		return email;
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



 // verifica se oggetto persona é lo stesso per altro
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
