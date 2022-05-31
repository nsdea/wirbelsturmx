import basis.Farbe;
import basis.Fenster;
import basis.Hilfe;
import basis.Knopf;
import basis.Leinwand;

public class Spiel3 {
    private Fenster fenster = new Fenster("WirbelGame", 600, 500);
    private Leinwand leinwand = new Leinwand(20.0d, 20.0d, 560.0d, 390.0d);
    private Knopf kEnde = new Knopf("Ende", 450.0d, 430.0d, 130.0d, 50.0d);
    private Ball ball = new Ball(this.leinwand);
    private Schieber schieber = new Schieber(this.leinwand);

    public Spiel3() {
        this.fenster.setzeHintergrundFarbe(Farbe.HELLGRAU);
        this.kEnde.setzeSchriftGroesse(20);
        this.schieber.lerneBallKennen(this.ball);
    }

    public void fuehreAus() {
        while (!this.kEnde.wurdeGedrueckt()) {
            Hilfe.kurzePause();
            if (!this.ball.verloren()) {
                this.ball.bewege();
                this.schieber.bewege();
            }
        }
        this.fenster.gibFrei();
    }

    public static void main(String[] args) {
        new Spiel3().m0fhreAus();
    }
}
