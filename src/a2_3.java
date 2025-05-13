import java.math.BigDecimal;

//class Articulo{
//    String descripcion;
//    BigDecimal precio;
//    Descuento descuento;
//
//    public Articulo(String descripcion, BigDecimal precio, Descuento descuento) {
//        this.descripcion = descripcion;
//        this.precio = precio;
//        this.descuento = descuento;
//    }
//
//    public BigDecimal pvp(){
//        return precio.subtract(descuento.aplicarDescuento(precio));
//    }
//    public void setDescuento(Descuento descuento){
//        this.descuento=descuento;
//    }
//}
//interface Descuento {
//    BigDecimal aplicarDescuento(BigDecimal cantidad);
//}
//class DescuentoNavidad implements Descuento {
//    @Override
//    public BigDecimal aplicarDescuento(BigDecimal cantidad) {
//        return cantidad.multiply(BigDecimal.valueOf(0.5));
//    }
//}
//class DescuentoVerano implements Descuento{
//    @Override
//    public BigDecimal aplicarDescuento(BigDecimal cantidad) {
//        return cantidad.multiply(BigDecimal.valueOf(0.3));
//    }
//}
public class a2_3 {
    public static void main(String[] args) {
        Articulo a1= new Articulo("Jamón pachuly", new BigDecimal("100"), new DescuentoNavidad());
        System.out.println(a1.pvp());
        a1.setDescuento(new DescuentoVerano());
        System.out.println(a1.pvp());
    }
}