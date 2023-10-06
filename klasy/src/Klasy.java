import java.util.Scanner;

public class Klasy {
    Scanner scanner= new Scanner(System.in);
    int ilemiejsc,id_sali;
    int trezerwacji[] = new int[9];
    int tdata[]= new int[9];
    int tgodz[]= new int[9];
    Klasy(int ilemiejsc,int id_sali){
        this.ilemiejsc=ilemiejsc;
        this.id_sali=id_sali;
    }
    int rez(){
        int data,godz,miejsca;
        System.out.println("rezerwacja sali nr: "+id_sali);
        System.out.println("dzien miesiaca: ");
        data= scanner.nextInt();
        System.out.println("godzina: ");
        godz= scanner.nextInt();
        System.out.println("ilosc miejsc");
        miejsca=scanner.nextInt();
        if (miejsca>ilemiejsc){
            return 0;
        }
        if (sprawrez(data,godz)==0){
            return 0;
        }else {
            System.out.println("Dodawanie rejestracji");
            for (int i=0;i< trezerwacji.length;i++){
                if (trezerwacji[i]==0){
                    trezerwacji[i]=i;
                    doddaty(data);
                    dodgodz(godz);
                    return 0;
                }
            }
        }
        return 0;
    }
    int sprawrez(int data,int godz){
        for (int i=0;i<tdata.length;i++){
            if (tdata[i]==data){
                if (tgodz[i]==godz){
                    System.out.println("data jest zajeta");
                    return 0;
                }
            }
        }
        System.out.println("data jest dostepna");
        return 1;
    }
    int doddaty(int data){
        for (int i=0;i<tdata.length;i++){
            if (tdata[i]==0){
                tdata[i]=data;
                return 0;
            }
        }
        return 0;
    }
    int dodgodz(int godz){
        for (int i=0;i<tgodz.length;i++){
            if (tgodz[i]==0){
                tgodz[i]=godz;
                return 0;
            }
        }
        return 0;
    }


}