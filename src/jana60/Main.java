package jana60;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto");
        System.out.println("Inserisci i dati del tuo evento:");
        Scanner scan = new Scanner(System.in);
        ArrayList<Evento> listaEventi = new ArrayList<>();

        String titolo,data;
        int posti;

        System.out.println("Inserisci il titolo dell'evento:");
        titolo= "titolo";
        System.out.println("Inserisci la data del tuo evento in formato dd/mm/yyyy : ");
        data = "27/12/2022";

        try {
            System.out.println("Inserisci la quantità di posti a tua disposizione:");
            posti = Integer.parseInt(scan.nextLine());

            Evento primo = new Evento(titolo, data, posti);
            listaEventi.add(primo);
            System.out.println("Abbiamo aggiunto il tuo evento alla nostra lista");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String opt;
        do {
            System.out.println("Vuoi prenotare dei posti per l'evento? Premi '1' per confermare o '2' per uscire");
            opt = scan.nextLine();
        }while (!opt.equals("1") && !opt.equals("2"));
        switch (opt) {
            case "1":
                int postiDaPrenotare = 0;
                do {
                    System.out.println("Quanti posti vuoi prenotare?");
                    try {
                        postiDaPrenotare = Integer.parseInt(scan.nextLine());
                        for (int i =0; i <postiDaPrenotare;i++)
                            listaEventi.get(0).prenota();
                    } catch (NumberFormatException e) {
                        System.out.println("Solo i numeri possono essere inseriti");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (postiDaPrenotare==0);
                System.out.println("Grazie per aver prenotato dei posti.");
                break;

            case "2":
                System.out.println("Grazie per aver creato un evento. ");
        }

    }
}
