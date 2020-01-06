public class Mur extends Case {


    /**
     * Le constructer mur est responsable d'assigner le symbole '%' pour la Case de la grille à la position[i][j] lors de la création de la grille.
     */
    public Mur() {

        this.representation = '%';
    }


    /**
     * @param robot Le robot qui intéragirait avec la case
     * @return Retourne toujours faux puisque le robot ne pourrait pas intéragir avec un mur.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        return false;
    }


    /**
     * Puisque pas d'intéraction entre le robot et l'objet de type mur, donc pas d'appel à la méthode interagir lors de l'intéraction mur-robot.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {}
}
