public class Grille {


    /**
     *  - Le tableau des Cases grille Case[][] grille sera un talbeau 2D.
     *  - Ce tableau aura une largeur totale "largeurGrille".
     *  - Aussi, hauteur totale "hauteurGrille".
     *  - posX et posY seront les coordonnèes du point (Case)grille[y][x] à comparer avec la position actuelle du robot.
     *  - Pour le randomX et randomY seront les deux containeurs pour les coordonnées aléatoires x et y.
     *  - Ces deux variables seront utilisées pour produire des points aléatoires. Ces points seront utilisés lors de l'instanciation des objets dans la grille.
     *  - NB : ** puisque l'appel de la fonction Point(int x,int y) et l'application de la grille c'est au début y comme colonne et puis x comme rangée,
     *            et puisque dans la création de la grille j'ai choisi le système (colonne, rangée). Donc sur la grille la postion d'une case sera
     *            this.grille[y][x] mais pour l'appel de la création d'un point sera new Point(x,y).De même pour les classes des cases pour ne pas
     *            changer la méthode de création des points. **
     */
    private Case[][] grille;
    private int largeurGrille, hauteurGrille, posX, posY, randomX, randomY;


    /**
     * Cette fonction initialise la grille en créant les pièces, les portes, les murs, les clés et les items (le téléporteur, les NonKittenItems et le Kitten)
     * Il y a ‘nbrNonKitten‘ NonKittenItems au total sur tout le jeu.
     *
     * @param nbrPiecesX    C'est le nombre des chambres dans chaque rangée x.
     * @param nbrPiecesY    C'est le nombre des chambres dans chaque rangée y.
     * @param hauteurPiece  C'est la hauteur de chaque chambre sans prendre les bordures en considération.
     * @param largeurPiece  C'est la largeur de chaque chambre sans prendre les bordures en considération.
     * @param nbrNonKitten  C'est le nombre de NonKittenItems dans la grille.
     */
    public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece, int hauteurPiece, int nbrNonKitten) {

        int hautChambre = hauteurPiece + 1;
        int largChambre = largeurPiece + 1;
        largeurGrille = (nbrPiecesX * largChambre) + 1;
        hauteurGrille = (nbrPiecesY * hautChambre) + 1;
        this.grille = new Case[hauteurGrille][largeurGrille];
        dessinerGrille(hauteurPiece, largeurPiece, hautChambre, largChambre, nbrPiecesX, nbrPiecesY, nbrNonKitten);
    }


    /**
     * @param hauteurPiece
     * @param largeurPiece
     * @param hautChambre     C'est la hauteur d'une chambre incluant sa bordure.
     * @param largChambre    C'est la largeur d'une chambre incluant sa bordure.
     * @param nbrPiecesX
     * @param nbrPiecesY
     * @param nonKitten     C'est le nombre des éléments nonKitten à instancier dans la grille.
     * Cette méthode va instancier des cases(objets) (Murs et portes auront des positions fixes)dans la grille et aléatoirement pour les
     * éléments(Kitten,Cle,NonKitten, Vide et Téléporteur). Au début, [les murs, les portes](bordures) et les espaces vides seront crées
     * puis l'instanciation du Kitten, Cle, Teleporteur et nonKitten auront lieu après.
     */
    public void dessinerGrille(int hauteurPiece, int largeurPiece, int hautChambre, int largChambre, int nbrPiecesX, int nbrPiecesY, int nonKitten) {

        int moyLarg = largeurPiece / 2 + 1, moyHaut = hauteurPiece / 2 + 1;
        for (int i = 0; i < hauteurGrille; i++) {
            for (int j = 0; j < largeurGrille; j++) {
                if (i == 0 || i % hautChambre == 0 || i == hauteurGrille - 1 || j == 0 || j % largChambre == 0 || j == largeurGrille - 1) {
                    if (i != 0 && i != hauteurGrille - 1 && j != 0 && j != largeurGrille - 1 && (j % largChambre == moyLarg || i % hautChambre == moyHaut)) {
                        this.grille[i][j] = new Porte(j + 1, i);
                    } else {
                        this.grille[i][j] = new Mur();
                    }
                } else {
                    this.grille[i][j] = new Vide();
                }
            }
        }
        assignerTeleporteur();
        assignerCles(hauteurPiece, largeurPiece, nbrPiecesX, nbrPiecesY);
        assignerKitten();
        assignerNonKitten(nonKitten);
    }


    /**
     *  C'est une méthode utilisée pour instancier un téléporteur aléatoirement dans la grille.
     */
    public void assignerTeleporteur() {

        Point teleportPos = randomEmptyCell();
        this.grille[teleportPos.getY()][teleportPos.getX()] = new Teleporteur(teleportPos.getX(), teleportPos.getY());
    }


    /**
     * C'est une méthode utilisée pour instancier un chaton aléatoirement dans la grille.
     */
    public void assignerKitten() {

        Point kittenPos = randomEmptyCell();
        this.grille[kittenPos.getY()][kittenPos.getX()] = new Kitten();
    }


    /**
     * @param nbrNonKitten C'est le nombre des éléments nonKitten qui seront instanciés dans la grille.
     */
    public void assignerNonKitten(int nbrNonKitten) {

        for (int i = 0; i < nbrNonKitten; i++) {
            Point point = randomEmptyCell();
            this.grille[point.getY()][point.getX()] = new NonKitten();
        }
    }


    /**
     * @param hauteurPiece
     * @param largeurPiece
     * @param nbrPiecesX
     * @param nbrPiecesY
     * Enfin, cette méthode est utilisée pour assigner une et seulement une clé dans chaque chambre de la grille.
     */
    public void assignerCles(int hauteurPiece, int largeurPiece, int nbrPiecesX, int nbrPiecesY) {

        for (int a = 0; a < nbrPiecesY; a++) {
            for (int b = 0; b < nbrPiecesX; b++) {
                int minH = 1 + a * (hauteurPiece + 1);
                int maxH = hauteurPiece + minH - 1;
                int minL = 1 + b * (largeurPiece + 1);
                int maxL = largeurPiece + minL - 1;
                Point point = randomEmptyCell(minH, maxH, minL, maxL);
                this.grille[point.getY()][point.getX()] = new Cle();
            }
        }
    }

    
    /**
     * C'est une méthode surchargée.
     * @param minH  C'est la borne inférieure des cases d'après lesquelles une coordonnée aléatoire y sera choisie.
     * @param maxH  C'est la borne supérieure des cases d'après lesquelles une coordonnée aléatoire y sera choisie.
     * @param minL  C'est la borne inférieure des cases d'après lesquelles une coordonnée aléatoire x sera choisie.
     * @param maxL  C'est la borne supérieure des cases d'après lesquelles une coordonnée aléatoire x sera choisie.
     * @return Retourne un point aléatoire dans chaque chambre qui sera borné par (maxH et minH) pour l'hauteur et (maxL et minL) pour la largeur.
     */
    public Point randomEmptyCell(int minH, int maxH, int minL, int maxL) {

        boolean isRandom = false;
        while (isRandom == false) {
            randomX = (int) (Math.random() * (maxL - minL) + 1) + minL;
            randomY = (int) (Math.random() * (maxH - minH) + 1) + minH;
            if (this.grille[randomY][randomX].representation == ' ') {
                return new Point(randomX, randomY);
            }
        }
        return null;
    }


    /**
     * Affiche la grille dans la console à coups de System.out.println(...).
     *
     * @param robot Il prend le robot comme paramètre pour afficher sa position actuelle et son déplacement dans la grille.
     */
    //
    public void afficher(Robot robot) {

        for (int i = 0; i < hauteurGrille; i++) {
            for (int j = 0; j < largeurGrille; j++) {
                if (robot.getPosRobot().egal(j, i)) {
                    System.out.print(robot.getRepresentation());
                } else {
                    System.out.print(this.grille[i][j].getRepresentation());
                }
            }
            System.out.println();
        }
    }


    /**
     * @return Retourne une coordonnée de cellule qui ne contient rien.
     */
    public Point randomEmptyCell() {

        boolean isRandom = false;
        while (isRandom == false) {
            randomX = (int) (Math.random() * largeurGrille);
            randomY = (int) (Math.random() * hauteurGrille);
            if (this.grille[randomY][randomX].representation == ' ') {
                return new Point(randomX, randomY);
            }
        }
        return null;
    }


    /**
     * @param robot
     * @param x C'esr la coordonnée de x de la nouvelle case.
     * @param y C'esr la coordonnée de y de la nouvelle case.
     * @return indique si c’est possible pour le robot de marcher sur la cellule de coordonnée (x, y).
     */
    public boolean deplacementPossible(Robot robot, int x, int y) {

        if (this.grille[y][x].interactionPossible(robot) && x > 0 && y > 0 && x < largeurGrille - 1 && y < hauteurGrille - 1) {
            return true;
        }
        return false;

    }

    /**
     * Lance l’interaction entre le Robot robot et la case de la grille sur laquelle il se trouve L’"interaction" peut être l’affichage d’un message
     * (pour les NonKittenItems),l’ouverture d’une Porte, le fait de ramasser une clé ou un téléporteur, ou encore le fait de gagner la partie en
     * trouvant le Kitten.
     *
     * @param robot
     */
    public void interagir(Robot robot) {

        this.grille[posY][posX].interagir(robot);
    }


    /**
     * @param c Ça représente le caractère pour diriger le robot soit en haut('w'), en bas('s'), à gauche('a'), à droite('d') ou pour le téléporter('t').
     * @param robot Le robot en paramètre pour utiliser comparer la position actuelle du robot avec la position en direction demandée,
     *              pour éviter le déplacement invalide.
     *
     * Enfin, si le déplacement est valide, alors le robot sera déplacé dans la direction envoyée. Si la case possède une intéraction spéciale, donc la méthode
     * interagir de la grille, avec la position du robot, sera appelée.
     */
    public void robotMove(char c, Robot robot) {

        posX = robot.getPosRobot().getX();
        posY = robot.getPosRobot().getY();
        switch (c) {

            case 'w':
                if (this.deplacementPossible(robot, posX, posY - 1)) {
                    posY = robot.getPosRobot().getY() - 1;
                }
                break;

            case 's':
                if (this.deplacementPossible(robot, posX, posY + 1)) {
                    posY = robot.getPosRobot().getY() + 1;
                }
                break;

            case 'a':
                if (this.deplacementPossible(robot, posX - 1, posY)) {
                    posX = robot.getPosRobot().getX() - 1;
                }
                break;

            case 'd':
                if (this.deplacementPossible(robot, posX + 1, posY)) {
                    posX = robot.getPosRobot().getX() + 1;
                }
                break;

            case 't':
                if (Robot.teleporteur) {
                    Point nouvellePos = this.randomEmptyCell();
                    ajusterCases(robot, nouvellePos.getX(), nouvellePos.getY());
                    Robot.teleporteur = false;
                }
                break;

            default:
                break;
        }
        if (c != 't') {
            this.interagir(robot);
            ajusterCases(robot, posX, posY);
        }
    }


    /**
     * @param robot
     * @param posX C'est la coordonnée de x de la nouvelle case.
     * @param posY C'esr la coordonnée de y de la nouvelle case.
     * Ces deux coordonnées seront utilisées pour créer un nouveau point nouvPos. Ce point sera utilisé par la méthode setPosRobot pour changer la position
     * du robot à la case dont les coordonnèes sont nouvPos.
     */
    private void ajusterCases(Robot robot, int posX, int posY) {

        Point nouvPos = new Point(posX, posY);
        robot.setPosRobot(nouvPos);
    }
}