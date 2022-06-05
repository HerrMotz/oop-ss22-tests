package ue5;

public class AutoTest {
    public static void main (String[] args) {
        Auto[] autos = new Auto[4];

        autos[0] = new PickUp(100);
        autos[1] = new Auto("J-AA 02");
        autos[2] = new Auto("J-AA 03", true);
        autos[3] = new PickUp("J-AA 04", 1000);

        for (Auto j : autos) {
            System.out.println(j);
        }

        autos[0].fahre(299);
        autos[1].fahre(2900);
        autos[2].fahre(200000);
        autos[3].fahre(2000000);

        autos[2].fahreAntenneAus();
        System.out.println(autos[2].getSitzplaetze());
        System.out.println(autos[2].getKilometerstand());

        autos[0].wasche();
        autos[1].wasche();
        autos[2].wasche();
        autos[3].wasche();

        if (!((PickUp)autos[0]).beladen(1000)) {
            ((PickUp)autos[0]).beladen(100);
        }
        System.out.println(autos[0]);
        ((PickUp)autos[0]).entladen(-1000);
        System.out.println(autos[0]);

        ((PickUp)autos[0]).beladen(50);
        System.out.println(autos[0]);
        ((PickUp)autos[0]).beladen(50);

        for (Auto j : autos) {
            System.out.println(j);
        }

        System.out.println(autos[2].getKennzeichen());
        System.out.println(autos[3].getKennzeichen());
    }
}
