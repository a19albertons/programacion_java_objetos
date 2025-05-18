public class a2_11_v2 {
    public static void main(String[] args) {
        result1();
        result2();
    }
    public static void result1() {
        Expresion expresion = new Operacion(
                new Operacion(
                        new Operando(3),
                        new Operando(4),
                        '*'),
                new Operacion(
                        new Operando(2),
                        new Operando(5),
                        '+'),
                '-');
        double resultado;
        try {
            resultado = expresion.evaluar();
            System.out.println(resultado);
        } catch (ExpresionException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void result2(){
        Expresion expresion = new Operacion(
                new Operacion(
                        new Operando(3),
                        new Operando(4),
                        '%'),
                new Operacion(
                        new Operando(2),
                        new Operando(5),
                        '+'),
                '-');
        double resultado;
        try {
            resultado = expresion.evaluar();
            System.out.println(resultado);
        } catch (ExpresionException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ExpresionException extends Exception {
    public ExpresionException(String message) {
        super(message);
    }
}

abstract class Expresion {
    public abstract double evaluar() throws ExpresionException;
}

class Operando extends Expresion {
    private double valor;

    public Operando(double valor) {
        this.valor = valor;
    }

    @Override
    public double evaluar() {
        return valor;
    }
}

class Operacion extends Expresion {
    private Expresion izquierda;
    private Expresion derecha;
    private char operador;

    public Operacion(Expresion izquierda, Expresion derecha, char operador) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.operador = operador;
    }

    @Override
    public double evaluar() throws ExpresionException {
        double valIzquierda = izquierda.evaluar();
        double valDerecha = derecha.evaluar();

        switch (operador) {
            case '+':
                return valIzquierda + valDerecha;
            case '-':
                return valIzquierda - valDerecha;
            case '*':
                return valIzquierda * valDerecha;
            case '/':
                if (valDerecha == 0) {
                    throw new ExpresionException("División por cero");
                }
                return valIzquierda / valDerecha;
            default:
                throw new ExpresionException("Operador desconocido: " + operador);
        }
    }
}

/*
Evaluar expresiones con Composite

Queremos almacenar una expresión aritmética en un arbol binario y tener un método evaluar() que nos devuelva su valor.

Utilizaremos para escribir el árbol el patrón Composite. La clase Abstracta será Expresion y tiene un método abstracto evaluar(). Una Expresion puede ser una operacion o un operando. Los operandos son los nodos hoja de composite y  una operacion es el nodo recursivo.

La clase operación tendrá el siguiente aspecto



class Operacion extends Expresion {
    private Expresion left;
    private Expresion right;
    private char operator;
etc.

los operadores validos son  +,-,*, /

Result1:
5.0

Result2:
Operador desconocido: %
 */

