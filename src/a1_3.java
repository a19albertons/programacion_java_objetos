import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

class MyLittleDecimal{
//    atributos
    private int valor;


//    constructor
    public MyLittleDecimal(String s){
        valor = parseInt(s.replace(".","").replace(",",""));
    }
//    Get y set autogenerados
    public int getValor(){
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    //    Metodos
    public MyLittleDecimal sumar(MyLittleDecimal m){
        MyLittleDecimal devolver = new MyLittleDecimal(String.valueOf(this.valor+m.valor));
        return devolver;
    }
    public MyLittleDecimal restar(MyLittleDecimal m){
        MyLittleDecimal devolver = new MyLittleDecimal(String.valueOf(this.valor-m.valor));
        return devolver;
    }
    public MyLittleDecimal multiplicar(MyLittleDecimal m){
        String texto = String.valueOf(this.valor*m.valor);
        texto = texto.substring(0,texto.length()-2);
        MyLittleDecimal devolver = new MyLittleDecimal(texto);
        return devolver;
    }
    public MyLittleDecimal dividir(MyLittleDecimal m){
        String texto = String.valueOf(this.valor*100/m.valor);
//        texto = texto.substring(0,texto.length()-2);
        MyLittleDecimal devolver = new MyLittleDecimal(texto);
        return devolver;
    }

    @Override
    public String toString() {
        String primeraParte;
        if (valor>=0){
            primeraParte=String.valueOf(abs(valor/100));
        }
        else {
            primeraParte="-"+abs(valor/100);
        }

        String segundaParte;
        if (abs(valor%100) >=0 && abs(valor%100) <=9){
            segundaParte="0"+abs(valor%100);
        }
        else {
            segundaParte=""+abs(valor%100);
        }
        return primeraParte+","+segundaParte;
    }
}


public class a1_3 {
    public static void main(String[] args){
        MyLittleDecimal mld1 = new MyLittleDecimal("200,22");
        MyLittleDecimal mld2 = new MyLittleDecimal("10,11");
        MyLittleDecimal mld3=mld1.sumar(mld2);
        System.out.println(mld1.getValor()+" "+mld2.getValor()+" "+mld3.getValor());

        mld1 = new MyLittleDecimal("200,22");
        mld2 = new MyLittleDecimal("10,11");
        mld3=mld1.sumar(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("5000,05");
        mld2 = new MyLittleDecimal("2,00");
        mld3=mld1.multiplicar(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("-200,22");
        mld2 = new MyLittleDecimal("10,11");
        mld3=mld1.sumar(mld2);
        System.out.println(mld1.getValor()+" "+mld2.getValor()+" "+mld3.getValor());

        mld1 = new MyLittleDecimal("-200,22");
        mld2 = new MyLittleDecimal("10,11");
        mld3=mld1.sumar(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("100,00");
        mld2 = new MyLittleDecimal("300,00");
        mld3=mld1.dividir(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("-1,00");
        mld2 = new MyLittleDecimal("3,00");
        mld3=mld1.multiplicar(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("-1,00");
        mld2 = new MyLittleDecimal("-3,00");
        mld3=mld1.multiplicar(mld2);
        System.out.println(mld3);

        MyLittleDecimal mld4 = new MyLittleDecimal("-0,02");
        System.out.println(mld4);

        mld1 = new MyLittleDecimal("0,50");
        mld2 = new MyLittleDecimal("1,25");
        mld3=mld1.sumar(mld2);
        System.out.println(mld3);

        mld1 = new MyLittleDecimal("1,00");
        mld2 = new MyLittleDecimal("1,00");
        mld3=mld1.restar(mld2);
        System.out.println(mld3);
    }
}
