package kvizi;


import java.util.ArrayList;

public class Kviz1 {
    public static void main(String[] args) {

    }
    static void java() {
        System.out.println("""
                   J    a   v     v  a
                   J   a a   v   v  a a
                J  J  aaaaa   V V  aaaaa
                 JJ  a     a   V  a     a""");
    }

    static void kalkulator(int a, int b) {
        if (b != 0) {
            System.out.println(a + " + " + b + " = " + (a + b));
            System.out.println(a + " - " + b + " = " + (a - b));
            System.out.println(a + " x " + b + " = " + (a * b));
            System.out.println(a + " / " + b + " = " + (a / b));
            System.out.println(a + " % " + b + " = " + (a % b));
        }
        else {
            System.out.println("Napaka: deljenje z 0");
        }
    }

    static void nicli(int a, int b, int c) {
        if (b % a == 0 && c % a == 0) {
            b /= a;
            c /= a;
            a = 1;
        }
        double D = Math.pow(b, 2) - 4 * a * c;
        if (D < 0) {
            System.out.println("Napaka: nicli enacbe ne obstajata");
        }
        else {
            double x1 = (-b + Math.sqrt(D)) / 2;
            double x2 = (-b - Math.sqrt(D)) / 2;
            System.out.println("x1=" + String.format("%.2f", x1)
                            + ", x2=" + String.format("%.2f", x2));
        }
    }

    static void krog(double r, int d) {
        if (r < 0) {
            System.out.println("Napaka: negativen polmer");
        } else if (d < 0) {
            System.out.println("Napaka: negativen d");
        }
        else {
            double obseg = 2 * Math.PI * r;
            double ploscina = Math.PI * Math.pow(r, 2);
            System.out.println("Obseg kroga s polmerom r="
                            + String.format("%.2f", r) + " je "
                            + String.format("%%.%df".formatted(d), obseg));
            System.out.println("Ploscina kroga s polmerom r="
                    + String.format("%.2f", r) + " je "
                    + String.format("%%.%df".formatted(d), ploscina));
        }
    }

    static String pretvoriSekunde(int sekunde) {
        if (sekunde < 0) {
            return "Število sekund ne more biti negativno";
        }
        int minute = 0;
        int ure = 0;
        if (sekunde > 60) {
            minute = sekunde / 60;
            sekunde %= 60;
        }
        if (minute > 60) {
            ure = minute / 60;
            minute %= 60;
        }
        return String.format("%02d", ure) + ":"
                + String.format("%02d", minute) + ":"
                + String.format("%02d", sekunde);
    }

    static int pretvoriVSekunde(String cas) {
        return Integer.parseInt(cas.split(":")[2]) +
                (Integer.parseInt(cas.split(":")[1]) +
                        Integer.parseInt(cas.split(":")[0])*60)*60;
    }

    static void javaJavaJava(int n) {
        String vrstica1 = "     J    a   v     v  a   ";
        String vrstica2 = "     J   a a   v   v  a a  ";
        String vrstica3 = "  J  J  aaaaa   V V  aaaaa ";
        String vrstica4 = "   JJ  a     a   V  a     a";
        if (n < 0) {
            System.out.println("Napaka: negativen n");
            return;
        }
        System.out.println(vrstica1.repeat(n));
        System.out.println(vrstica2.repeat(n));
        System.out.println(vrstica3.repeat(n));
        System.out.println(vrstica4.repeat(n));
    }

    static boolean jeFibonaccijevo(int n) {
        int f = 1;
        int fP = 1;
        while (f <= n) {
            int temp = fP;
            fP = f;
            f += temp;
            if (f == n) {return true;}
        }
        return false;
    }

    static boolean jePrastevilo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    static void izrisiZastavo(int n) {
        for (int i=0;i<5*n;i++) {
            for (int j=0;j<15*n +1;j++) {
                if (i < 3*n) {
                    if (j < 4*n - 1) {
                        boolean zvezdica = (j%2 == 0);
                        if (i%2 != 0)
                            zvezdica = !zvezdica;
                        if (zvezdica) {
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    } else if (j == 4*n - 1) {
                        System.out.print(" ");
                    }else {
                        System.out.print("=");
                    }
                }else {
                    System.out.print("=");
                }
            }
            System.out.print("\n");
        }
    }

    static void vDesetisko(int n) {
        for (String s:Integer.toString(n).split("")) {
            if(Integer.parseInt(s) >= 8) {
                System.out.println("Število "+n+" ni število v osmiškem sistemu (števka "+s+")");
                return;
            }
        }
        System.out.println(n+"(8) = " + Integer.parseInt(""+n, 8) + "(10)");
    }

    static String pretvoriVDesetisko(String n, int b) {
        for (String s:n.split("")) {
            try{
                Integer.parseInt(s,b);
            }
            catch(NumberFormatException e) {
                return "Napaka pri pretvorbi sistema - števka "+s;
            }
        }
        return n+"("+b+")=" + Integer.parseInt(n, b) + "(10)";
    }

    static int vsotaPrvih(int n) {
        int stevilo = 2;
        int vsota = 0;
        int stevec = 0;
        while(stevec < n) {
            if(jePrastevilo(stevilo)) {
                vsota += stevilo;
                stevec ++;
            }
            stevilo ++;
        }

        return vsota;
    }

    static void pitagoroviTrojcki(int x) {
        int c = 1;
        int b = 1;
        for (int a = 1; a <= b; a++) {
            for (b = a; b <= c; b++) {
                for (c = b; c <= x; c++) {
                    if (a*a + b*b == c*c) {
                        System.out.println(a+" "+b+" "+c);
                    }
                }
            }
        }
    }

    static int[] stik(int[] tabela1, int[] tabela2) {
        int[] vsota = new int[tabela1.length + tabela2.length];
        System.arraycopy(tabela1, 0, vsota, 0, tabela1.length);
        System.arraycopy(tabela2, 0, vsota, tabela1.length, tabela2.length);
        return vsota;
    }

    static int[] presek(int[] tab1, int[] tab2) {
        int[] temp = new int[tab1.length];
        int steviloSkupnih = 0;
        for (int x1:tab1) {
            for (int x2: tab2) {
                if (x1 == x2) {
                    boolean vTabeli = false;
                    for (int i = 0; i < steviloSkupnih; i++) {
                        if (x1 == temp[i]) {
                            vTabeli = true;
                            break;
                        }
                    }
                    if (!vTabeli) {
                        temp[steviloSkupnih++] = x1;
                    }
                }
            }
        }
        int[] rez = new int[steviloSkupnih];
        System.arraycopy(temp, 0, rez, 0, rez.length);
        return rez;
    }

    static String izracunajRazliko(String cas1, String cas2) {
        return pretvoriSekunde(Math.abs(pretvoriVSekunde(cas1)-pretvoriVSekunde(cas2)));
    }

    static void praDvojcek(int n) {
        for (int i = 2; i < n; i++) {
            if (jePrastevilo(i) && jePrastevilo(i - 2))
                System.out.println("("+(i-2)+", "+i+")");
        }
    }
}
