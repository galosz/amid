import java.util.Scanner;
public class Prostokat {
    Scanner scan= new Scanner(System.in);
    Prostokat(){

        double bok,bok2;
        System.out.println("długość pierwszego boku: ");
        bok=scan.nextDouble();
        System.out.println("długość drugiego boku: ");
        bok2=scan.nextDouble();

        if (bok>0 && bok2>0) {
            System.out.println("pole wynosi: " + (bok * bok2));
        }else {System.out.println("złe parametry prostokąta");}
    }
}