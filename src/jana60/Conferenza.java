package jana60;

public class Conferenza extends Evento {
    private String argomento;
    private Oratore oratore;

    public Conferenza(String titolo, String data, int postiTot, String argomento, Oratore oratore) throws IllegalArgumentException {
        super(titolo, data, postiTot);
        this.argomento = argomento;
        this.oratore = oratore;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public Oratore getOratore() {
        return oratore;
    }

    public void setOratore(Oratore oratore) {
        this.oratore = oratore;
    }

    @Override
    public String toString() {
        return super.toString()+" è una conferenza riguardante \"" + argomento + "\" tenuta da: " + oratore;
    }
}
