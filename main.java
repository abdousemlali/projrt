
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


import static java.util.Calendar.PM;

public class main {

     static Scanner sc = new Scanner(System.in);
    static ArrayList<Employe> ArrayEmpolyé = new ArrayList<>();

    public static void main (String[] args) {

        Employe.menu();
        int choix = sc.nextInt();

        while (choix < 1 || choix > 9) {
            Employe.menu();
            choix = sc.nextInt();
        }
        while (choix >= 1 && choix <= 9) {
            switch (choix) {

                case 1:

                    ajouterEmployé();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;
                case 2:

                    afficheunEmploye();
                    choix = sc.nextInt();
                    break;
                case 3:
                    modifierEmploye();
                    choix = sc.nextInt();
                    break;
                case 4:
                    Supprimer();
                    choix = sc.nextInt();
                    break;
                case 5:
                    Affichersalair ();
                    choix =sc.nextInt();
                    break;
                case 6:
                    affichertouslesemploye();
                    choix =sc.nextInt();
                    break;
                case 7:
                    maxage();
                    choix =sc.nextInt();
                    break;
                case 8:
                    minage();
                    choix =sc.nextInt();
                    break;
                case 9:
                    quitter();
                    choix=sc.nextInt();
                    break;
            }


        }
    }


    //static List<Employe> ArrayEmpolyé2 = new ArrayList<>();


    static void ajouterEmployé () {

        System.out.print("Entrer le matricule :");
        int Matricule = sc.nextInt();
        System.out.print("Entrer le nom :");
        String Nom = sc.next();
        System.out.print("Enter le prenom :");
        String Prenom = sc.next();
        System.out.print("Entrer l'age :");
        int Age = sc.nextInt();
        System.out.print("Entre le salaire :");
        double Salaire = sc.nextDouble();
        Employe e = new Employe(Matricule, Nom, Prenom, Age, Salaire);
        ArrayEmpolyé.add(e);

        //Object Ma;
        // int i1 = 630 - 733870;
        // Employe e = new Employe(Ma…
        // [5:55 PM, 10/11/2022] +212 i1:
    }





    // pour afficher un employe
    static void afficheunEmploye () {

        if (ArrayEmpolyé.isEmpty()) {
            System.out.println("Il n'y a aucun employe !");
        } else {
            System.out.print("Entrer le matricule d'employe pour l'afficher :");
            int Matricule = sc.nextInt();
            int i=0;
            for (Employe e:ArrayEmpolyé) {
                i++;
                if (e.getMatricule() == Matricule) {
                    System.out.println("le matrucule est "+e.getMatricule()+" le nom est "+e.getNom()+" le prenom est "+e.getPrenom()+"l'age est "+e.getAge()+"le salire est "+e.getSalaire());
                }
            }
            System.out.println("Cet employe n'extste pas !");
        }
    }


    static void Affichersalair () {
        int nb = 0;
        if (ArrayEmpolyé.isEmpty()) {
            System.out.print("la base de donner est vide \n");

        } else {

            for (int i = 0; i < ArrayEmpolyé.size(); i++) {
                if (ArrayEmpolyé.get(i).getSalaire() > 1000) {
                    nb += 1;
                }
            }
            System.out.println("le nombre des employés ayant un salaire qui dépasse 1000 est : " + nb + "\n");
        }
    }
    static void modifierEmploye(){
        System.out.print("Entrer le matricule d'employe pour le modifier :");
        int Matricule=sc.nextInt();
        boolean exist=false;
        int i=0;
        int ind = 0;
        for (Employe e : ArrayEmpolyé){
            ++i;
            if (e.getMatricule()==Matricule){
                exist=true;
                ind=i;
            }
        }
        if (exist){
            System.out.println("Modification :");
            System.out.print("Entrer le matricule :");
            Matricule=sc.nextInt();
            System.out.print("Entrer le nom :");
            String Nom=sc.next();
            System.out.print("Enter le prenom :");
            String Prenom=sc.next();
            System.out.print("Entrer l'age :");
            int Age=sc.nextInt();
            System.out.print("Entre le salaire :");
            double Salaire=sc.nextDouble();
            Employe e = new Employe(Matricule,Nom,Prenom,Age,Salaire);
            ArrayEmpolyé.set(ind,e);

        }
        else {
            System.out.println("Cet employe indisponible !");

        }
    }
    static void affichertouslesemploye(){
        if(ArrayEmpolyé.isEmpty()){
            System.out.println("la base de donner est vide");
        }else{
            System.out.println(ArrayEmpolyé);
        }
    }
    static void Supprimer() {
        if (ArrayEmpolyé.isEmpty()) {
            System.out.print("la base de donner est vide ");
        } else {
            System.out.print("donner le matricule de l'employer suprimer : ");
            int Matricule = sc.nextInt();

            for (int i = 0; i < ArrayEmpolyé.size(); i++) {
                if (Matricule == ArrayEmpolyé.get(i).getMatricule()) {
                    ArrayEmpolyé.remove(i);
                    System.out.print("la supression d'employe fait avec succes");
                    System.out.print("\n");
                }else{
                    System.out.print("se matricule ne trouve pas ");
                    System.out.print("\n");
                }
            }
        }
    }
    static void maxage() {
        int max = 0;
        if (ArrayEmpolyé.isEmpty()) {
            System.out.print("la base de donner est vide ");
        } else {
            for(int i=0;i<ArrayEmpolyé.size();i++){
                if(ArrayEmpolyé.get(i).getAge()>max){
                    max=ArrayEmpolyé.get(i).getAge();
                }
            }
            System.out.println("l;employe est plus age"+max+" ans");

        }
    }
    static void minage() {
        int min = 10000;
        if (ArrayEmpolyé.isEmpty()) {
            System.out.print("la base de donner est vide ");
        } else {
            for(int i=0;i<ArrayEmpolyé.size();i++){
                if(ArrayEmpolyé.get(i).getAge()<min){
                    min=ArrayEmpolyé.get(i).getAge();
                }
            }
            System.out.println("l;employe est plus age"+min+" ans");

        }
    }
    static void quitter(){
        System.exit(0);
    }

}