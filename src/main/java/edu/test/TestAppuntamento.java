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
public class TestAppuntamento {

    @Test
    public void testAggiungiAppCorrettemente() {

        Agenda agenda = new Agenda("Agenda1");
        String titoloAgenda = agenda.getNomeAgenda();
        System.out.println("Creata agenda con nome "+titoloAgenda);

        Persona p1 = new Persona("Ngali", "Holivares");
        Persona p2 = new Persona("Ngali", "Vianney");
        Persona p3 = new Persona("candice", "Malimeta");

        Appuntamento a1 = new Appuntamento("06-21-2024;10:15:50", p1, 13, "Ufficio");


        Appuntamento a2 = new Appuntamento("02-11-2023;08:00:00", p2, 30, "Seminario");


        Appuntamento a3 = new Appuntamento("02-14-2023;18:30:00", p3, 20, "Sala");

        Agenda.aggiungiAppuntamento(a1);
        Agenda.aggiungiAppuntamento(a2);
        Agenda.aggiungiAppuntamento(a3);

        System.out.println(agenda);

    }
    @Test
    public void getAppTest()
    {

    }
}
