
import java.util.ArrayList;
import java.util.Scanner;

public class ToDO {
    ArrayList<String> tytul= new ArrayList<>();
    ArrayList<String> opis= new ArrayList<>();
    ArrayList<String> status= new ArrayList<>();
    Scanner scan= new Scanner(System.in);
    void Start(){
        System.out.println("LISTA NUMEROWANA JEST OD 0!!!\n");
        System.out.println( "1. Dodaj zadanie\n" + "2. zakończ zadanie\n" + "3. Usuń zadanie\n" + "4. lista zadań\n" + "5. exit");
        int wyb= scan.nextInt();
        scan.nextLine();

        switch (wyb){
            case 1: dod();
            break;
            case 2: end();
            break;
            case 3: del();
            break;
            case 4: print();
            break;
            case 5: exit();
            break;
        }
    }
    void dod() {
        String a,b;
        System.out.println("tytuł: ");
        a=scan.nextLine();
        tytul.add(a);
        System.out.println("opis:");
        b=scan.nextLine();
        opis.add(b);
        status.add( " do zrobienia" );
    }
    void end(){
        System.out.println("numer do zakonczenia: ");
        int a= scan.nextInt();
        scan.nextLine();
        status.set(a,"zakonczone");
    };
    void del(){
        System.out.println("które usunąć: ");
        int a= scan.nextInt();
        status.remove(a);
        opis.remove(a);
        tytul.remove(a);
    }
    void  print(){
        System.out.println("Lista:\n" + tytul+" - "+opis+" - "+status);
        }
    void exit(){
        System.exit(0);
    }
}