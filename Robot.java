public class Robot extends Case {


    /**
     * Le robot a minimalement les attributs suivants :
     * - (String) nom du robot.
     * - (Point) position x, y sur la grille.
     * - (int) nombre de clés collectées (et pas encore utilisées).
     * - (boolean) possède le téléporteur ou non.
     */
    private static String nom;
    private Point posRobot;
    public static int nbrCles = 0;
    public static boolean teleporteur = false;


    /**
     * Le constructeur Robot va instancier un robot avec un nom, un point qui indique sa position sur la grille et une représentation ASCII.
     *
     * @param x C'est la position x à partir de la largeur de la grille.
     * @param y C'est la position y à partir de la hauteur de la grille.
     */
    public Robot(int x, int y) {

        this.nom = "R.O.B";
        this.posRobot = new Point(x, y);
        this.representation = '#';
    }


    /**
     * @return Retourne le point qui indique la position actuelle du robot.
     */
    public Point getPosRobot() {

        return posRobot;
    }


    /**
     * @param posRobot Change le point qui indique la position actuelle du robot dans la grille à la nouvelle position passée en paramètre.
     */
    public void setPosRobot(Point posRobot) {

        this.posRobot = posRobot;
    }


    /**
     * @return Retourne le nom du robot.
     */
    public static String getNom() {

        return nom;
    }


    /**
     * @param robot Le robot qui interagirait avec la case
     * @return Retourne toujours faux puisqu'un robot va jamais s'intéragir avec lui même.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        return false;
    }


    /**
     * Un robot va jamais intéragir avec lui même.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {}
}
