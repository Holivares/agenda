package edu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
/**
 *@author Evrard Holivares Ngali(20030188)
 *@author Candice Leslie Malimeta(20027009)
 */
public class Agenda  implements Iterable<Appuntamento>{
	
	private String nomeAgenda;

	private static Vector<Appuntamento> appuntamenti;

	public static void aggiungiAppuntamento(String s, Persona p1, int i, String ufficio) {
	}


	public String getNomeAgenda() {
		return nomeAgenda;
	}

	public void setNomeAgenda(String nomeAgenda) {
		this.nomeAgenda = nomeAgenda;
	}

	public void setAppuntamenti ( Vector<Appuntamento> appuntamenti ) {
		this.appuntamenti = appuntamenti;
	}

	public Agenda() {}
	/*Crea un agenda con nome*/
	public Agenda(String nomeAgenda ) {
		this.nomeAgenda = nomeAgenda;
		appuntamenti = new Vector<Appuntamento>();
		
	}
	/*Rimuove un agenda anche se contiene degli appuntamenti*/
	public static void removeAgenda( List<Agenda> agenda, String nomeAgenda ){
		boolean response = agenda.removeIf(current -> current.nomeAgenda.equals( nomeAgenda ));
		System.out.println( "*** response = " + response );
	}
	/*Aggiunge un appuntamento in un agenda */
    public static  void aggiungiAppuntamento(Appuntamento app) {
    	appuntamenti.add(app);

    }
	/*Ordina un agenda*/
    public void ordina() {
    	Collections.sort(appuntamenti);
    }


	@Override
	public Iterator<Appuntamento> iterator() {
		
		return this.appuntamenti.iterator();
	}
	/*Restitisce un appuntamento*/
	public Vector<Appuntamento> getAppuntamenti(){
		return this.appuntamenti;
	}
	/*Scrive su file l'appuntamento creato*/
	public void scrivereSulfile(String nomeDelFile) throws Exception {
		AgendaFileConverter agendaFileConverter = new AgendaFileConverter();
		agendaFileConverter.setAgendaNome( this.getNomeAgenda() );
		agendaFileConverter.setAppuntamenti( this.getAppuntamenti() );
		agendaFileConverter.setNumeroAppuntamenti( this.getAppuntamenti().size() );
		String gsonResult = new GsonBuilder().setDateFormat( "dd-MM-yyyy;HH:mm:ss" ).create().toJson( agendaFileConverter );
		System.out.println( "*** gsonResult = " + gsonResult );
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDelFile+".txt"))){
			writer.write( gsonResult );
        } catch (Exception e) {
        	throw new Exception("Errore durante la scritura sul file e=" +e.getStackTrace());
        }
	}
	
	/*Confronta gli appuntamenti*/
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
	
	/*permette di creare un agenda chiamando prendendo informazioni dal file*/

	public  static Agenda readContactsFile() throws Exception {
		Agenda agenda = new Agenda();
		AgendaFileConverter agendaFileConverter = null;
		Vector<Appuntamento> listAppuntamento = new Vector<>();
		//Ottiene informazioni dal file
		String allLines = Files.readString(Paths.get( "nomefile.txt" ).toAbsolutePath());

		Gson gson = new GsonBuilder().setDateFormat( "dd-MM-yyyy;HH:mm:ss" ).create();
		System.out.println( "*** allLine = " + allLines );
		agendaFileConverter = gson.fromJson( allLines,  AgendaFileConverter.class );

		System.out.println( "*** agendaFileConverter = " + agendaFileConverter.getAgendaNome() );
		agenda.setAppuntamenti( agendaFileConverter.getAppuntamenti() );
		agenda.setNomeAgenda( agendaFileConverter.getAgendaNome() );
		return agenda;
	}
	@Override
	public String toString() {
		return "Agenda [nomeAgenda=" + nomeAgenda + ",appuntamenti=" + appuntamenti + "]";
	}



}
