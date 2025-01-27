import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

class Punto2D{

    //    atributos
    private double x;
    private double y;

    //    Constructores
    public Punto2D(){
        x=0.0;
        y=0.0;
    }
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto2D(Punto2D p){
        this.x = p.x;
        this.y = p.y;
    }

    //    getter and setter autogenerados
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    void flip() {
        double temporal=this.x;
        this.x=this.y;
        this.y=temporal;
    }
    public double dist(Punto2D p){
        return sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
    }
    public double manhattanDist(Punto2D p){
        return (abs(this.x-p.x)+abs(this.y-p.y));
    }
    public double slope(Punto2D p){
        return (this.y-p.y)/(this.x-p.x);
    }

    @Override
    public String toString() {
        return "Punto2D["+x+","+y+"]";
    }
}

public class a1_1 {
    public static void main(String[] args) {
        Punto2D p = new Punto2D();
        System.out.println(p);


        p = new Punto2D(3.2, -4.8);
        System.out.println(p);


        Punto2D p1 = new Punto2D(4.5, 5.5);
        Punto2D p2 = new Punto2D(p1);
        System.out.println(p2);


        p = new Punto2D();
        p.setX(5.5);
        p.setY(-2.0);
        System.out.println(p);



        p = new Punto2D(5.5, -2.0);
        System.out.println(p.getX() + " " + p.getY());




        p = new Punto2D(3.2, -4.8);
        p.flip();
        System.out.println(p);



        p = new Punto2D(-3.0, 4.0);
        System.out.println(p.dist(new Punto2D()));
        System.out.println(p.dist(new Punto2D(2.5, 1.5)));


        p1 = new Punto2D(-2.0, 3.0);
        p2 = new Punto2D(2.0, 1.0);
        System.out.println(p1.manhattanDist(p2));
        System.out.println(p2.manhattanDist(p1));


        p1 = new Punto2D(-2.0, 3.0);
        p2 = new Punto2D(2.0, 1.0);
        System.out.println(p1.slope(p2));
        p1.setY(-1);
        System.out.println(p1.slope(p2));
    }
}
