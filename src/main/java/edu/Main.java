package edu;

import edu.model.Agenda;
import edu.model.Appuntamento;
import edu.model.Persona;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *@author Evrard Holivares Ngali(20030188)
 *@author Candice Leslie Malimeta(20027009)
 */
public class Main {

    public static void main ( String[] args ) throws Exception {

        List<Agenda> agende = new ArrayList<>();

        while( true ) {
            System.out.println( "Premere: \n" + "1- Per creare un'agenda\n" + "2- Per cercare un'agenda\n" + "3- Per un'agenda dal file\n" + "4- Per cancellare\n" );

            BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
            String scelta = input.readLine();
            switch( Integer.parseInt( scelta ) ) {
                case 1 -> {
                    System.out.println( "Inserire il nome dell'agenda: \n" );
                    String nome = input.readLine();
                    Agenda agenda = new Agenda( nome );
                    agende.add( agenda );
                    System.out.println("agenda creata");
                }
                case 2 -> {
                    Agenda agenda = null;
                    String nome = input.readLine();
                    for( Agenda tmp : agende ) {

                        if( tmp.getNomeAgenda()
                               .equalsIgnoreCase( nome ) ) {
                            agenda = tmp;
                            break;
                        }
                    }
                    if( agenda != null ) {
                        System.out.println( "Premere: \n" + "1- Per aggiungere un appuntamento\n" + "2- Per cercare un appuntamento\n" + "3- Per modificare un'appuntamento\n" + "4- Per elencare " +
											"tutti gli appuntamenti\n" + "5- Per scrivere l'agenda sul file\n" );

                        scelta = input.readLine();
                        switch( Integer.parseInt( scelta ) ) {
                            case 1: {
                                Persona p1 = new Persona( "Ngali", "Holivares");
                                Persona p2 = new Persona( "Ngali", "Evrard");

                                Persona p3 = new Persona( "Leslie", "Rotta");


                                Appuntamento a1 = new Appuntamento( "06-21-2024;10:15:50", p1, 13, "Ufficio" );
                                a1.setPersona( p1 );

                                Appuntamento a2 = new Appuntamento( "02-11-2023;08:00:00", p2, 30, "Seminario" );
                                a2.setPersona( p2 );

                                Appuntamento a3 = new Appuntamento( "02-14-2023;18:30:00", p3, 20, "Sala" );
                                a3.setPersona( p3 );

                                List<Appuntamento> listApp = new ArrayList<>();
                                System.out.println("appuntamenti aggiunti");
                                listApp.add( a1 );
                                listApp.add( a2 );
                                listApp.add( a3 );


                                for( Appuntamento app : listApp ) {
                                    if( !agenda.inConflitto( app ) ) {
                                        agenda.aggiungiAppuntamento( app );
                                    }

                                }
                                break;
                            }
                            case 2: {
                                String nomePersona = "Ngali";
                                for( int i = 0; i<agenda.getAppuntamenti()
                                                        .size(); i++ ) {
                                    if( agenda.getAppuntamenti()
                                              .get( i )
                                              .getPersona()
                                              .getNome()
                                              .equalsIgnoreCase( nomePersona ) ) {
                                        System.out.println( agenda.getAppuntamenti()
                                                                  .get( i ) );
                                    }
                                }

                                break;
                            }
                            case 3: {
                                String nomePersona = "Ngali";
                                Persona p = new Persona( "Rossana", "Pampi" );
                                for( int i = 0; i<agenda.getAppuntamenti()
                                                        .size(); i++ ) {
                                    if( agenda.getAppuntamenti()
                                              .get( i )
                                              .getPersona()
                                              .getNome()
                                              .equalsIgnoreCase( nomePersona ) ) {
                                        agenda.getAppuntamenti()
                                              .get( i )
                                              .setPersona( p );
                                    }
                                }

                                break;
                            }
                            case 4: {
								for( Appuntamento appuntamento : agenda.getAppuntamenti() ) {System.out.println( appuntamento );}
                                break;
                            }
                            case 5: {
                                agenda.scrivereSulfile( "nomefile");
                                break;
                            }
                            default:
                                System.err.println( "Scelta non valida" );
                        }

                    } else {

                        System.out.println( "Agenda non esistente" );
                    }
                }
                case 3 -> {
                    String nomeDelFile = "nomedelfile";
                    Agenda agenda = Agenda.readContactsFile();
                    agende.add( agenda );
                }
                case 4 -> {
                    if( agende.size()>=1 ) {
                        System.out.println( "Inserire il nome dell'agenda: \n" );
                        String nome = input.readLine();
                        Agenda.removeAgenda( agende, nome );
                    } else {
                        System.out.println( "Agende vide ..." );
                    }
                }
                default -> System.err.println( "Scelta non valida" );
            }


        }

    }
}
