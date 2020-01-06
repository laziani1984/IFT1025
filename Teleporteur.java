public class Teleporteur extends Case {


    /**
     * Le point posTeleport pour indiquer la position de téléporteur, la booléene teleporteurVisite pour indiquer si le robot a visité le téléporteur d'avant ou pas.
     */
    private Point posTeleport;
    private boolean teleporteurVisite = false;


    /**
     * /**
     * Le constructer mur est responsable d'assigner le symbole bien randomisé pour la Case de la grille à la position[y][x](posTeleport) lors de la création de la grille.
     *
     * @param x C'est la position x à partir de la largeur de la grille.
     * @param y C'est la position y à partir de la hauteur de la grille.
     */
    public Teleporteur(int x, int y) {

        this.posTeleport = new Point(x, y);
        this.representation = getRandomSymbole();
    }


    /**
     * @param robot Le robot qui interagirait avec la case.
     * @return Retourne vrai puisque l'interaction n'est pas fait, si le téléporteur est déjà visité alors il va retourner faux.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        if (teleporteurVisite == false) {
            return true;
        }
        return false;
    }


    /**
     * L'interaction va changer l'état de la variable téléporteur en vrai, ce qui indique que le robot pourrait se déplacer en utilisant le téléporteur.
     *
     * @param robot le robot va s'intéragir avec la case.
     */
    @Override
    public void interagir(Robot robot) {

        if (interactionPossible(robot)) {
            robot.teleporteur = true;
        }
    }
}
