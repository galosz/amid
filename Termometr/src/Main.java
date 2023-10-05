public class Main {
    public static void main(String[] args) {

        Termostat termostat = new Termostat(22);

        termostat.wlaczOgrzewanie();
        for (double i = 0; i < 4; i++) {
            termostat.symulujDzialanie();
        }
        System.out.println( "Temperatura jest ustabilizowana." );
        termostat.wylaczOgrzewanie();
        termostat.wlaczChlodzenie();
        for (int i = 0; i < 4; i++) {
            termostat.symulujDzialanie();
        }
        System.out.println( "Temperatura jest ustabilizowana." );
        termostat.wylaczChlodzenie();
    }
}
