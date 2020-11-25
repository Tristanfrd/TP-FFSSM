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

    public GroupeSanguin getGS() {
        return GS;
    }

    public void setGS(GroupeSanguin GS) {
        this.GS = GS;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Licence> getLicence() {
        return licence;
    }

    public void setLicence(ArrayList<Licence> licence) {
        this.licence = licence;
    }
    
    public Licence getDernierelicence(){
        Licence l = licence.get(licence.size()-1);
        return l;
}

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    
        
}
