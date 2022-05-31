package defpackage;

import basis.Hilfe;
import basis.Leinwand;
import basis.Maus;
import basis.Stift;

/* renamed from: Schieber  reason: default package */
/* loaded from: Breakout.jar:Schieber.class */
public class Schieber {
    private Ball ball = null;
    private Maus maus;
    private Stift stift;
    private Leinwand leinwand;
    private int x;
    private int y;

    public Schieber(Leinwand l) {
        this.leinwand = l;
        this.maus = new Maus(this.leinwand);
        this.stift = new Stift(this.leinwand);
        this.x = this.leinwand.breite() - 20;
        this.y = this.maus.vPosition();
        zeige();
    }

    public void lerneBallKennen(Ball b) {
        this.ball = b;
    }

    public double yPos() {
        return this.y;
    }

    public double xPos() {
        return this.x;
    }

    public void zeige() {
        if (this.y < 20) {
            this.y = 21;
        }
        if (this.y > this.leinwand.hoehe() - 20) {
            this.y = this.leinwand.hoehe() - 21;
        }
        this.stift.rechteck(this.x, this.y - 20, 5.0d, 40.0d);
    }

    public void bewege() {
        if (this.x - this.ball.xPos() <= 10.0d && Hilfe.betrag(this.ball.yPos() - this.y) < 20.0d) {
            this.ball.abprallen();
        }
        if (this.maus.vPosition() == this.y) {
            return;
        }
        this.stift.radiere();
        zeige();
        this.y = this.maus.vPosition();
        this.stift.normal();
        zeige();
    }
}
