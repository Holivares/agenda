package edu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *@author Evrard Holivares Ngali(20030188)
 *@author Candice Leslie Malimeta(20027009)
 */
public class Appuntamento implements Comparable<Appuntamento>{
	
	private Date data;
	private int durata;
	private Persona persona;
	private String luogo;
	
	
	//COSTRUTTORE
		public Appuntamento (String data, Persona persona, int durata,String luogo) {

			try {
				this.data = new SimpleDateFormat( "dd-MM-yyyy;HH:mm:ss" ).parse( data );
			} catch( ParseException e ) {
				throw new RuntimeException( e );
			}
			this.durata = durata;
			this.luogo = luogo;
			this.persona = persona;
			
		}
				
					

		//METODI
		public boolean inConflitto(Appuntamento altro) {
			long tmp1 = this.data.toInstant().getEpochSecond();
			long minutiDaAggiungere = durata * 60;
			long tmp2 = altro.getData().toInstant().getEpochSecond();

			if (tmp2>tmp1 && tmp2 < tmp1+minutiDaAggiungere ) {
				return false;
			}

			return true;
		}

		@Override
		public String toString() {
			return ("Persona :"+persona+", data :" + this.data + " durata:" + this.durata + " luogo: " + this.luogo + "\n");
		}

		public int compareTo(Appuntamento altro) {
			if (this.getData().getMonth() == altro.getData().getMonth()) {
				if (this.getData().getDay() == altro.getData().getDay()) {
					if (this.getData().getHours() == altro.getData().getHours())
						return 0;
					else if(this.getData().getHours() > altro.getData().getHours())
							return 1;
						else
							return -1;
				}
				else if(this.getData().getDay() > altro.getData().getDay())
						return 1;
					else
						return -1;
			}
			else if(this.getData().getMonth() > altro.getData().getMonth())
					return 1;
				else
					return -1;
		}

		

		// metodi set & get ...
		public void setLuogo(String luogo){
			this.luogo = luogo;
		}

		public String getLuogo(){
			return this.luogo;
		}
		public Date getData () {
			return this.data;
		}
			
		public void setPersona(Persona p1) {
			this.persona = p1;
			
		}

		public int getDurata() {
			return durata;
		}


		public void setDurata(int durata) {
			this.durata = durata;
		}
		public Persona getPersona() {
			// TODO Auto-generated method stub
			return this.persona;
		}
}		
