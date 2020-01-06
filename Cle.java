public class Cle extends Case {


    /**
     * Le constructeur clé va assigner une représentation ',' à chaque clé instancié.
     */
    public Cle() {

        this.representation = '\'';
    }


    /**
     * @param robot Le robot qui interagirait avec la case.
     * @return Retourne vrai ce qui indique que le robot a ramassé un clé.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        return true;
    }


    /**
     * Si vrai, alors la représentation de la case du clé sera comme une case vide. Donc, le robot ne ramassera pas la clé deux fois lors de son passage deux fois
     * sur la même case.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {

        if (interactionPossible(robot)) {
            if (this.representation != ' ') {
                this.setRepresentation(' ');
                robot.nbrCles++;
            }
        }
    }
}