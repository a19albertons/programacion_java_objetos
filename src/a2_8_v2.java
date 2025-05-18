public class a2_8_v2 {
    public static void main(String[] args) {
        MiControl miControlTV = new MiControl(new ControlTV());
        miControlTV.encender();
        miControlTV.subirVolumen();
        miControlTV.silenciar();
        miControlTV.subirVolumen();
        System.out.println();

        MiControl miControlRadio = new MiControl(new ControlRadio());
        miControlRadio.encender();
        miControlRadio.bajarVolumen();
        miControlRadio.silenciar();
        miControlRadio.subirVolumen();
        System.out.println();

//operaciones masivas
        Control[] controles={miControlTV,miControlRadio};
//comprobar el vol de todos los controles
        for(Control c:controles){System.out.println(c.getVolumen());}
//apagar todos los controles
        for(Control c:controles){c.apagar();}
    }
}

interface Control {
    void encender();
    void apagar();
    void subirVolumen();
    void bajarVolumen();
    int  getVolumen();
    void setVolumen(int nuevoVol);
}

class ControlTV implements Control {
    private int volumen = 50; // Default volume
    private boolean encendido = false;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Encendiendo el televisor...");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Apagando el televisor...");
    }

    @Override
    public void subirVolumen() {
        if (encendido) {
            volumen++;
            System.out.println("Subiendo el volumen del televisor a " + volumen);
        }
    }

    @Override
    public void bajarVolumen() {
        if (encendido) {
            volumen--;
            System.out.println("Bajando el volumen del televisor a " + volumen);
        }
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void setVolumen(int nuevoVol) {
        if (encendido) {
            this.volumen = nuevoVol;
        }
    }
}

class ControlRadio implements Control {
    private int volumen = 50; // Default volume
    private boolean encendido = false;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Encendiendo la radio...");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Apagando la radio...");
    }

    @Override
    public void subirVolumen() {
        if (encendido) {
            volumen++;
            System.out.println("Subiendo el volumen de la radio a " + volumen);
        }
    }

    @Override
    public void bajarVolumen() {
        if (encendido) {
            volumen--;
            System.out.println("Bajando el volumen de la radio a " + volumen);
        }
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void setVolumen(int nuevoVol) {
        if (encendido) {
            this.volumen = nuevoVol;
        }
    }
}

class MiControl implements Control {
    private final Control controlDelegado;

    public MiControl(Control controlDelegado) {
        this.controlDelegado = controlDelegado;
    }

    @Override
    public void encender() {
        controlDelegado.encender();
    }

    @Override
    public void apagar() {
        controlDelegado.apagar();
    }

    @Override
    public void subirVolumen() {
        controlDelegado.subirVolumen();
    }

    @Override
    public void bajarVolumen() {
        controlDelegado.bajarVolumen();
    }

    @Override
    public int getVolumen() {
        return controlDelegado.getVolumen();
    }

    @Override
    public void setVolumen(int nuevoVol) {
        controlDelegado.setVolumen(nuevoVol);
    }

    public void silenciar() {
        System.out.println("Silenciando el dispositivo...");
        controlDelegado.setVolumen(0);
    }
}

/*
Añadir la funcion silenciar con Delegate Pattern


Tengo una serie de clases que implementan el interface Control

interface Control {
    void encender();
    void apagar();
    void subirVolumen();//sube vol en 1
    void bajarVolumen();//baja vol en 1
    int  getVolumen();
    void setVolumen(int nuevoVol);
}


Esta interface puede ser implementada por muchos controles en un caso real aunque en los test  sólo manejamos las clases controlTV y controlRadio con la siguiente implementación

codigo

Surge la necesidad de que a veces a uno de estos controles se les quiere añadir una función como por ejemplo la función silenciar() que se pide en este ejercicio. Modificar todos los controles para añadir esta función es una solución que se descarta, por ejemplo porque las subclases son final u otras razones de mantenimiento. Se adopta entonces la solución de Delegate Pattern que entre otras cosas nos permite añadir dinámicamente una nueva función a una subclase existente sin tener que modificarla ni heredarla como se aprecia en los test de forma que una nueva clase MiControl puede reutilizar el código de las subclases controlTV y controlRadio. Observa en los test que silenciar implica poner el volumen a 0.

Result
Encendiendo el televisor...
Subiendo el volumen del televisor a 51
Silenciando el dispositivo...
Subiendo el volumen del televisor a 1

Encendiendo la radio...
Bajando el volumen de la radio a 49
Silenciando el dispositivo...
Subiendo el volumen de la radio a 1

1
1
Apagando el televisor...
Apagando la radio...
 */