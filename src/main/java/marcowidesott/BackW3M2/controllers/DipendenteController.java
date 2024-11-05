package marcowidesott.BackW3M2.controllers;

import marcowidesott.BackW3M2.entities.Dipendente;
import marcowidesott.BackW3M2.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public ResponseEntity<Dipendente> creaDipendente(@RequestBody Dipendente dipendente) {
        Dipendente nuovoDipendente = dipendenteService.creaDipendente(dipendente);
        return new ResponseEntity<>(nuovoDipendente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        Dipendente dipendente = dipendenteService.getDipendenteById(id);
        return ResponseEntity.ok(dipendente);
    }

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAllDipendenti() {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        return ResponseEntity.ok(dipendenti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> aggiornaDipendente(@PathVariable Long id, @RequestBody Dipendente nuovoDipendente) {
        Dipendente dipendenteAggiornato = dipendenteService.aggiornaDipendente(id, nuovoDipendente);
        return ResponseEntity.ok(dipendenteAggiornato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaDipendente(@PathVariable Long id) {
        dipendenteService.eliminaDipendente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{dipendenteId}/upload-foto")
    public ResponseEntity<String> uploadFotoProfilo(
            @PathVariable Long dipendenteId,
            @RequestParam("file") MultipartFile file) {
        dipendenteService.uploadFotoProfilo(dipendenteId, file);
        return ResponseEntity.ok("Foto caricata con successo");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Accesso consentito solo agli amministratori";
    }
}
