package marcowidesott.BackW3M2.exceptions;

public class ViaggioNonTrovatoException extends RuntimeException {
    public ViaggioNonTrovatoException(Long id) {
        super("Viaggio con Id " + id + " Non trovato");
    }
}
