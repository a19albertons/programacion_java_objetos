import static java.lang.Integer.parseInt;

class MyScanner{
    private String datos;
    private int pos;

    public MyScanner(String datos){
        this.datos=datos;
        this.pos=0;
    }

//    Metodos get y set autogenerados
    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

//    Metodos
    public boolean hasNextLine(){
        return datos.length()>pos;
    }
    public boolean hasNext(){
        boolean devolver=false;
        int suma=0;
        if (datos.length()==pos){
            return false;
        }
        if (
                this.datos.charAt(pos) == '\n' ||
                this.datos.charAt(pos) == '\t' ||
                this.datos.charAt(pos) == ' '
        ){
            suma++;
        }
        for (int i=pos+suma;;i++){
            if (
                    datos.length()==i ||
                            this.datos.charAt(i) == '\n' ||
                            this.datos.charAt(i) == '\t' ||
                            this.datos.charAt(i) == ' '
            ){
//                pos=i;
                devolver=true;
                break;
            }
        }
        return devolver;
    }
    public String nextLine(){
        StringBuilder devolver= new StringBuilder();
        for (int i=pos;;i++){
            if (datos.length()==i || this.datos.charAt(i) == '\n'){
                if (datos.length() != i){
                    pos=i+1;
                }
                else {
                    pos=i;
                }
                break;
            }
            devolver.append(datos.charAt(i));
        }
        return devolver.toString();
    }
    public String next(){
        StringBuilder devolver= new StringBuilder();
        if (
                this.datos.charAt(pos) == '\n' ||
                this.datos.charAt(pos) == '\t' ||
                this.datos.charAt(pos) == ' '
        ){
            pos++;
        }
        for (int i=pos;;i++){
            if (
                    datos.length()==i ||
                    this.datos.charAt(i) == '\n' ||
                    this.datos.charAt(i) == '\t' ||
                    this.datos.charAt(i) == ' '
            ){
                pos=i;
                break;
            }
            devolver.append(datos.charAt(i));
        }
        return devolver.toString();
    }
    public int nextInt(){
        StringBuilder devolver= new StringBuilder();
        if (
                this.datos.charAt(pos) == '\n' ||
                        this.datos.charAt(pos) == '\t' ||
                        this.datos.charAt(pos) == ' '
        ){
            pos++;
        }
        for (int i=pos;;i++){
            if (
                    datos.length()==i ||
                            this.datos.charAt(i) == '\n' ||
                            this.datos.charAt(i) == '\t' ||
                            this.datos.charAt(i) == ' '
            ){
                pos=i;
                break;
            }
            devolver.append(datos.charAt(i));
        }
        if (devolver.toString().equals("")){
            return 0;
        }{
            return parseInt(devolver.toString());

        }

    }
}
public class a1_4 {
    public static void main(String[] args){


        MyScanner ms=new MyScanner("hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.next());
        System.out.println(ms.next());
        System.out.println(ms.getPos());


        ms=new MyScanner("2 \t3 \n4\n");
        int suma=0;
        while(ms. hasNext()) suma+=ms.nextInt();
        System.out.println(suma);

        ms=new MyScanner("hola a todas");
        System.out.println(ms.getPos());
        System.out.println(ms.getDatos());


        ms=new MyScanner("hola a todas\n y hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.getDatos());


        ms=new MyScanner("");//String vacio
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());


        ms=new MyScanner("hola a todos\ny adios");
        ms.nextLine();
        System.out.println(ms.getPos());
        System.out.println(ms.getDatos());





        ms=new MyScanner("hola a todas\n y hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());



        ms=new MyScanner("hola a todas\n y hola a todos");
        System.out.println(ms.nextLine());
        System.out.println(ms.nextLine());
        System.out.println(ms.hasNextLine());




        ms=new MyScanner("hola a todas\n y hola a todos");
        System.out.println(ms.nextLine());
        System.out.println(ms.getPos());
        System.out.println(ms.getDatos());



        ms=new MyScanner("hola a todos");
        while(ms.hasNextLine()){
            System.out.println(ms.nextLine());
        }




        ms=new MyScanner("hola a todas \ny también hola a todos");
        while(ms.hasNextLine()){
            System.out.println(ms.nextLine());
        }



        ms=new MyScanner("hola a todas \ny también hola a todos\n");
        while(ms.hasNextLine()){
            System.out.println(ms.nextLine());
        }



        ms=new MyScanner("hola a todas \n\ny también hola a todos\n");
        while(ms.hasNextLine()){
            System.out.println(ms.nextLine());
        }



        ms=new MyScanner("hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.getDatos());



        ms=new MyScanner("hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.next());
        System.out.println(ms.next());
        System.out.println(ms.getPos());



        ms=new MyScanner("2 3 4");
        suma=0;
        while(ms. hasNext()) suma+=ms.nextInt();
        System.out.println(suma);





        ms=new MyScanner("2 \t3 \n4\n");
        suma=0;
        while(ms. hasNext()) suma+=ms.nextInt();
        System.out.println(suma);





        ms=new MyScanner("2 3 4\n\t");
        suma=0;
        while(ms. hasNext()) suma+=ms.nextInt();
        System.out.println(suma);





        ms=new MyScanner("2 \nmi mama me mima");
        System.out.println(ms.nextInt());
        ms.nextLine();//limpiar enter
        System.out.println(ms.nextLine());

    }
}
