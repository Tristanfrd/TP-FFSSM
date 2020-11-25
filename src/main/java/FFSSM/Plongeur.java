package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne{
        private GroupeSanguin GS;
	private int niveau;
        private ArrayList<Licence> licence = new ArrayList <>();
        private Club club;
        
    public Plongeur(int niveau, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin GS) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.GS = GS;
    }
    public void ajouterLicence(String numéro, LocalDate delivrance){
        Licence l = new Licence(this,numéro,delivrance,this.niveau,club);
        licence.add(l);
    }
        
}
