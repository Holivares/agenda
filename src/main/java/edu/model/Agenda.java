package para2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Agenda  implements Iterable<Appuntamento>{
	
	private String nomeAgenda;
	
	
	public String getNomeAgenda() {
		return nomeAgenda;
	}

	public void setNomeAgenda(String nomeAgenda) {
		this.nomeAgenda = nomeAgenda;
	}
	private Vector<Appuntamento> appuntamenti;
	
	
	public Agenda(String nomeAgenda ) {
		this.nomeAgenda = nomeAgenda;
		appuntamenti = new Vector<Appuntamento>();
		
	}

    public void aggiungiAppuntamento(Appuntamento app) {
    	appuntamenti.add(app);
    }
    
    public void rimuovereAppuntamento(Appuntamento appuntamento) {
    	appuntamenti.remove(appuntamento);
    }
    
    public void cancellaAgenda() {
    	appuntamenti.removeAllElements();
    }
    
    public void ordina() {
    	Collections.sort(appuntamenti);
    }


	@Override
	public Iterator<Appuntamento> iterator() {
		
		return this.appuntamenti.iterator();
	}
	
	public Vector<Appuntamento> getAppuntamenti(){
		return this.appuntamenti;
	}

	public void scrivereSulfile(String nomeDelFile) throws Exception {
		try {  
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDelFile+".txt"));
            
            writer.write(this.nomeAgenda+"\n");
            writer.write("numero appuntamenti: "+appuntamenti.size()+"\n");
            
            for(int i=0; i<appuntamenti.size(); i++) {
            	writer.write(appuntamenti.get(i).toString());
            	
				/*String tmp = appuntamenti.get(i).getPersona().getNome()+ " "+appuntamenti.get(i).getPersona().getCognome()+" "+
            			appuntamenti.get(i).getData().getDay()+"-"+appuntamenti.get(i).getData().getMonth()+"-"+appuntamenti.get(i).getData().getYear()+" "+
            			appuntamenti.get(i).getData().getHours()+"-"+appuntamenti.get(i).getData().getMinutes()+" "+appuntamenti.get(i).getDurata()+ " "+appuntamenti.get(i).getLuogo();
            	System.out.println(tmp);
            	writer.write(tmp);*/
            }
  
            // Closes the writer
            writer.close();
        }
  
        catch (Exception e) {
        	throw new Exception("Errore durante la scritura sul file e=" +e.getStackTrace());
        }
	}
	
	
	public boolean inConflitto(Appuntamento altro) {
		
		for(int i=0;i<appuntamenti.size();i++) {
			Appuntamento app =appuntamenti.get(i);			
			long tmp1 = app.getData().toInstant().getEpochSecond();
			long minutiDaAggiungere = app.getDurata() * 60;
			long tmp2 = altro.getData().toInstant().getEpochSecond();
			
			if (tmp2>=tmp1 && tmp2 <= tmp1+minutiDaAggiungere ) {
				return true;
			}
		}
		
		return false;
	}
	
	// ici cette methode me permet de creer un agenda en appeleant la agenda.readcontacts  quest 3

	public  static Agenda readContactsFile(String nomeDelFile) throws Exception {
		Agenda agenda = new Agenda(nomeDelFile);
		
		//gets the info from the file
		BufferedReader reader = new BufferedReader(new FileReader(nomeDelFile+".txt"));
				
		String temp = reader.readLine();
		
		
		//if the number is less then 1 throws an error
		int tempInt = Integer.parseInt(temp);
		if(tempInt < 1){
			throw new Exception("Invalid number of contacts, enter 1 or greater");
		}
		
		for(int i = 0;i < tempInt; i++) {
			//gets all strings from the file and updates the count
			String line = reader.readLine();
			
			String [] dati = line.split(" ");
			if(dati.length != 6) throw new Exception("Invalid line format");
			
			Persona newPersona = new Persona(dati[0], dati[1] , dati[2]);
			Appuntamento appuntamento = new Appuntamento(dati[2],dati[3],Integer.parseInt(dati[4]),dati[5]);
			
			appuntamento.setPersona(newPersona);
			
			agenda.aggiungiAppuntamento(appuntamento);
		}
		
		return agenda;
	}
	@Override
	public String toString() {
		return "Agenda [nomeAgenda=" + nomeAgenda + ",appuntamenti=" + appuntamenti + "]";
	}

}
