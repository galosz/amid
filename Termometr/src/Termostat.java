public class Termostat {
    private double aktualnaTemperatura;
    private double ustawionaTemperatura;
    private boolean ogrzewanieWlaczone;
    private boolean chlodzenieWlaczone;

    public Termostat(double ustawionaTemperatura) {
        this.ustawionaTemperatura = ustawionaTemperatura;
        this.aktualnaTemperatura = 20.0;
        this.ogrzewanieWlaczone = false;
        this.chlodzenieWlaczone = false;
    }

    public void wlaczOgrzewanie() {
        ogrzewanieWlaczone = true;
        chlodzenieWlaczone = false;
        System.out.println( "Ogrzewanie zostało włączone." );
    }

    public void wylaczOgrzewanie() {
        ogrzewanieWlaczone = false;
        System.out.println( "Ogrzewanie zostało wyłączone." );
    }

    public void wlaczChlodzenie() {
        chlodzenieWlaczone = true;
        ogrzewanieWlaczone = false;
        System.out.println( "Chłodzenie zostało włączone." );
    }

    public void wylaczChlodzenie() {
        chlodzenieWlaczone = false;
        System.out.println( "Chłodzenie zostało wyłączone." );
    }

    public void symulujDzialanie() {

        if (ogrzewanieWlaczone) {
            aktualnaTemperatura += 0.5;
        } else if (chlodzenieWlaczone) {
            aktualnaTemperatura -= 0.5;
        }

        System.out.println( "Aktualna temperatura: " + aktualnaTemperatura + " stopni Celsiusza" );

        if (aktualnaTemperatura < ustawionaTemperatura && ogrzewanieWlaczone == true) {
            System.out.println( "Ogrzewanie jest włączone." );
        } else if (chlodzenieWlaczone == true) {
            System.out.println( "Chłodzenie jest włączone." );
        }
    }
}