import java.util.Scanner;
public class Trojkat {
    Scanner scan= new Scanner(System.in);
    Trojkat(){

        double bok,wys;
        System.out.println("długość podstawy: ");
        bok=scan.nextDouble();
        System.out.println("długość wysokości: ");
        wys=scan.nextDouble();

        if (bok>0 && wys>0){
            System.out.println("pole wynosi: " + (bok * wys / 2));
        }else {System.out.println("złe parametry trójkąta");}
    }
}