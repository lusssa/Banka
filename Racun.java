import java.util.Scanner;

public class Racun {
    private String vlasnik;
    private int stanje;


    public Racun(String vlasnik, int stanje) {
        this.vlasnik = vlasnik;
        this.stanje = stanje;
    }

    public void uplati(int iznos) {
        if(iznos > 0) {
            stanje += iznos;
        } else {
            System.out.println("Iznos mora biti pozitivan.");
        }
    }

    public void podigni(int iznos) {
        if(iznos > 0 && iznos <= stanje) {
            stanje -= iznos;
        } else {
            System.out.println("Nedovoljno sredstava ili nevalidan iznos.");
        }
    }

    public void stanje() {
        System.out.println("Vlasnik: " + vlasnik + ", Stanje: " + stanje + " EUR");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesi ime vlasnika: ");
        String ime = sc.nextLine();
        Racun racun = new Racun(ime, 0);

        int izbor;
        do {
            System.out.println();
            System.out.println("1. Stanje");
            System.out.println("2. Uplata");
            System.out.println("3. Isplata");
            System.out.println("0. Izlaz");
            System.out.print("Izbor: ");
            izbor = sc.nextInt();

            if(izbor == 1) {
                racun.stanje();
            } else if(izbor == 2) {
                System.out.print("Unesi iznos za uplatu: ");
                int iznos = sc.nextInt();
                racun.uplati(iznos);
            } else if(izbor == 3) {
                System.out.print("Unesi iznos za isplatu: ");
                int iznos = sc.nextInt();
                racun.podigni(iznos);
            } else if(izbor != 0) {
                System.out.println("Nepoznata opcija.");
            }
        } while(izbor != 0);

        System.out.println("Dovidjenja!");
    }
}
