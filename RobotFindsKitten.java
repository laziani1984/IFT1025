import java.util.Scanner;

/**
 * @author Wael ABOU ALI(20034365) et Samuel HÉLIE(20113010).
 * @version 1.0
 * @return C'est le jeu d'un Robot (#) qui cherche un Chaton et qui examine chaque objet sur la grille, jusqu’à ce qu’il trouve ce chaton.
 * @since 03-04-2018.
 */

public class RobotFindsKitten {

    public static void main(String[] args) {
        System.out.println("       Bienvenue dans RobotFindsKitten");
        System.out.print("Super Dungeon Master 3000 Ultra Turbo Edition !\n");
        Grille grid = createGrid();
        Robot robot = createRobot(grid);
        deroulementJeu(grid, robot);
    }

    /**
     * @return La méthode createGrid va retourner la grille du jeu avec les spécifications envoyées au constructeur Grille.
     */
    public static Grille createGrid() {
        return new Grille(5, 2, 11, 5, 50);
    }

    /**
     * @param grid C'est la grille du jeu.
     * @return Retourne un Robot dans une position quelconque(Point posRobot) sur la grille grid.
     */
    public static Robot createRobot(Grille grid) {
        Point posRobot = grid.randomEmptyCell();
        return new Robot(posRobot.getX(), posRobot.getY());
    }

    /**
     * C'est le déroulement du jeu, il demande d'entrer une direction pour déplacer le robot
     *
     * @param grid
     * @param robot
     */
    public static void deroulementJeu(Grille grid, Robot robot) {
        Scanner scanner = new Scanner(System.in);
        while (Kitten.isCaptured == false) {
            grid.afficher(robot);
            if (Robot.teleporteur == false) {
                System.out.print(Robot.getNom() + ". [" + Robot.nbrCles + "]>");
            } else {
                System.out.print(Robot.getNom() + ". [" + Robot.nbrCles + "]T>");
            }
            grid.robotMove(scanner.next().charAt(0), robot);
        }
    }
}
