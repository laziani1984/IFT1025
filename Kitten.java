import java.util.ArrayList;

public class Kitten extends Case {


    /**
     * (String) nom : Le nom du kitten qui sera choisi aléatoirement à partir de,
     * (ArrayLIst<String>) nomsKitten : qui est une copie du tableau,
     * (String[]) choisirNom : qui contient les noms des châtons, en utilisant un nombre aléatoire
     * (int) index.
     * (boolean) isCaptured : Pour indiquer si le châton est capturé ou pas, si c'est vrai, alors le jeu se termine.
     */
    private String nom;
    public static boolean isCaptured = false;
    private String[] choisirNom = {"Caramel", "Chocolat", "Lucy", "King Arthur", "Kitty", "Lilly"};
    private ArrayList<String> nomsKitten = copierTab(choisirNom);
    int index = (int) (Math.random() * nomsKitten.size());


    /**
     * Le constructeur Kitten va supprimer un nom de ls liste et ce nom sera attribué au châton choisi pour éviter toute sorte de duplication lors de la construction
     * de plusieurs châtons.
     */
    public Kitten() {

        this.nom = nomsKitten.remove(index);
        this.representation = getRandomSymbole();
    }


    /**
     * @return Lors de l'appel de cette méthode, elle va retourner le nom de cet objet.
     */
    public String getNom() {

        return nom;
    }


    /**
     * @param robot Le robot qui interagirait avec la case
     * @return L'interaction avec le robot sera toujours vrai puisque l'interaction d'un robot avec un châton va terminer le jeu.
     */
    @Override
    public boolean interactionPossible(Robot robot) {

        return true;
    }


    /**
     * Si vrai, la méthode indiquera que le jeu est terminé et affichera un message que le robot(son nom) a capturé le châton.
     *
     * @param robot
     */
    @Override
    public void interagir(Robot robot) {

        if (interactionPossible(robot)) {
            isCaptured = true;
            System.out.println("You found kitten! Way to go, robot.");
            System.out.println(this.getNom() + " <3 " + robot.getNom());

        }
    }
}
