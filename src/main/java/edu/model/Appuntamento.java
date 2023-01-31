package para2023;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Appuntamento implements Comparable<Appuntamento>{
	
	private Date data;
	private int durata;
	private Persona persona;
	private String luogo;
	
	
	//COSTRUTTORE
		public Appuntamento (String data, String orario, int durata,String luogo) throws Exception {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy'T'HH-mm");
	
			try {
				this.data = format.parse(data+'T'+orario);
			} catch (ParseException e) {
				throw new Exception("Invalid date format e={}",e);
				
			}
			this.durata = durata;
			this.luogo = luogo;
			
		}
				
					

		//METODI
		public boolean inConflitto(Appuntamento altro) {
			long tmp1 = this.data.toInstant().getEpochSecond();
			long minutiDaAggiungere = durata * 60;
			long tmp2 = altro.getData().toInstant().getEpochSecond();
			
			if (tmp2>tmp1 && tmp2 < tmp1+minutiDaAggiungere ) {
				return false;
			}
			
			/*if (altro.getData().after(data) || altro.getData().before(data)){
				return true;
			}*/
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
		
		/*public void setData(String data){
			if (data.length() == 5) {
				int mese = Integer.parseInt(data.substring(0,2));
				int giorno = Integer.parseInt(data.substring(3));
				if (mese>0 && mese<=12) {
					if(giorno>0 && giorno<=31) {
						data = this.data;
					}
					else 
						throw new IllegalArgumentException ("Giorno non valido  ");
				}
				else
					throw new IllegalArgumentException ("Mese non valido ");
			}
			else 
				throw new IllegalArgumentException ("Data non valida ");
		}

		public int getGiorno(){
			return Integer.parseInt(data.substring(3));
		}

		public int getMese(){
			return Integer.parseInt(data.substring(0,2));
		}*/

		public Date getData() {
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
