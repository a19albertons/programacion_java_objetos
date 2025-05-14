import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


interface AlertaObservable {
    void registrarUnidadEmergenciaNaranja(UnidadEmergencia unidad);
    void registrarUnidadEmergenciaRoja(UnidadEmergencia unidad);
    void eliminarUnidadEmergenciaNaranja(UnidadEmergencia unidad);
    void eliminarUnidadEmergenciaRoja(UnidadEmergencia unidad);
    void generarAlerta(String codigoAlerta);
}
class Fisgable implements AlertaObservable {
    List<UnidadEmergencia> unidadEmergenciasNaranja= new ArrayList<>();
    List<UnidadEmergencia> unidadEmergenciasRoja= new ArrayList<>();

    @Override
    public void registrarUnidadEmergenciaNaranja(UnidadEmergencia unidad) {
        unidadEmergenciasNaranja.add(unidad);
    }

    @Override
    public void registrarUnidadEmergenciaRoja(UnidadEmergencia unidad) {
        unidadEmergenciasRoja.add(unidad);
    }

    @Override
    public void eliminarUnidadEmergenciaNaranja(UnidadEmergencia unidad) {
        unidadEmergenciasNaranja.remove(unidad);
    }

    @Override
    public void eliminarUnidadEmergenciaRoja(UnidadEmergencia unidad) {
        unidadEmergenciasRoja.remove(unidad);
    }
    void notificarNaranja(){
        for(UnidadEmergencia unidad:unidadEmergenciasNaranja){
            unidad.actualizar();
        }
    }
    void notificarRoja(){
        for(UnidadEmergencia unidad:unidadEmergenciasRoja){
            unidad.actualizar();
        }
    }

    @Override
    public void generarAlerta(String codigoAlerta) {
        if (codigoAlerta.startsWith("Naranja")) {
            System.out.println("------------------");
            System.out.println("Se ha detectado una alerta "+codigoAlerta+".");
            notificarNaranja();
        } else {
            System.out.println("------------------");
            System.out.println("¡¡peligro!!  alerta "+codigoAlerta+".");
            notificarRoja();
        }
    }
}

interface UnidadEmergencia {
    String base = " en camino.";
    default void actualizar() {
        System.out.println(getClass().getSimpleName() + base);
    }
}
class Policia implements UnidadEmergencia {
    @Override
    public void actualizar(){
        System.out.println("Policía" + base);
    }
}
class Ambulancia implements UnidadEmergencia {

}
class Bomberos implements UnidadEmergencia {

}
class Geos implements UnidadEmergencia {

}
class Psicologos implements UnidadEmergencia {
    String mensaje;
    public Psicologos(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Psicologos that = (Psicologos) o;
        return Objects.equals(mensaje, that.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mensaje);
    }
}

public class a2_5_v2 {
    public static void main(String[] args) {
        Fisgable fisgable = new Fisgable();
        UnidadEmergencia policia = new Policia();
        UnidadEmergencia ambulancia = new Ambulancia();
        UnidadEmergencia bomberos = new Bomberos();
        UnidadEmergencia geos = new Geos();
        UnidadEmergencia psicologos = new Psicologos("TeEscuchamos");
        // Registrar unidades de emergencia en la alerta naranja
        fisgable.registrarUnidadEmergenciaNaranja(policia);
        fisgable.registrarUnidadEmergenciaNaranja(ambulancia);
        fisgable.registrarUnidadEmergenciaNaranja(bomberos);
        // Registrar unidades de emergencia en la alerta roja
        fisgable.registrarUnidadEmergenciaRoja(policia);
        fisgable.registrarUnidadEmergenciaRoja(ambulancia);
        fisgable.registrarUnidadEmergenciaRoja(bomberos);
        fisgable.registrarUnidadEmergenciaRoja(geos);
        fisgable.registrarUnidadEmergenciaRoja(psicologos);
        // Simular detección de alertas
        fisgable.generarAlerta("Naranja3k001");
        fisgable.generarAlerta("Roja05001");
    }
}


