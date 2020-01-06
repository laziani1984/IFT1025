public class Vide extends Case {


    /**
     * Le constructeur Vide retourne une case vide avec un représentation ' '.
     */
    public Vide() {

        this.representation = ' ';
    }


    /**
     * @param robot Le robot qui interagirait avec la case.
     * @return Retourne true puisque la case vide est toujours accessible par un robot.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        return true;
    }


    /**
     * Pas besoin de méthode intéragir puisque le robot va se déplacer normalement dans les cases vides.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {}

}
