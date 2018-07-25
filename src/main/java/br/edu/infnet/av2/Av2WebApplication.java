package br.edu.infnet.av2;

import br.edu.infnet.av2.model.Atendente;
import br.edu.infnet.av2.model.Gerente;
import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.model.Papeis;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.repository.AtendenteRepo;
import br.edu.infnet.av2.repository.GerenteRepo;
import br.edu.infnet.av2.repository.MotoboyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Av2WebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private GerenteRepo gerenteRepo;
    @Autowired
    private MotoboyRepo motoboyRepo;
    @Autowired
    private AtendenteRepo atendenteRepo;
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Av2WebApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Av2WebApplication.class, args);
        System.out.print(new BCryptPasswordEncoder().encode("123"));
    }
    
    @Override
    public void run(String... args) throws Exception {
        Papel gerenteRole = new Papel(Papeis.ROLE_GERENTE.toString());
        Papel atendenteRole = new Papel(Papeis.ROLE_ATENDENTE.toString());
        Papel usuarioRole = new Papel(Papeis.ROLE_USUARIO.toString());

        Gerente gerente = new Gerente(123, "gerente", new BCryptPasswordEncoder().encode("123"), "Gerente");
        gerente.getPapeis().add(gerenteRole);

        Motoboy entregador = new Motoboy("ABC123", 123, "entregador", new BCryptPasswordEncoder().encode("123"), "Entregador");
        entregador.getPapeis().add(usuarioRole);
        
        Atendente atendente = new Atendente(123, 123, "atendente", new BCryptPasswordEncoder().encode("123"), "Atendente");
        atendente.getPapeis().add(atendenteRole);
        
        motoboyRepo.save(entregador);
        atendenteRepo.save(atendente);
        gerenteRepo.save(gerente);
    }
}
