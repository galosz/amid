import java.util.Scanner;
public class Kwadrat {
    Scanner scan= new Scanner(System.in);
    Kwadrat(){

        double bok;
        System.out.println("podaj długość boku ");
        bok=scan.nextDouble();

        if (bok>0) {
            double pole = bok * bok;
            System.out.println("pole wynosi:" + pole);
        }else {System.out.println("złe paramtery kwadratu");}
    }
}