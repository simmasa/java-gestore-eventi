package jana60;

public class Oratore {
    private String nome,cognome,titolo;

    //constr
    public Oratore(String nome, String cognome, String titolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.titolo = titolo;
    }
    //get/set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "("+titolo+") "+nome+" "+cognome;
    }
}
