package jana60;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto");
        System.out.println("Inserisci i dati del tuo evento:");
        Scanner scan = new Scanner(System.in);
//        ArrayList<Evento> listaEventi = new ArrayList<>();        //all'inizio l'evento finiva in una lista ma dato che
        Evento primo = null; //inizializzo un Evento                  non era richiesto nella consegna l'ho commentato

        String titolo,data;
        int posti=0;

        //Chiedo i dati dell'evento
        System.out.println("Inserisci il titolo dell'evento");
        titolo= scan.nextLine();
        System.out.println("Inserisci la data del tuo evento in formato dd/mm/yyyy : ");
        data = scan.nextLine();

        try {       //uso un try per evitare un'exception dal parse per i posti
            System.out.println("Inserisci la quantità di posti a tua disposizione:");
            posti = Integer.parseInt(scan.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Inserito valore non valido per il campo \"posti\""); //gestisco eccezioni parse
        }

        String confCheck;
        do {                //chiedo se l'evento che stiamo creando è una conferenza
            System.out.println("L'evento che vuoi inserire è una conferenza? y/n");
            confCheck=scan.nextLine();
        }while (!confCheck.equals("y") && !confCheck.equals("n"));

        try{
            switch (confCheck) {        //se non è una conferenza il programma crea un evento
                case "n":
                    primo = new Evento(titolo, data, posti);
//                    listaEventi.add(primo);
                    break;
                case"y":            //se è una conferenza il programma chiede dati supplementari e crea una conferenza
                    System.out.println("Inserisci l'argomento della conferenza");
                    String argomento = scan.nextLine();
                    System.out.println("Inserisci il nome dell'oratore");
                    String nomeOr = scan.nextLine();
                    System.out.println("Inserisci il cognome dell'oratore");
                    String cognomeOr = scan.nextLine();
                    System.out.println("Inserisci il titolo dell'oratore");
                    String titoloOr = scan.nextLine();
                    primo =new Conferenza(titolo, data, posti,argomento,new Oratore(nomeOr,cognomeOr,titoloOr));
//                    listaEventi.add(primo);
                    break;
                default:
                    System.out.println("Inserito valore non valido");
            }
            System.out.println("Abbiamo aggiunto il tuo evento"); //print dell'evento creato
            System.out.println(primo);
        } catch (IllegalArgumentException e) {      //eccezioni dai constructor
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (DateTimeParseException e) {
            System.out.println("La data non è stat inserita correttamente");
            System.exit(1);
        }

        String opt;
        do {        //chiedo se si vogliono prenotare posti per l'evento creato
            System.out.println("Vuoi prenotare dei posti per l'evento? Premi '1' per confermare o '2' per uscire");
            opt = scan.nextLine();
        }while (!opt.equals("1") && !opt.equals("2"));

        switch (opt) {
            case "1":
                int postiDaPrenotare = 0;
                do {            //loop per controllare che vengano inseriti solo numeri
                    System.out.println("Quanti posti vuoi prenotare?");
                    try {
                        postiDaPrenotare = Integer.parseInt(scan.nextLine());
                        for (int i =0; i <postiDaPrenotare;i++)
                            primo.prenota();
                    } catch (NumberFormatException e) {
                        System.out.println("Solo numeri possono essere inseriti");  //gestisco il parse
                    } catch (Exception e) {
                        System.out.println(e.getMessage());     //gestisco exception dal method per prenotare
                    }
                } while (postiDaPrenotare==0);
                System.out.println("Grazie per aver prenotato dei posti.");
                break;

            case "2":
                System.out.println("Grazie per aver creato un evento.");
                break;
        }
        scan.close();

    }
}
