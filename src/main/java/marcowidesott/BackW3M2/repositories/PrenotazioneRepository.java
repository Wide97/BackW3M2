package marcowidesott.BackW3M2.repositories;

import marcowidesott.BackW3M2.entities.Dipendente;
import marcowidesott.BackW3M2.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);

    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
