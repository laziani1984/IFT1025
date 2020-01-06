public class Porte extends Case {


    /**
     * Le point posPorte va indiquer la position de la porte [y](hauteur)[x](largeur) sur la grille.
     */
    private Point posPorte;


    /**
     * Le Constructeur porte possède un point sur la grille posPorte et une representation '!'.
     *
     * @param x C'est la position x à partir de la largeur de la grille.
     * @param y C'est la position y à partir de la hauteur de la grille.
     */
    public Porte(int x, int y) {

        this.posPorte = new Point(x, y);
        this.representation = '!';
    }


    /**
     * @param robot Le robot qui intéragirait avec la case.
     * @return Si le nombre des clés est plus grand que 0 ou la représentation de la porte est comme vide alors la méthode retournera vrai, sinon elle retournera faux.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        if (robot.nbrCles > 0 || this.representation == ' ') {
            return true;
        }
        return false;
    }


    /**
     * Lors de l'intéraction, si la représentation n'est pas vide, alors c'est comme ouvrir une nouvelle porte.
     * Si la représentation est une case vide, donc la porte était déja ouverte et le robot pourrait passer sans demander une clé de nouveau.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {

        if (interactionPossible(robot)) {
            if (this.representation != ' ') {
                robot.nbrCles--;
                this.setRepresentation(' ');

            }
        }
    }
}
