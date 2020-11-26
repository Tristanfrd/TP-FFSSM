package FFSSM;

import java.time.LocalDate;
import java.util.Optional;
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
    Plongeur untel,untel2;
    Plongee palanquee,palanquee2;
    LocalDate dateDDNOrg,dateDDNPlo,datePlongee,dateDelivrancePerimee,dateDelivranceValable,debutEmbauche,finEmbauche;
    Site site;
    Licence l,l2;
    
    @BeforeEach
    public void setUp() throws Exception{
        dateDDNOrg = LocalDate.of(1980, 1, 1);
        dateDDNPlo = LocalDate.of(1975, 2, 2);
        datePlongee = LocalDate.of(2020, 11, 25);
        dateDelivrancePerimee = LocalDate.of(2018, 1, 1);
        dateDelivranceValable = LocalDate.of(2020, 1, 1);
        debutEmbauche = LocalDate.of(2019, 01, 01);
        finEmbauche = LocalDate.of(2020, 01,01);
        site = new Site("Méditérannée","Initiation aux SSM");
        organisateur = new Moniteur("0001","Dupont","Jean","1 Rue de la paix","0606060606",dateDDNOrg,1);
        club = new Club(organisateur,"Club de Marseille de SSM","0505050505","1 Rue de la plongée");
        untel = new Plongeur(0,"1111","Leblanc","Patrick","2 Rue de la Volonté","0606060607",dateDDNPlo,GroupeSanguin.APLUS);
        untel2= new Plongeur(0,"2222","Legris","Enzo","4 Rue de la Volonté","0606060707",dateDDNPlo,GroupeSanguin.AMOINS);
        palanquee = new Plongee(site,organisateur,datePlongee, 10,2);
        palanquee2 = new Plongee(site,organisateur,datePlongee, 10,2);

        l = new Licence(untel,"001",dateDelivrancePerimee,0,club);
        l2 = new Licence(untel,"002",dateDelivranceValable,0,club);
    }
    
    @Test
    public void testValiditéLicence(){
        assertFalse(l.estValide(datePlongee),"La licence devrait être périmée");
        assertTrue(l2.estValide(datePlongee),"La licence ne devrait pas être périmée");        
    }
    
    @Test
    public void testPlongeesNonConformes(){
        untel.ajouterLicence("001", dateDelivrancePerimee);
        palanquee.ajouteParticipant(untel);
        club.organisePlongee(palanquee);
        assertTrue(club.plongeesNonConformes().contains(palanquee),"La plongée doit être non conforme car le participant a une licence périmée.");
        untel2.ajouterLicence("002", dateDelivranceValable);
        palanquee2.ajouteParticipant(untel2);
        club.organisePlongee(palanquee2);
        assertFalse(club.plongeesNonConformes().contains(palanquee2),"La plongée ne doit pas apparaître dans la collection.");
    }
    
    @Test
    public void testEmployeurActuel(){
        organisateur.nouvelleEmbauche(club, debutEmbauche);
        assertTrue(organisateur.employeurActuel().equals(Optional.ofNullable(club)),"Le club devrait être l'employeur.");
        organisateur.terminerEmbauche(finEmbauche);
        assertTrue(organisateur.employeurActuel().equals(Optional.empty()),"L'employeur devrait être vide.");
    }
    
    @Test
    public void testEstConforme(){
        untel.ajouterLicence("003", dateDelivrancePerimee);
        untel2.ajouterLicence("004",dateDelivranceValable);
        palanquee.ajouteParticipant(untel2);
        assertTrue(palanquee.estConforme(),"La palanquée devrait être conforme.");
        palanquee.ajouteParticipant(untel);
        assertFalse(palanquee.estConforme(),"La palanquée ne devrait pas être conforme.");
    }

}
