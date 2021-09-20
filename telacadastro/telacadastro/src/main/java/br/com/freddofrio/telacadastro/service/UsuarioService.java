package br.com.freddofrio.telacadastro.service;

import br.com.freddofrio.telacadastro.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Esses arquivos de classe são usados para escrever lógica de negócios em uma camada diferente, separada do arquivo de classe @Controller
public class UsuarioService {

    @Autowired //O recurso de autowiring do Spring framework permite que você injete a dependência do objeto implicitamente
    private UsuarioService repository;

    // método que salvar no banco de dados
    public void save(Usuario usuario) {

        // método para salvar a senha criptografada
        String csenha = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(csenha);

        repository.save(usuario);
    }
}
