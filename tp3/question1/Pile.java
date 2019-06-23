package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (Ahmad Mouhamad - 6046f)
 * @version (1.0)
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * à compléter
     * 
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }
     /*
        constructeur par defaut
        */
    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }
    /*
       * ajouter un object
       */
    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }
   /*
      * enleve dernier valeur ajouter
    */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }
    /*
      * return boolean result
    */
    public boolean estVide() {
        return ptr == 0;
    }
    /*
      * return boolean result
    */
    public boolean estPleine() {
        return ptr == zone.length;
    }
/*
 * Afficher le contenue
   */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
     /*
     * Retourne dernier element ajoute.
     */
    public Object sommet() throws PileVideException {

        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1];
    }
    /*
     * return le nombre maximum d'elements ds la pile.
     */
    public int capacite() {
        return this.zone.length;
    }
     /*
     * retourner le nombre d'elements dans la pile.
     */
    public int taille() { 
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object o) {

        if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile p1 = (Pile)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i=zone.length - 1; i >=0; i--){
                Object tmp = zone[i];
                boolean egal = false;
                for(int j = zone.length-1; j>=0; j--){
                    if(tmp == p1.zone[i]){
                        egal = true;
                    }       
                }
                if(egal){
                    estEgale = true;
                }else{
                    return false;
                }
            }
            return true;
        }                
        return false;
    }
    
}