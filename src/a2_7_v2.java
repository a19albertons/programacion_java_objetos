import java.util.Iterator;

class Contacto {
    private final String nombre;
    private final String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", teléfono=" + telefono;
    }
}

class Agenda implements Iterable<Contacto> {
    private final String propietario;
    private final Contacto[] contactos;
    private int numeroContactos; // To keep track of the number of contacts

    public Agenda(String propietario) {
        this.propietario = propietario;
        this.contactos = new Contacto[100]; // Max 100 contacts
        this.numeroContactos = 0;
    }

    public void add(String nombre, String telefono) {
        if (numeroContactos < contactos.length) {
            contactos[numeroContactos++] = new Contacto(nombre, telefono);
        }
        // Optionally, handle the case where the agenda is full
    }

    public String getPropietario() {
        return propietario;
    }

    @Override
    public Iterator<Contacto> iterator() {
        return new AgendaIterator();
    }

    private class AgendaIterator implements Iterator<Contacto> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < numeroContactos && contactos[currentIndex] != null;
        }

        @Override
        public Contacto next() {
            return contactos[currentIndex++];
        }
    }
}

public class a2_7_v2 {
    public static void main(String[] args) {
        Agenda agendaChuchi= new Agenda("Chuchi");
        agendaChuchi.add("eluno", "11111");
        agendaChuchi.add("dosi", "22222");
        agendaChuchi.add("tresi", "333333");
        System.out.println("Agenda de "+ agendaChuchi.getPropietario());
        for (Contacto c : agendaChuchi) {
            System.out.println(c);
        }
    }
}
/*
Agenda iterable

Queremos  recorrer los contactos de una clase  agenda con un for mejorado. Una agenda contiene un  nombre de propietario y una colección de Contactos. Se garantiza que la agenda no contendrá más de 100 contactos.  Un contacto se describe con un nombre y un teléfono, ambos de tipo String.

Se pide que  envies el código de las clases necesarias para que funcionen los test solicitados. Las primeras lineas de la solución enviada deben ser los import  necesarios.

Result
Agenda de Chuchi
nombre=eluno, teléfono=11111
nombre=dosi, teléfono=22222
nombre=tresi, teléfono=333333
 */
