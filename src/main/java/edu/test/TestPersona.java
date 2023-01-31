package edu.test;

import edu.model.Persona;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Evrard Holivares Ngali
 * @author
 */
public class TestPersona {
    @Test
    public void testPersona(){

            Persona pers = new Persona(" Ngali " , " Holivares ");
            assertEquals(" Ngali ",pers.getNome());
            assertEquals(" Holivares ",pers.getCognome());
            System.out.println("persona = " + pers);
        }

    }

