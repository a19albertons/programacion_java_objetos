import java.util.Iterator;

class MiString implements Iterable<Character> {
    private final String str;

    public MiString(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new MiStringIterator();
    }

    private class MiStringIterator implements Iterator<Character> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < str.length();
        }

        @Override
        public Character next() {
            return str.charAt(currentIndex++);
        }
    }
}

public class a2_6_v2 {
    public static void main(String[] args) {
        MiString miString = new MiString("Hola mundo");
        for (char c : miString) {
            System.out.print(c);
        }
    }

}
/*
El for mejorado con  MiString

Tengo debilidad por el for mejorado. Lo uso sin parar. Pero .... ¡la clase String no es iterable en Java! y por tanto,  no se puede recorrer con el for mejorado.

SE PIDE:

Crea una clase MiString que encapsula un String y es recorrible con un for mejorado. Lo único que se pide es que sea recorrible con un for mejorado, no tiene que tener toda la funcionalidad de un objeto String.

SE ENTREGA:

código de la clase MiString precedida de los import necesarios.

Resultado
Hola mundo
 */
