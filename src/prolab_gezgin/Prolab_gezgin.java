package prolab_gezgin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.parser.TokenType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Prolab_gezgin {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws FileNotFoundException, IOException {

        int i = 0, j = 0;
        List Sehir = new ArrayList();

        int[][] komsuluk = new int[82][82];

        for (i = 0; i < 82; i++) {
            for (j = 0; j < 82; j++) {
                komsuluk[i][j] = 0;
            }
        }
        i = 0;
        j = 0;
        String str = "";
        String str1 = "";

        int ss = satirsayisi();
        String[] sehirsatiri = new String[ss];
        String[] mesafeler = new String[ss];
        //System.out.println(ss);

        File file = new File("mesafeler.txt");

        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int z = 0;
        while ((line = br.readLine()) != null) {
            mesafeler[z] = line;
            //System.out.println(line);
            z++;
        }

        br.close();

        try {
            FileInputStream fstream = new FileInputStream("sehir.txt");
            DataInputStream dstream = new DataInputStream(fstream);
            BufferedReader breader = new BufferedReader(new InputStreamReader(dstream));

            while ((str = breader.readLine()) != null) {
                sehirsatiri[i] = str;
                i++;
            }
            dstream.close();

        } catch (Exception e) {
            System.out.println("hata11111!" + e.getMessage());
        }
        for (i = 0; i < ss; i++) {
            //System.out.println(mesafeler[i]);
        }
        Sehir.add("Sehirler");
        for (i = 0; i < 81; i++) {
            String[] kelime = null;
            kelime = sehirsatiri[i].split(",");
            //System.out.println(kelime.length);
            Sehir.add(kelime[1]);
        }
        for (i = 0; i < 81; i++) {
            String[] kelime = null;
            kelime = sehirsatiri[i].split(",");
            String[] km = null;
            km = mesafeler[i].split(",");
            for (j = 2; j < kelime.length; j++) {
                for (int k = 1; k < 82; k++) {
                    if (kelime[j].equals(Sehir.get(k))) {
                        komsuluk[i + 1][k] = Integer.parseInt(km[j - 1]);
                        //System.out.println(kelime[j] + "    " + k + "    " + km[j - 1]);
                    }
                }
            }
            //System.out.println("---------");
        }

        //System.out.println(Sehir.get(i + 1));
       /* for (i = 1; i < 82; i++) {
         for (j = 1; j < 82; j++) {
         if (komsuluk[i][j] != 0) {
         System.out.print(komsuluk[i][j] + "   ");
         }
         }
         System.out.println();
        
         }*/
        /*
        
        
      
         Scanner scan = new Scanner(System.in);
         String close = "a";
         int[] teslimat_plaka = new int[10];
         String[] teslimat_isim = new String[10];
         int teslimat_sayisi = 0;

         while (close != "q") {
         System.out.println("Şehir ismi giriniz (çıkmak için lütfen 'q' ya basınız) ");
         close = scan.next();
         teslimat_isim[teslimat_sayisi] = close;
         ++teslimat_sayisi;
         //System.out.println(sehir_ismi);
         for (i = 1; i < 82; i++) {
         if (close.equals(Sehir.get(i))) {
         teslimat_plaka[teslimat_sayisi - 1] = i;
         break;
         }
         }
         System.out.println("Girdiğiniz şehrin plaka kodu --> " + (i));
         }
        
        
         */
        System.out.println("Kaç sehire teslimat var?");
        Scanner scan = new Scanner(System.in);
        int teslimat_sayisi = scan.nextInt();
        int[] teslimat_plaka = new int[teslimat_sayisi];
        String sehir_ismi;
        String[] teslimat_isim = new String[teslimat_sayisi];

        for (j = 0; j < teslimat_sayisi; j++) {
            System.out.println("Şehir ismi giriniz: ");
            //System.out.println(sehir_ismi);
            sehir_ismi = scan.next();
            teslimat_isim[j] = sehir_ismi;
            for (i = 1; i < 82; i++) {
                if (sehir_ismi.equals(Sehir.get(i))) {
                    System.out.println("Girdiğiniz şehrin plaka kodu --> " + i + "\n-------------------");
                    teslimat_plaka[j] = i;
                    break;
                }
            }
        }
        System.out.print("Gidilecek şehirlerin plaka kodlari ve isimleri:\n");
        for (j = 0; j < teslimat_sayisi; j++) {
            System.out.print(teslimat_plaka[j] + "    ");
            System.out.println(Sehir.get(teslimat_plaka[j]));
        }

        int n = teslimat_plaka.length;
        int sayi, faktoriyel = 1;
        sayi = n;
        for (i = 2; i <= sayi; i++) {
            faktoriyel = i * faktoriyel;
        }
        int[] gidilecek_yerler = new int[n];
        Permutation permutation = new Permutation(faktoriyel, n);
        int[][] u = new int[faktoriyel][n];
        u = Permutation.permute(teslimat_plaka, 0, n - 1);

        /*for (i = 0; i < faktoriyel; i++) {
         for (j = 0; j < n; j++) {
         System.out.print(u[i][j] + "  ");
         }
         System.out.println("");
         }*/
        for (i = 0; i < n; i++) {
            //System.out.print(gidilecek_yerler[i] + "      ");
        }
        int[] permu_dizi = new int[faktoriyel];
        int[] permu_dizi2 = new int[faktoriyel];
        int[] permu_dizi3 = new int[faktoriyel];
        ShortestPath t = new ShortestPath();
        for (i = 0; i < faktoriyel; i++) {
            for (j = 0; j < n - 1; j++) {
                permu_dizi[i] = t.dijkstra(komsuluk, u[i][j], u[i][j + 1]);
            }
            ShortestPath.toplam = 0;
        }

        /*for (i = 0; i < faktoriyel; i++) {
         for (j = 0; j < n; j++) {
         System.out.print(u[i][j] + " ---> ");
         }
         System.out.println(permu_dizi[i]);
         }*/
        for (i = 0; i < faktoriyel; i++) {
            permu_dizi2[i] = t.dijkstra(komsuluk, 41, u[i][0]);
            permu_dizi[i] += permu_dizi2[i];
            ShortestPath.toplam = 0;

            permu_dizi3[i] = t.dijkstra(komsuluk, 41, u[i][n - 1]);
            permu_dizi[i] += permu_dizi3[i];
            ShortestPath.toplam = 0;
        }

        /*
        
         for (i = 0; i < faktoriyel; i++) {
         System.out.print("41 ---> ");
         for (j = 0; j < n; j++) {
         //System.out.print(u[i][j] + " ---> ");
         }
         System.out.print("41 ---> ");
         System.out.println(permu_dizi[i] + "km");
         }
        
         */
        int konum = 0;
        int temp = 0;
        int[] enkisa5 = new int[faktoriyel];

        int[] enkisaindex = new int[permu_dizi.length];
        System.out.println();

        for (i = 0; i < faktoriyel; i++) {
            // System.out.println(permu_dizi[i]);
            enkisaindex[i] = i;
        }
        System.out.println();

        for (i = 0; i < faktoriyel; i++) {
            for (j = i + 1; j < faktoriyel; j++) {
                if (permu_dizi[j] < permu_dizi[i]) {
                    temp = permu_dizi[i];
                    permu_dizi[i] = permu_dizi[j];
                    permu_dizi[j] = temp;

                    temp = enkisaindex[i];
                    enkisaindex[i] = enkisaindex[j];
                    enkisaindex[j] = temp;

                }
                enkisa5[i] = permu_dizi[i];
            }
        }

        /*
         for (i = 0; i < faktoriyel; i++) {
         System.out.println(enkisa5[i]);
         System.out.println(enkisaindex[i]);
         System.out.println();
         }
        
         */
        if (enkisaindex.length > 5) {
            System.out.println("En kisa 5 rota bulundu : ");
            for (i = 0; i < 5; i++) {
                System.out.print(Sehir.get(41) + " ---> ");
                for (j = 0; j < n; j++) {
                    System.out.print(Sehir.get(u[enkisaindex[i]][j]) + " ---> ");
                    //System.out.print(u[enkisaindex[i]][j] + " ---> ");
                }
                System.out.print(Sehir.get(41) + " ---> " + permu_dizi[i] + "km\n");
            }
            System.out.println();

        } else {
            System.out.println("En kisa rotalar ve kilometreleri : ");
            for (i = 0; i < enkisaindex.length; i++) {
                System.out.print(Sehir.get(41) + " ---> ");
                for (j = 0; j < n; j++) {
                    System.out.print(Sehir.get(u[enkisaindex[i]][j]) + " ---> ");
                    System.out.print(u[enkisaindex[i]][j] + " ---> ");
                }
                System.out.print(Sehir.get(41) + " ---> " + permu_dizi[i] + "km\n");
            }
        }

        int[][] map = new int[5][n];

        if (enkisaindex.length > 5) {

            for (i = 0; i < 5; i++) {
                for (j = 0; j < n; j++) {
                    map[i][j] = u[enkisaindex[i]][j];
                }
            }
        } else {

            for (i = 0; i < enkisaindex.length; i++) {
                for (j = 0; j < n; j++) {
                    map[i][j] = u[enkisaindex[i]][j];
                }
            }
        }

        int[][] koordinat = {{0, 0}, {405, 315}, {530, 271}, {210, 220}, {717, 153}, {424, 123}, {300, 157}, {211, 318}, {650, 83}, {94, 262}, {103, 168}, {189, 146}, {617, 208}, {676, 227}, {255, 117}, {195, 275}, {152, 142}, {44, 138}, {336, 127}, {388, 129}, {146, 270}, {510, 258}, {59, 59}, {564, 222}, {573, 165}, {644, 150}, {210, 168}, {493, 309}, {526, 108}, {560, 130}, {760, 263}, {443, 356}, {207, 271}, {379, 224}, {155, 96}, {67, 227}, {714, 108}, {342, 86}, {410, 225}, {84, 58}, {358, 202}, {188, 112}, {288, 271}, {187, 184}, {529, 240}, {80, 220}, {477, 282}, {635, 289}, {114, 296}, {660, 213}, {380, 231}, {378, 264}, {503, 107}, {611, 98}, {207, 112}, {442, 89}, {682, 253}, {388, 63}, {473, 170}, {93, 97}, {453, 140}, {576, 101}, {577, 198}, {554, 301}, {161, 222}, {738, 216}, {383, 169}, {266, 82}, {352, 243}, {600, 136}, {334, 168}, {650, 250}, {320, 307}, {705, 273}, {284, 72}, {696, 84}, {757, 141}, {161, 120}, {297, 98}, {483, 327}, {446, 310}, {237, 114}};

        Harita map1 = new Harita(map, koordinat, n, enkisaindex.length);

    }

    public static int satirsayisi() {
        int sayac = 0;
        try {
            FileInputStream fstream = new FileInputStream("sehir.txt");
            DataInputStream dstream = new DataInputStream(fstream);
            BufferedReader breader = new BufferedReader(new InputStreamReader(dstream));

            while (breader.readLine() != null) {
                sayac++;
            }
            dstream.close();

        } catch (Exception e) {
            System.out.println("hata!");
        }
        return sayac;
    }
}
