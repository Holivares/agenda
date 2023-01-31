package edu.test;

import edu.model.Agenda;
import edu.model.Appuntamento;
import edu.model.Persona;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evrard  Holivares Ngali
 * @author
 */
public class TestAgenda {
    @Test
    public void testAggiungiAppCorrettemente() {


        Persona p1 = new Persona( "Ngali", "Holivares");
        Persona p2 = new Persona( "Ngali", "Vianney");
        Persona p3 = new Persona( "Leslie", "Rotta");


        Appuntamento a1 = new Appuntamento( "06-21-2024;10:15:50", p1, 13, "Ufficio" );
        a1.setPersona( p1 );

        Appuntamento a2 = new Appuntamento( "02-11-2023;08:00:00", p2, 30, "Seminario" );
        a2.setPersona( p2 );

        Appuntamento a3 = new Appuntamento( "02-14-2023;18:30:00", p3, 20, "Sala" );
        a3.setPersona( p3 );

        List<Appuntamento> listApp = new ArrayList<>();
        listApp.add( a1 );
        listApp.add( a2 );
        listApp.add( a3 );

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);




    }
}
