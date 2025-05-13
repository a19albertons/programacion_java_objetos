public class a2_1 {
    public static void main(String[] args) {
        Dinero dinero = Dinero.getInstance(100, "España");
        System.out.println(dinero.getClass().getSimpleName());
        System.out.println(dinero.getSimbolo());
        System.out.println(dinero);
        System.out.println();

        Dinero dinero2 = Dinero.getInstance(500, "Perú");
        System.out.println(dinero2.getClass().getSimpleName());
        System.out.println(dinero2.getSimbolo());
        System.out.println(dinero2);
        System.out.println();

        Dinero dinero3 = Dinero.getInstance(400, "Chile");
        System.out.println(dinero3.getSimbolo());
        System.out.println(dinero3);
    }
}
//abstract class Dinero {
//    int cantidad;
//
//    public Dinero(int cantidad) {
//        this.cantidad = cantidad;
//    }
//
//    static Dinero getInstance(int cantidad, String pais) {
//        if (pais.equals("España") || pais.equals("Portugal") || pais.equals("Italia")) {
//            return new DineroEuropeo(cantidad);
//        } else {
//            return new DineroUSA(cantidad);
//        }
//    }
//
//    abstract String getSimbolo();
//    public String toString(){
//        return cantidad+getSimbolo();
//    }
//}
//
//class DineroEuropeo extends Dinero {
//
//    public DineroEuropeo(int cantidad) {
//        super(cantidad);
//    }
//    @Override
//    String getSimbolo(){
//        return "€";
//    }
//
//}
//
//class DineroUSA extends Dinero {
//
//    public DineroUSA(int cantidad) {
//        super(cantidad);
//    }
//    @Override
//    String getSimbolo(){
//        return "$";
//    }
//}