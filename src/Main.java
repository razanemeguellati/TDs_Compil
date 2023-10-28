import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("_______________ Devoir : TD COMPIL Exo5 ______________");
        System.out.println("\n--> Veuillez introduire une chaine : ");
        Scanner scn = new Scanner(System.in) ;
        String chaine_lue = scn.nextLine() ;

        AFD afd = new AFD();

        if (AFD.Verifier_Chaine_Automate(chaine_lue) && AFD.Verifier_Contrainte_Programe(chaine_lue) )
        {
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("--> la chaine est ** Acceptée ** par l'automate , ( " + chaine_lue + " ) appartient au language");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }
        else
        {   System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("--> la chaine est ** Rejetée ** par l'automate , ( "+ chaine_lue + " ) n'appartient pas au language");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }

    }
}
