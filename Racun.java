import java.util.Scanner;

public class Racun {
    private String vlasnik;
    private int stanje;
    private String brojRacuna;
    private String sifra;
    private static int brojac = 1;


    public Racun(String vlasnik, int stanje, String sifra) {
        this.vlasnik = vlasnik;
        this.sifra = sifra;
        this.stanje = stanje;
        this.brojRacuna = "ABC-" + brojac;
        brojac++;
    }


    public boolean provjeriSifru(String unos) {
        return sifra.equals(unos);
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
        System.out.println("Broj racuna: " + brojRacuna);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesi ime vlasnika: ");
        String ime = sc.nextLine();
        System.out.println("Unesi sifru: ");
        String sifra = sc.nextLine();


        Racun racun = new Racun(ime, 0, sifra);
        System.out.println("Racun kreiran. Broj racuna: " + racun.brojRacuna);


        boolean prijavljen = false;
        int izbor;

        do {
            System.out.println();
            if(!prijavljen) {
                System.out.println("1. Prijava");
                System.out.println("0. Izlaz");
                System.out.print("Izbor: ");
                izbor = sc.nextInt();


                if(izbor == 1) {
                    System.out.print("Unesi ime vlasnika: ");
                    String unosIme = sc.next();
                    if(!unosIme.equals(racun.vlasnik)) {
                        System.out.println("Nepoznat vlasnik.");
                        continue;
                    }
                    System.out.print("Unesi sifru: ");
                    String unosSifre = sc.next();
                    if(racun.provjeriSifru(unosSifre)) {
                        prijavljen = true;
                        System.out.println("Uspjesna prijava.");
                    } else {
                        System.out.println("Pogresna sifra.");
                    }
                } else if(izbor != 0) {
                    System.out.println("Nepoznata opcija.");
                }
            } else {
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
            }
        } while(izbor != 0);
        
    }
}
