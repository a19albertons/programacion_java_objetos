import java.security.cert.CertPath;

class MiniSB{
//    atribtuos
    private char[] buffer;
    private int ContentSize;

//    constructos
    public MiniSB(String texto){
        this.buffer=new char[texto.length()*2];
        this.ContentSize =0;
        for (; ContentSize <texto.length(); ContentSize++){
            buffer[ContentSize]=texto.charAt(ContentSize);
        }
    }
    public MiniSB(){
        this.buffer=new char[0];
        this.ContentSize=0;
    }

//    get y set

    public char[] getBuffer() {
        return buffer;
    }

    public void setBuffer(char[] buffer) {
        this.buffer = buffer;
    }

    public int getContentSize() {
        return ContentSize;
    }

    public void setContentSize(int contentSize) {
        this.ContentSize = contentSize;
    }

//    metodo
    public void append(String texto){
        if (buffer.length>= ContentSize +texto.length()){
            for (int i=0;i<texto.length();i++){
                buffer[ContentSize]=texto.charAt(i);
                ContentSize++;
            }
        }
        else {
            char[] temporal=this.buffer;
            int antiguo_content=ContentSize;
            this.ContentSize=0;
            this.buffer=new char[(antiguo_content+texto.length())*2];

            for (int i=0;i<antiguo_content;i++){
                buffer[i]=temporal[i];
                ContentSize++;
            }
            for (int i=0;i<texto.length();i++){
                buffer[ContentSize]=texto.charAt(i);
                ContentSize++;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder devolver= new StringBuilder();
        for (int i=0;i<ContentSize;i++){
            devolver.append(this.buffer[i]);
        }
        return devolver.toString();
    }

    public void deleteFromIndex(int indice) {
        ContentSize=indice;

    }

    public void reverse() {
        char[] temporal= this.buffer;
        this.buffer=new char[temporal.length];
        int inversa= ContentSize-1;
        for (int i=0; i<ContentSize;i++){
            this.buffer[i]=temporal[inversa];
            inversa--;
        }
    }
}



public class a1_5 {
    public static void main(String[] args){
        MiniSB miniSB = new MiniSB("123");
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);
        miniSB.append("456");
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);
        miniSB.append("7");
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);

        miniSB = new MiniSB();
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);
        miniSB.append("12");
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);

        miniSB = new MiniSB("Eran dos tipos requete finos");
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        miniSB.deleteFromIndex(4);
        System.out.println(miniSB.getBuffer().length + ", " + miniSB.getContentSize());
        System.out.println(miniSB);
        miniSB.reverse();
        System.out.println(miniSB);
    }
}
