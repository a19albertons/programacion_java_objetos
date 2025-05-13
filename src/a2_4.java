//class SortContext {
//    int[] data;
//    SortingStrategy estrategia;
//    void setData(int[] data){
//        this.data = data;
//    }
//
//    public void setStrategy(SortingStrategy estrategia) {
//        this.estrategia = estrategia;
//    }
//
//    public void sort() {
//        estrategia.sort(data);
//    }
//}
//interface SortingStrategy {
//    void sort(int[] a);
//}
//class InsertionSort implements SortingStrategy{
//    @Override
//    public void sort(int[] a){
//        for (int i = 1; i < a.length; i++) {
//            int current = a[i];
//            int j = i - 1;
//            while (j >= 0 && current < a[j]) {
//                a[j + 1] = a[j];
//                j--;
//            }
//            a[j + 1] = current;
//        }
//    }
//}
//class BubbleSort implements SortingStrategy{
//
//    @Override
//    public void sort(int[] a) {
//        int i, j, aux;
//        for (i = 0; i < a.length - 1; i++) {
//            for (j = 0; j < a.length - i - 1; j++) {
//                if (a[j + 1] < a[j]) {
//                    aux = a[j + 1];
//                    a[j + 1] = a[j];
//                    a[j] = aux;
//                }
//            }
//        }
//    }
//}
//class SelectionSort implements SortingStrategy{
//
//    @Override
//    public void sort(int[] a) {
//        int i, j, menor, pos, tmp;
//        for (i = 0; i < a.length - 1; i++) {
//            menor = a[i];
//            pos = i;
//            for (j = i + 1; j < a.length; j++) {
//                if (a[j] < menor) {
//                    menor = a[j];
//                    pos = j;
//                }
//            }
//
//            if (pos != i) {
//                tmp = a[i];
//                a[i] = a[pos];
//                a[pos] = tmp;
//            }
//        }
//    }
//}

public class a2_4 {
    public static void main(String[] args) {
        SortingStrategy[] misEstrategias = {
                new InsertionSort(), new BubbleSort(), new SelectionSort() };
        int[][] data={
                { 9, 6, 7, 1, 4, 3, 2, 5, 8 },
                { 9, 1, 6, 7, 8, 4, 3, 2, 5 },
                { 9 ,8 ,7 ,6 ,5 ,4 ,3 ,2 ,1 } };
        SortContext sortContext = new SortContext();
        for(int i=0; i<misEstrategias.length; i++) {
            sortContext.setData(data[i]);
            sortContext.setStrategy(misEstrategias[i]);
            sortContext.sort();
            System.out.println(java.util.Arrays.toString(data[i]));
        }
    }
}