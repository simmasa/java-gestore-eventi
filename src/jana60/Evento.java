package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String titolo;
    private LocalDate data;
    private int postiTot, postiPrenotati;

    //contructor

    public Evento(String titolo, LocalDate data, int postiTot) throws IllegalArgumentException {
        validData(data);
        validPosti(postiTot);

        this.titolo = titolo;
        this.data = data;
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

    public void setData(LocalDate data) throws IllegalArgumentException {
        validData(data);
        this.data = data;
    }

    public int getPostiTot() {
        return postiTot;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //validator

    private void validData(LocalDate data) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato");
        }
    }
    private void validPosti(int posti) throws IllegalArgumentException {
        if (posti<1)
            throw new IllegalArgumentException("Ci deve essere almeno un posto");
    }

    //altri

    public void prenota() throws Exception {
        if (LocalDate.now().isAfter(data)) {
            throw new Exception("Impossibile prenotare eventi già passati");
        } else if (postiTot==postiPrenotati) {
            throw new Exception("L'evento è al completo");
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
