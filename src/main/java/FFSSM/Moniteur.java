/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Personne {

    public int numeroDiplome;
    private ArrayList<Embauche> embauche= new ArrayList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Club employeur = null;
        for(Embauche e:embauche){
            if (embauche.get(embauche.size()-1).estTerminee() == false){
                employeur = embauche.get(embauche.size()-1).getEmployeur();
            }
        } return Optional.ofNullable(employeur);
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         Embauche e = new Embauche(debutNouvelle,this,employeur);
         embauche.add(e);
    }
    
    public void terminerEmbauche(LocalDate fin){
        Embauche e = embauche.get(embauche.size()-1);
        e.terminer(fin);
    }
    
    public List<Embauche> emplois() {
        return embauche;
    }

}
