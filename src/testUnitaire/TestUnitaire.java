package testunitaire;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Post
 */
public class TestUnitaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testClient();       
    }
    @Test    
    public static void testClient(){
        Date uneDate = new Date();
        testUnitaire.Client unclientTest = new testUnitaire.Client("lecode","lenom","leprenom",true,uneDate);
        assertEquals("code du client non crée","lecode",unclientTest.getCode());
        assertEquals("code du client non crée (donc ça marche)","lecodefaux",unclientTest.getCode());
    }


    }

