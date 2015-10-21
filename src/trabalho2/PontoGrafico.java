package trabalho2;

/**
 *
 * @author Douglas, Patricia, Priscila, Tamires
 */
public class PontoGrafico {

    private double inX;
    private double inY;
    private double outX;
    private double outY;
    private double x;
    private double y;

    public PontoGrafico(double inX, double inY, double outX, double outY) {
        this.inX = inX;
        this.inY = inY;
        this.outX = outX;
        this.outY = outY;
    }

    public PontoGrafico(int x, double y) {
        this.inX = -1;
        this.inY = -1;
        this.outX = -1;
        this.outY = -1;
        this.x = x;
        this.y = y;
    }

    public double getInX() {
        return inX;
    }

    public double getInY() {
        return inY;
    }

    public double getOutX() {
        return outX;
    }

    public double getOutY() {
        return outY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
