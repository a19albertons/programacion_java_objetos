public class a2_10_v2 {
    public static void main(String[] args) {
        result1();
        result2();
    }
    public static void result1() {
        Directorio raiz = new Directorio("Raíz");
        Archivo archivo1 = new Archivo("Archivo1.txt");
        Archivo archivo2 = new Archivo("Archivo2.txt");

        Directorio carpeta1 = new Directorio("Carpeta1");
        Archivo archivo3 = new Archivo("Archivo3.txt");
        Archivo archivo4 = new Archivo("Archivo4.txt");

        EnlaceSimbolico enlace = new EnlaceSimbolico("miLink", carpeta1);

        raiz.add(archivo1);
        raiz.add(archivo2);
        raiz.add(carpeta1);
        raiz.add(enlace);

        carpeta1.add(archivo3);
        carpeta1.add(archivo4);
        enlace.ls();
        System.out.println("-------------------");
        carpeta1.ls();
        System.out.println("-------------------");
        raiz.ls();
    }

    public static void result2() {
        Directorio raiz = new Directorio("/");
        Directorio dir1 = new Directorio("Dir1");
        raiz.add(dir1);
        Directorio dir11 = new Directorio("Dir11");
        dir1.add(dir11);
        Directorio dir111 = new Directorio("Dir111");
        dir11.add(dir111);
        Directorio dir1111 = new Directorio("Dir1111");
        dir111.add(dir1111);


        EnlaceSimbolico enlace = new EnlaceSimbolico("atajo", raiz);
        dir1111.add(enlace);
        raiz.ls();
    }
}

abstract class ElementoDelSistemaDeArchivos {
    String nombre;

    public ElementoDelSistemaDeArchivos(String nombre) {
        this.nombre = nombre;
    }

    void ls() {
        ls("");
    }

    abstract void ls(String tab);
}

class Archivo extends ElementoDelSistemaDeArchivos {
    public Archivo(String nombre) {
        super(nombre);
    }

    @Override
    void ls(String tab) {
        System.out.println(tab + "Archivo: " + nombre);
    }
}

class EnlaceSimbolico extends ElementoDelSistemaDeArchivos {
    private final ElementoDelSistemaDeArchivos enlazado;

    public EnlaceSimbolico(String nombre, ElementoDelSistemaDeArchivos enlazado) {
        super(nombre);
        this.enlazado = enlazado;
    }

    @Override
    void ls(String tab) {
        System.out.println(tab + "Enlace simbólico: " + nombre + " -> " + enlazado.nombre);
    }
}

class Directorio extends ElementoDelSistemaDeArchivos {
    private final java.util.List<ElementoDelSistemaDeArchivos> elementos = new java.util.ArrayList<>();

    public Directorio(String nombre) {
        super(nombre);
    }

    public void add(ElementoDelSistemaDeArchivos elemento) {
        elementos.add(elemento);
    }

    @Override
    void ls(String tab) {
        System.out.println(tab + "Directorio: " + nombre);
        for (ElementoDelSistemaDeArchivos elemento : elementos) {
            elemento.ls(tab + "   ");
        }
    }
}

/*
Composite para  sistema de ficheros

Queremos simular un sistema de ficheros en memoria con un arbol composite.  Eh el diagrama de abajo indicamos la estructura de clases a manejar aplicando Composite  y observamos que tenemos dos tipos de nodos hojas:

    Archivo, para representar un archivo(fichero)
    EnlaceSimbolico para representar  un enlace simbólico(un acceso directo).

Puedes partir del siguiente elemento abstracto

abstract class ElementoDelSistemaDeArchivos{
    String nombre;
    void ls(){
        ls("");
    }
    abstract void ls(String tab);
}
En la salida se puede apreciar que un tabulador son tres espacios en blanco.

En el test ejemplo, observamos un main() que maneja la clases pedidas, pero evidentemente la solución debe funcionar para cualquier otro test que cumpla la estructura pedida

Result 1
Enlace simbólico: miLink -> Carpeta1
-------------------
Directorio: Carpeta1
   Archivo: Archivo3.txt
   Archivo: Archivo4.txt
-------------------
Directorio: Raíz
   Archivo: Archivo1.txt
   Archivo: Archivo2.txt
   Directorio: Carpeta1
      Archivo: Archivo3.txt
      Archivo: Archivo4.txt
   Enlace simbólico: miLink -> Carpeta1

Result 2
Directorio: /
   Directorio: Dir1
      Directorio: Dir11
         Directorio: Dir111
            Directorio: Dir1111
               Enlace simbólico: atajo -> /
 */
