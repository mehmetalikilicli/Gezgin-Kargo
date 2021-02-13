package prolab_gezgin;

public class Permutation {

    static int[][] matris = null;
    static int sayac = 0;

    public Permutation() {

    }

    public Permutation(int a, int b) {
        int[][] matris2 = new int[a][b];
        matris = matris2;
    }

    public static int[][] permute(int[] array, int l, int r) {

        if (l == r) {

            for (int k = 0; k < array.length; k++) {
                //System.out.print(str[k] + "   ");
                matris[sayac][k] = array[k];
            }
            sayac++;
            //System.out.println();
        } else {
            for (int i = l; i <= r; i++) {
                array = degistir(array, l, i);
                permute(array, l + 1, r);
                array = degistir(array, l, i);
            }
        }

        //System.out.println();
        //return son;
        return matris;
    }

    public static int[] degistir(int[] a, int i, int j) {
        int temp;
        int[] dizi = a;
        temp = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = temp;
        return dizi;
    }
}
