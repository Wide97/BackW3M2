package marcowidesott.BackW3M2.services;

import marcowidesott.BackW3M2.entities.Dipendente;
import marcowidesott.BackW3M2.repositories.DipendenteRepository;
import marcowidesott.BackW3M2.tools.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String authenticate(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        return jwtUtils.generateJwtToken(authentication.getName());
    }

    public void registerUser(Dipendente dipendente) {
        String encodedPassword = passwordEncoder.encode(dipendente.getPassword());
        dipendente.setPassword(encodedPassword);
        dipendenteRepository.save(dipendente);
    }
}

