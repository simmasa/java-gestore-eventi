package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String titolo;
    private LocalDate data;
    private int postiTot, postiPrenotati;

    //contructor

    public Evento(String titolo, String data, int postiTot) throws IllegalArgumentException {
        validPosti(postiTot);

        this.titolo = titolo;
        this.data = validData(data);
        this.postiTot = postiTot;
        this.postiPrenotati = 0;
    }

    //getter/setter

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) throws IllegalArgumentException {
        this.data = validData(data);
    }

    public int getPostiTot() {
        return postiTot;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //validator

    private LocalDate validData(String data) throws IllegalArgumentException {
        LocalDate date = LocalDate.parse(data,format);
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato");
        }
        return date;
    }
    private void validPosti(int posti) throws IllegalArgumentException {
        if (posti<1)
            throw new IllegalArgumentException("Ci deve essere almeno un posto");
    }

    //altri

    public void prenota() throws Exception {
        if (LocalDate.now().isAfter(data)) {
            throw new Exception("Impossibile prenotare eventi già passati.");
        } else if (postiTot==postiPrenotati) {
            throw new Exception("Non ci sono abbastanza posti disponibili.");
        } else
            postiPrenotati++;
    }
    public void disdici() throws Exception {
        if (LocalDate.now().isAfter(data)) {
            throw new Exception("Impossibile disdire eventi già passati");
        } else if (postiPrenotati<1) {
            throw new Exception("Non ci sono prenotazioni per questo evento");
        }else
            postiPrenotati--;
    }

    @Override
    public String toString() {
        return "Evento in data "+ format.format(data)+" dal titolo "+titolo;
    }
}
