import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        for (;;){
            int wyb;
            System.out.println("Wybierz figurę:\n" + "1. Kwadrat\n" + "2. Prostokąt\n" + "3. Trójkąt\n" + "4. Wyjście\n");
            wyb=scan.nextInt();
            if (wyb>0 && wyb<5) {
                switch (wyb) {
                    case 1:
                        Kwadrat kwadrat = new Kwadrat();
                        break;
                    case 2:
                        Prostokat prostokat = new Prostokat();
                        break;
                    case 3:
                        Trojkat trojkat = new Trojkat();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }else {System.out.println("błąd");}
        }
    }
}