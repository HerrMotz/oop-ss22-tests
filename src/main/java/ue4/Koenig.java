package ue4;

public class Koenig extends Einwohner {
    /*
    3. Der König zahl auch für sein steuerpflichtiges Einkommen keine Steuern.
    Hier ist explizit nicht
    "zu versteuerndes Einkommen" geändert,
    sondern nur, dass er keine Steuern zahlen muss
     */
    @Override
    public int steuer() {
        return 0;
    }
}
