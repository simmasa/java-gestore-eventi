package jana60;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ProgrammEventi {
    public static void main(String[] args) {
        ArrayList<Evento> listaEventi = new ArrayList<>();

        Evento primo = new Evento("primo","27/12/2022",30);
        listaEventi.add(primo);
        Evento secondo = new Evento("aaaa","27/12/2022",30);
        listaEventi.add(secondo);
        Evento terzo = new Evento("zzz","27/12/2022",30);
        listaEventi.add(terzo);

        Evento quarto = new Evento("quarto","15/07/2022",30);
        listaEventi.add(quarto);
        Evento quinto = new Evento("quinto","29/07/2022",30);
        listaEventi.add(quinto);

        Evento sesto = new Evento("sesto","05/07/2023",30);
        listaEventi.add(sesto);


        Collections.sort(listaEventi);

        ArrayList<Evento> prossimiEventi = new ArrayList<>();
        ArrayList<Evento> eventiFuturi = new ArrayList<>();
        for (Evento ele :listaEventi) {
            if (ele.getData().isAfter(LocalDate.now().plusMonths(1))) {
                eventiFuturi.add(ele);
            }else prossimiEventi.add(ele);
        }

        System.out.println("Lista eventi ordinata per data e per nome:");
        for (Evento ele :listaEventi)
            System.out.println(ele);
        System.out.println();

        System.out.println("Lista eventi di questo mese:");
        for (Evento ele :prossimiEventi)
            System.out.println(ele);
        System.out.println();

        System.out.println("Lista eventi futuri:");
        for (Evento ele :eventiFuturi)
            System.out.println(ele);
    }
}
