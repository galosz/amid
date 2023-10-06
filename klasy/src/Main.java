import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Klasy[] klasy= new Klasy[10];
        klasy[1] = new Klasy(8,1);
        klasy[2] = new Klasy(15,2);
        klasy[3] = new Klasy(20,3);
        klasy[4] = new Klasy(25,4);
        klasy[5] = new Klasy(22,5);
        klasy[6] = new Klasy(19,6);
        klasy[7] = new Klasy(13,7);
        klasy[8] = new Klasy(10,8);
        klasy[9] = new Klasy(30,9);
        Scanner scanner= new Scanner(System.in);

        for (int i=0;i<10;i++){
            int m;
            System.out.println();
            System.out.println("Co zrobic:");
            System.out.println("wynajmowanie sal- 1");
            System.out.println("mozliwosc rezerwacji- 2");
            m=scanner.nextInt();

            switch (m){
                case 1:{
                    int id;
                    System.out.println("wynajmowanie");
                    System.out.println(" numer sali: ");
                    id=scanner.nextInt();
                    klasy[id].rez();
                }break;
                case 2:{
                    int id,godz,data;
                    System.out.println("sprawdzanie");
                    System.out.println(" numer sali: ");
                    id=scanner.nextInt();
                    System.out.println("dzien miesiaca");
                    data=scanner.nextInt();
                    System.out.println("godzina");
                    godz=scanner.nextInt();
                    klasy[id].sprawrez(data,godz);

                }break;
                case 3:{

                    System.exit(0);
                }

            }
        }
    }


}