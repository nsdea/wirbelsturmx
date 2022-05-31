// I'm just a Dutchman
package defpackage;

import basis.Leinwand;
import basis.Stift;

/* renamed from: Ball  reason: default package */
/* loaded from: Breakout.jar:Ball.class */
public class Ball {
    private Stift stift;
    private Leinwand leinwand;
    private double x = 50.0d;
    private double y = 50.0d;
    private int radius = 10;
    private double dx = 0.1d;
    private double dy = 0.2d;

    public Ball(Leinwand lw) {
        this.leinwand = lw;
        this.stift = new Stift(lw);
        this.stift.bewegeBis(this.x, this.y);
        this.stift.wechsle();
        this.stift.zeichneKreis(this.radius);
    }

    public boolean verloren() {
        return this.x > ((double) this.leinwand.breite());
    }

    public void abprallen() {
        this.dx = -this.dx;
    }

    public double yPos() {
        return this.y;
    }

    public double xPos() {
        return this.x;
    }

    public void bewege() {
        this.stift.kreis(this.x, this.y, this.radius);
        if (this.x < this.radius) {
            this.dx = -this.dx;
        }
        if (this.y < this.radius || this.y + this.radius > this.leinwand.hoehe()) {
            this.dy = -this.dy;
        }
        this.x += this.dx;
        this.y += this.dy;
        this.stift.kreis(this.x, this.y, this.radius);
    }
}
