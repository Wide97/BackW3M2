package marcowidesott.BackW3M2.exceptions;

public class DipendenteNonTrovatoException extends RuntimeException {
    public DipendenteNonTrovatoException(Long id) {
        super("Dipendente con id " + id + " Non trovato");
    }
}
