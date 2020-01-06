import java.util.ArrayList;

public abstract class Case {

    protected char representation;
    protected int x, y;


    /**
     * Retourne la représentation de la case (un seul caractère)
     *
     * @return la représentation de la case
     */
    public char getRepresentation() {
        return representation;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */

    public void setRepresentation(char representation) {
        this.representation = representation;
    }

    /**
     * Indique si une interaction entre la case et le robot est
     * possible (ex.: le robot peut interagir avec un NonKittenItem
     * en tout temps, mais ne peut pas interagir avec un mur, le robot
     * peut interagir avec une porte seulement s’il possède une clé,
     * etc.)
     *
     * @param robot Le robot qui interagirait avec la case
     * @return true si une interaction entre le robot et la case est possible
     */
    public abstract boolean interactionPossible(Robot robot);

    /**
     * Interaction entre la case et le robot
     *
     * @param robot
     */
    public abstract void interagir(Robot robot);

    /**
     * Génère un symbole aléatoire
     *
     * @return Un symbole ASCII compris entre ’:’ et ’~’
     */
    public static char getRandomSymbole() {

        return (char) (Math.random() * (126 - 58) + 58);
    }

    /**
     *
     * @param tab C'est le tableau qui sera copié dans l'ArrayList.
     * @return Retourne un ArrayList des String qui contient tous les éléments du tableau tab en paramètre.
     */
    public ArrayList<String> copierTab(String[] tab) {

        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=0; i<tab.length; i++) {
            arrayList.add(tab[i]);
        }
        return arrayList;
    }

}
