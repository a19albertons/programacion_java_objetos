class TimeLapse{
//    atributos
    private int h;
    private int m;
    private int s;

//    ejercito de construcion
    public TimeLapse(){
        this.h=0;
        this.m=0;
        this.s=0;
    }
    public TimeLapse(int h, int m, int s){
        this.h=h;
        this.m=m;
        this.s=s;
    }
    public TimeLapse(TimeLapse t){
        this.h=t.h;
        this.m=t.m;
        this.s=t.s;
    }
    public TimeLapse(int s){
        this.s=s%60;
        int minutos=s/60;
        this.m=minutos%60;
        this.h=minutos/60;
    }

//    Metodos get a set autogenerados

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }


    public int totalSec() {
        return this.h*60*60+this.m*60+this.s;
    }
    public void reset(){
        this.h=0;
        this.m=0;
        this.s=0;
    }
    public void addSec(int sec){
        int totalSecundos = this.h*60*60+this.m*60+this.s+sec;
        this.s=totalSecundos%60;
        int minutos=totalSecundos/60;
        this.m=minutos%60;
        this.h=minutos/60;
    }
    public void addTime(TimeLapse t){
        int totalSecundos = this.h*60*60+this.m*60+this.s+t.h*60*60+t.m*60+t.s;
        this.s=totalSecundos%60;
        int minutos=totalSecundos/60;
        this.m=minutos%60;
        this.h=minutos/60;
    }

    @Override
    public String toString() {
        return "TimeLapse["+this.h+"h:"+this.m+"m:"+this.s+"s]";
    }
}

public class a1_2 {
    public static void main(String[] args){
        TimeLapse t = new TimeLapse();
        System.out.println(t);

        t = new TimeLapse(3, 25, 42);
        System.out.println(t);


        TimeLapse t1 = new TimeLapse(3, 25, 42);
        TimeLapse t2 = new TimeLapse(t1);
        System.out.println(t2);


        t = new TimeLapse(12930);
        System.out.println(t);


        t = new TimeLapse();
        t.setH(5);
        t.setM(20);
        t.setS(50);
        System.out.println(t);


        t = new TimeLapse(5, 20, 50);
        System.out.println(t.getH() + " " + t.getM() + " " + t.getS());

        t = new TimeLapse(5, 20, 50);
        System.out.println(t.totalSec());



        t = new TimeLapse(5, 20, 50);
        t.reset();
        System.out.println(t);



        t = new TimeLapse(5, 50, 50);
        t.addSec(10000);
        System.out.println(t);


        t = new TimeLapse(5, 50, 50);
        t.addTime(new TimeLapse(2, 46, 40));
        System.out.println(t);
    }
}
