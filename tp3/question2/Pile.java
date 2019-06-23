package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (Ahmad Mouhamad - 6046f)
 * @version (1.0)
 */
public class Pile implements PileI {
    private Object[] zone;
    private int ptr;
    /**
     * Constructeur par initialisation
     * @param taille : nombre d'éléments de la pile.
     */
    public Pile(int taille) {
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    
    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] =o;
        this.ptr++;
    }
    
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
    }
    
    public Object sommet() throws PileVideException {

        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1];
    }
    
    public int capacite() {
        return this.zone.length;
    }
    
    public int taille() { 
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }
    
    public boolean estVide() {
        return this.ptr == 0;
    }
    
    public boolean estPleine() {
        return this.ptr == this.zone.length;
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

    public int hashCode() {
        return toString().hashCode();
    }

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
	
}