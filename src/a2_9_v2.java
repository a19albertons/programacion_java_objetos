//// Componente abstracto para el presupuesto
//interface ParteDeLaCasa {
//    String getNombre();
//    double getPrecio();
//    void imprimirPreOrden(String prefijo);
//}
//
//// Hoja: Parte simple de la casa
//class ParteSimple implements ParteDeLaCasa {
//    private String nombre;
//    private double precio;
//
//    public ParteSimple(String nombre, double precio) {
//        this.nombre = nombre;
//        this.precio = precio;
//    }
//
//    @Override
//    public String getNombre() {
//        return nombre;
//    }
//
//    @Override
//    public double getPrecio() {
//        return precio;
//    }
//
//    @Override
//    public void imprimirPreOrden(String prefijo) {
//        System.out.println(prefijo + nombre + " " + precio);
//    }
//}
//
//// Compuesto: Parte compuesta de la casa
//class ParteCompuesta implements ParteDeLaCasa {
//    private String nombre;
//    private java.util.List<ParteDeLaCasa> subPartes = new java.util.ArrayList<>();
//
//    public ParteCompuesta(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public void addParte(ParteDeLaCasa parte) {
//        subPartes.add(parte);
//    }
//
//    @Override
//    public String getNombre() {
//        return nombre;
//    }
//
//    @Override
//    public double getPrecio() {
//        double precioTotal = 0;
//        for (ParteDeLaCasa parte : subPartes) {
//            precioTotal += parte.getPrecio();
//        }
//        return precioTotal;
//    }
//
//    @Override
//    public void imprimirPreOrden(String prefijo) {
//        System.out.println(prefijo + nombre + " " + getPrecio());
//        for (ParteDeLaCasa parte : subPartes) {
//            parte.imprimirPreOrden(prefijo + "   ");
//        }
//    }
//}
//
//public class a2_9_v2 {
//    public static void main(String[] args) {
//        // finca
//        ParteSimple cierre = new ParteSimple("Cierre finca", 4000);
//        ParteSimple jardin = new ParteSimple("jardín", 1000);
//        ParteCompuesta finca = new ParteCompuesta("finca");
//        finca.addParte(cierre);
//        finca.addParte(jardin);
//
//        // estructura
//        ParteSimple tejado = new ParteSimple("tejado", 10000);
//        ParteSimple alturas = new ParteSimple("alturas", 10000);
//        ParteSimple sotano = new ParteSimple("sótano", 10000);
//        ParteCompuesta estructura = new ParteCompuesta("estructura");
//        estructura.addParte(tejado);
//        estructura.addParte(alturas);
//        estructura.addParte(sotano);
//
//        // interior
//        // interior-habitaciones
//        ParteSimple mobiliario = new ParteSimple("mobiliario", 20000);
//        ParteSimple pintura = new ParteSimple("pintura", 10000);
//        ParteCompuesta habitaciones = new ParteCompuesta("habitaciones");
//        habitaciones.addParte(mobiliario);
//        habitaciones.addParte(pintura);
//
//        // interior-electricidad
//        ParteSimple cables = new ParteSimple("cables", 500);
//        ParteSimple operadores = new ParteSimple("operadores", 500);
//        ParteCompuesta electricidad = new ParteCompuesta("electricidad");
//        electricidad.addParte(cables);
//        electricidad.addParte(operadores);
//
//        // interior-fontanería
//        ParteSimple caldera = new ParteSimple("caldera", 4000);
//        ParteSimple radiadores = new ParteSimple("radiadores", 2000);
//        ParteCompuesta calefaccion = new ParteCompuesta("calefacción");
//        calefaccion.addParte(caldera);
//        calefaccion.addParte(radiadores);
//        ParteSimple tuberias = new ParteSimple("tuberías", 3000);
//        ParteCompuesta fontaneria = new ParteCompuesta("fontanería");
//        fontaneria.addParte(tuberias);
//        fontaneria.addParte(calefaccion);
//
//        // todo interior
//        ParteCompuesta interior = new ParteCompuesta("interior");
//        interior.addParte(habitaciones);
//        interior.addParte(electricidad);
//        interior.addParte(fontaneria);
//
//        // la casa completa
//        ParteCompuesta casa = new ParteCompuesta("Casa");
//        casa.addParte(finca);
//        casa.addParte(estructura);
//        casa.addParte(interior);
//
//        // probar cálculo de costes
//        System.out.println("Precio casa " + casa.getPrecio());
//        System.out.println("Precio finca " + finca.getPrecio());
//        System.out.println("Imprimir todo en preorden");
//        casa.imprimirPreOrden("");
//    }
//}
//
//// --- Solution for the File System exercise ---
//
//abstract class ElementoDelSistemaDeArchivos {
//    String nombre;
//
//    public ElementoDelSistemaDeArchivos(String nombre) {
//        this.nombre = nombre;
//    }
//
//    void ls() {
//        ls("");
//    }
//
//    abstract void ls(String tab);
//}
//
//class Archivo extends ElementoDelSistemaDeArchivos {
//    public Archivo(String nombre) {
//        super(nombre);
//    }
//
//    @Override
//    void ls(String tab) {
//        System.out.println(tab + "Archivo: " + nombre);
//    }
//}
//
//class EnlaceSimbolico extends ElementoDelSistemaDeArchivos {
//    private ElementoDelSistemaDeArchivos enlazado;
//
//    public EnlaceSimbolico(String nombre, ElementoDelSistemaDeArchivos enlazado) {
//        super(nombre);
//        this.enlazado = enlazado;
//    }
//
//    @Override
//    void ls(String tab) {
//        System.out.println(tab + "Enlace simbólico: " + nombre + " -> " + enlazado.nombre);
//    }
//}
//
//class Directorio extends ElementoDelSistemaDeArchivos {
//    private java.util.List<ElementoDelSistemaDeArchivos> elementos = new java.util.ArrayList<>();
//
//    public Directorio(String nombre) {
//        super(nombre);
//    }
//
//    public void add(ElementoDelSistemaDeArchivos elemento) {
//        elementos.add(elemento);
//    }
//
//    @Override
//    void ls(String tab) {
//        System.out.println(tab + "Directorio: " + nombre);
//        for (ElementoDelSistemaDeArchivos elemento : elementos) {
//            elemento.ls(tab + "   ");
//        }
//    }
//}
//
///*
//Presupuesto con Composite
//
//Supongamos que queremos hacer un presupuesto. El presupuesto no es más que el despiece de una casa con sus precios. Es un ejemplo imaginario no un presupuesto real.
//
//Casa:
//
//    finca
//
//        cierre
//
//        jardín
//
//    estructura
//
//        tejado
//
//        alturas
//
//        sótano
//
//    interior.
//
//        habitaciones
//
//            mobiliario
//
//            pintura
//
//        electricidad
//
//            cables
//
//            operadores
//
//        fontanería
//
//             tuberías
//
//             calefacción
//
//                caldera
//
//                radiadores
//
//Fíjate bien en lo natural que resulta escribir un método getPrecio() recursivo:
//
//    El precio de la casa es la suma de los precios de la finca de la estructura y del interior.
//
//    A su vez el precio de la finca es el precio del cierre y el jardín
//
//    etc.
//
//¡Por lo tanto recursivamente!:
//
//    El precio de una parte compuesta de la casa es la suma de los precios de las subpartes de dicha parte. CASO RECURSIVO
//
//quedaría
//
//    Si una parte compuesta no tiene subpartes, es decir, por el momento está vacía no sumamos nada.. CASO BASE.
//
//    Si una parte es simple (sin subpartes)   devolvemos su precio. CASO BASE.
//
//
//
//Observa la estructura en el árbol del despiece. Queremos tener la capacidad de calcular el precio de las diferentes partes. Las hojas tienen un precio, Y los precios de los objetos compuestos los vamos a calcular  recursivamente.  Observa que:
//
//    El caso base Si una parte compuesta no tiene subpartes, simplemente ocurre cuando el for hace 0 iteraciones
//
//    El caso base Si una parte es simple,  se consigue sin usar el típico if  ya que entra en acción el polimorfismo que provoca la invocación del getPrecio() de la parte simple.
//
//
//
//
//
//Result
//Precio casa 75000.0
//Precio finca 5000.0
//Imprimir todo en preorden
//Casa 75000.0
//   finca 5000.0
//      Cierre finca 4000.0
//      jardín 1000.0
//   estructura 30000.0
//      tejado 10000.0
//      alturas 10000.0
//      sótano 10000.0
//   interior 40000.0
//      habitaciones 30000.0
//         mobiliario 20000.0
//         pintura 10000.0
//      electricidad 1000.0
//         cables 500.0
//         operadores 500.0
//      fontanería 9000.0
//         tuberías 3000.0
//         calefacción 6000.0
//            caldera 4000.0
//            radiadores 2000.0
//
//Answer:(penalty regime: 0 %)
//Question 10
//Not complete
//Marked out of 1.00
//Flag question
//Question text
//Composite para  sistema de ficheros
//
//Queremos simular un sistema de ficheros en memoria con un arbol composite.  Eh el diagrama de abajo indicamos la estructura de clases a manejar aplicando Composite  y observamos que tenemos dos tipos de nodos hojas:
//
//    Archivo, para representar un archivo(fichero)
//    EnlaceSimbolico para representar  un enlace simbólico(un acceso directo).
//
//Puedes partir del siguiente elemento abstracto
//
//abstract class ElementoDelSistemaDeArchivos{
//    String nombre;
//    void ls(){
//        ls("");
//    }
//    abstract void ls(String tab);
//}
//En la salida se puede apreciar que un tabulador son tres espacios en blanco.
//
//En el test ejemplo, observamos un main() que maneja la clases pedidas, pero evidentemente la solución debe funcionar para cualquier otro test que cumpla la estructura pedida
//
//Se pide: Enviar  el código necesario  (clases e import asociados) siguiendo obligatoriamente dicho código el patrón Composite.
//
//For example:
//Test 	Result
//
//Directorio raiz = new Directorio("Raíz");
//Archivo archivo1 = new Archivo("Archivo1.txt");
//Archivo archivo2 = new Archivo("Archivo2.txt");
//
//Directorio carpeta1 = new Directorio("Carpeta1");
//Archivo archivo3 = new Archivo("Archivo3.txt");
//Archivo archivo4 = new Archivo("Archivo4.txt");
//
//EnlaceSimbolico enlace = new EnlaceSimbolico("miLink", carpeta1);
//
//raiz.add(archivo1);
//raiz.add(archivo2);
//raiz.add(carpeta1);
//raiz.add(enlace);
//
//carpeta1.add(archivo3);
//carpeta1.add(archivo4);
//enlace.ls();
//System.out.println("-------------------");
//carpeta1.ls();
//System.out.println("-------------------");
//raiz.ls();
//
//
//
//Enlace simbólico: miLink -> Carpeta1
//-------------------
//Directorio: Carpeta1
//   Archivo: Archivo3.txt
//   Archivo: Archivo4.txt
//-------------------
//Directorio: Raíz
//   Archivo: Archivo1.txt
//   Archivo: Archivo2.txt
//   Directorio: Carpeta1
//      Archivo: Archivo3.txt
//      Archivo: Archivo4.txt
//   Enlace simbólico: miLink -> Carpeta1
//
//Directorio raiz = new Directorio("/");
//Directorio dir1 = new Directorio("Dir1");
//raiz.add(dir1);
//Directorio dir11 = new Directorio("Dir11");
//dir1.add(dir11);
//Directorio dir111 = new Directorio("Dir111");
//dir11.add(dir111);
//Directorio dir1111 = new Directorio("Dir1111");
//dir111.add(dir1111);
//
//
//EnlaceSimbolico enlace = new EnlaceSimbolico("atajo", raiz);
//dir1111.add(enlace);
//raiz.ls();
//
//
//
//Directorio: /
//   Directorio: Dir1
//      Directorio: Dir11
//         Directorio: Dir111
//            Directorio: Dir1111
//               Enlace simbólico: atajo -> /
//
// */
