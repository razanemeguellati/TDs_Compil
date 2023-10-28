import java.util.Arrays;
import java.util.List;

public class AFD {

    // une fonction qui implimente l'automate avec ces conditions :
    // 1) Il doit commencer obligatoirement par une lettre
    // 2) Il ne doit pas contenir 2 tirets consécutifs ni 2 chiffres consécutifs
    // 3) Il ne doit pas finir par un tiret

    public static boolean Verifier_Chaine_Automate(String chaine) {
      /* On utilise un tableau des États finaux
         pour que l'on puisse identifier plus tard que le parcours de la chaîne
         met l'automate à son état final.
      */

        String[] EtatsFinauxarr = {"S1", "S2"};
        //S3 n'est pas un etat final car c'est celui qui lit la tiret en dernier

        // on cast le tableau vers une liste pour pouvoir utiliser la fonction "contain"
        List<String> EtatsFinaux = Arrays.asList(EtatsFinauxarr);

        // Initialiser l'état courant à l'état initial
        String etatCourant = "S0";

        char charactere = chaine.charAt(0);

        System.out.println("________________Les Etats de l'automate parcourus:_________________");

        //Parcours de la chaine de charactere et verifiant chaque char pour chaque etat :

        for (int i = 0; i < chaine.length(); i++) {
            charactere = chaine.charAt(i);

            System.out.print("|-> " + etatCourant );
            switch (etatCourant) {
                case "S0":
                    if (Character.isLetter(charactere)) {
                        etatCourant = "S1";

                    } else {
                        return false;
                    }
                    break;

                case "S1":
                    if (Character.isLetter(charactere)) {
                        etatCourant = "S1";

                    } else if (Character.isDigit(charactere)) {
                        etatCourant = "S2";

                    } else if (charactere == '-') {
                        etatCourant = "S3";

                    } else {

                        return false;
                    }

                    break;


                case "S2":
                    if (Character.isLetter(charactere)) {
                        etatCourant = "S1";

                    } else if (charactere == '-') {
                        etatCourant = "S3";

                    } else {
                        return false;
                    }
                    break;


                case "S3":
                    if (Character.isDigit(charactere)) {
                        etatCourant  = "S2";

                    } else if (Character.isLetter(charactere)) {
                        etatCourant = "S1";

                    } else {

                        return false;
                    }
                    break;

            }
        }
        System.out.println("\n___________________________________________________________________");
        // si l'automate a atteint l'un de ses etats finaux ou non
        return EtatsFinaux.contains(etatCourant );
    }

    // une fonction qui implimente la contrainte n°2 : "Il doit contenir au moins 2 caractères"
    // car on peux pas la vérifier avec l'ADF :  .
    public static boolean Verifier_Contrainte_Programe(String chaine) {
        boolean result = false;
        if (chaine.length() >= 2) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
