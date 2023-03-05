package tp2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 2289389, Rayan Smidi
 */
public class TP2 {

    public static int NombreJoueurs() {
        // Code qui va demander le nombre de joueurs et le stocker dans un int
        Scanner var = new Scanner(System.in);
        System.out.println("********************************************************************");
        System.out.println("Bienvenue dans le jeu de dés.\nCombien de joueurs vont jouer ?");
        int Njoueurs = var.nextInt();
        return Njoueurs;
    }

    public static String[] Nomjoueurs(int Njoueurs, String nom[]) {
        // Code qui va faire une boucle pour accomoder tous les noms, dans un array.
        Scanner var = new Scanner(System.in);
        for (int i = 1; i <= Njoueurs; i++) {
            System.out.print("Saisir le nom du joueur " + i + ":");
            nom[i] = var.nextLine();
        }
        System.out.println("********************************************************************");
        return nom;
    }

    public static void LancerDes(String nom[], int i, int[] somme, int Njoueurs, int nvalide, int[] mille, int[] deux,
            int[] trois,
            int[] quatre, int[] cinq, int[] six) {
  
        Random random = new Random();
         // declaration de variables exclusifs a la methode
        int de[] = new int[3];
        //boucle do qui s'arrete si le score est > a 5000
        do {
            //boucle while qui va passer a travers tous les noms
            while (i < nom.length) {
               // les "(if (somme[i] > 5000)) break;" sont une assurance que le code ne va jamais calculer pour rien 
                if (somme[i] > 5000)
                    break;
                for (int j = 1; j > 0; j++) {
                    //boucle infinie qui calcule le nombre de lancer, en theorie lui aussi infini tant qu'on score des points
                    // quand un lancer donne un score de 0, il se renesialise a 1 
                    if (somme[i] > 5000)
                        break;
                    System.out.print("Joueur " + i + " : " + nom[i] + " : Total : " + somme[i] + "\n");
                    System.out.println("Lancer " + j + ":");
                    nvalide = somme[i]; // cette ligne sert a valider si le resulat a changer, si il na pas changer, cest que les points sont 0
                    for (int k = 0; k < 3; k++) {
                        //boucle qui fais les 3 des du lancer
                        if (somme[i] > 5000)
                            break;
                        de[k] = random.nextInt(6) + 1;
                        System.out.print(de[k] + " ");
                        //calcul des points en utilisant des constantes predefinis
                        if (de == mille) {
                            somme[i] += 1000;
                        } else if (de == deux) {
                            somme[i] += 200;
                        } else if (de == trois) {
                            somme[i] += 300;
                        } else if (de == quatre) {
                            somme[i] += 400;
                        } else if (de == cinq) {
                            somme[i] += 500;
                        } else if (de == six) {
                            somme[i] += 600;
                        } else {
                            for (int m = 0; m < de.length; m++) {
                                //calcul des points avec 1 et 5, voir si ils sont present dans le array
                                if (5 == de[k]) {
                                    somme[i] += 50;
                                    break;
                                } else if (1 == de[k]) {
                                    somme[i] += 100;
                                    break;
                                } else if ((!(de[k] == 1)) || (!(de[k] == 5))) {
                                    break;
                                }
                            }
                        }
                        if (somme[i] >= 5000)
                            break;
                    }
                    //validation pour voir si le pointage est 0 ou non, si oui, le tour s'arrete.
                    System.out.println("");
                    if (nvalide == somme[i]) {
                        j = 1;
                        break;
                    }
                    if (somme[i] >= 5000)
                        break;
                }
                // ifs qui servent a reparer des bugs qui sinon serais presents dans le code
                if (somme[i] >= 5000)
                    break;
                if (Njoueurs == 1)
                    break;
                else if (i + 1 == nom.length) {
                    i = 1;
                } else if (!(i + 1 == nom.length)) {
                    i++;
                    break;
                }
            }
            //code qui donne le gagnant
        } while (somme[i] < 5000);
        System.out.println("score final " + nom[i] + " " + somme[i]);
        System.out.println("le gagnant de la partie est " + nom[i]);
        System.out.println("********************************************************************");
    }

    public static void ContinuerJeu() {
        Scanner var = new Scanner(System.in);
        System.out.println("Voulez-vous jouer une autre partie?" + "\n" +
                "Faites « o », « O » ou « oui » pour continuer et faites « n », « N » ou « non » pour arrêter.");
        String choix = var.nextLine();
        switch (choix) {
            case "o", "O", "oui":
                main(null);
            case "n", "N", "non":
                break;
            default:
                System.out.println("reesayez");
                choix = var.nextLine();
                break;
        }
    }

    public static void main(String[] args) {
        int nvalide = 0;
        int i = 1;
        final int mille[] = { 1, 1, 1 };
        final int deux[] = { 2, 2, 2 };
        final int trois[] = { 3, 3, 3 };
        final int quatre[] = { 4, 4, 4 };
        final int cinq[] = { 5, 5, 5 };
        final int six[] = { 6, 6, 6 };
        int Njoueurs = 0;
        Njoueurs = NombreJoueurs();
        String nom[] = new String[Njoueurs + 1];
        int somme[] = new int[Njoueurs + 1];
        nom = Nomjoueurs(Njoueurs, nom);
        LancerDes(nom, i, somme, Njoueurs, nvalide, mille, deux, trois, quatre, cinq, six);
        ContinuerJeu();
    }
}
