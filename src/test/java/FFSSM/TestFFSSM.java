package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frede
 */
public class TestFFSSM {
    Club club;
    Moniteur organisateur;
    Plongeur untel;
    Plongee palanquee;
    LocalDate dateDDNOrg,dateDDNPlo,datePlongee,dateDelivrancePerimee,dateDelivranceValable;
    Site site;
    Licence l,l2;
    
    @BeforeEach
    public void setUp() throws Exception{
        dateDDNOrg = LocalDate.of(1980, 1, 1);
        dateDDNPlo = LocalDate.of(1975, 2, 2);
        datePlongee = LocalDate.of(2020, 11, 25);
        dateDelivrancePerimee = LocalDate.of(2018, 1, 1);
        dateDelivranceValable = LocalDate.of(2020, 1, 1);
        site = new Site("Méditérannée","Initiation aux SSM");
        organisateur = new Moniteur("0001","Dupont","Jean","1 Rue de la paix","0606060606",dateDDNOrg,1);
        club = new Club(organisateur,"Club de Marseille de SSM","0505050505","1 Rue de la plongée");
        untel = new Plongeur(0,"1111","Leblanc","Patrick","2 Rue de la Volonté","0606060607",dateDDNPlo,GroupeSanguin.APLUS);
        palanquee = new Plongee(site,organisateur,datePlongee, 10,2);
        l = new Licence(untel,"001",dateDelivrancePerimee,0,club);
        l2 = new Licence(untel,"002",dateDelivranceValable,0,club);
    }
    
    @Test
    public void testValiditéLicence(){
        assertFalse(l.estValide(datePlongee),"La licence devrait être périmée");
        assertTrue(l2.estValide(datePlongee),"La licence ne devrait pas être périmée");        
    }
    //Validité de la licence à tester
    // Embauche terminée
}
