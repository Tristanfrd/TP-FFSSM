/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;

/**
 *
 * @author frede
 */
public class main {	
    public static void main(String[] args) {
    Club club;
    Moniteur organisateur;
    Plongeur untel,untel2;
    Plongee palanquee,palanquee2;
    LocalDate dateDDNOrg,dateDDNPlo,datePlongee,dateDelivrancePerimee,dateDelivranceValable,debutEmbauche,finEmbauche;
    Site site;
    Licence l,l2;
    
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
	
        organisateur.nouvelleEmbauche(club, debutEmbauche);
        organisateur.employeurActuel();
	}
    
}
