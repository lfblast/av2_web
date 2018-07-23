package br.edu.infnet.av2.seguranca;

import br.edu.infnet.av2.model.Funcionario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import br.edu.infnet.av2.repository.FuncionarioRepo;

@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private FuncionarioRepo funcionarioRepo;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepo.findByLogin(login);

        if (funcionario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return new User(funcionario.getUsername(), funcionario.getPassword(), true, true, true, true, funcionario.getAuthorities());
    }
}