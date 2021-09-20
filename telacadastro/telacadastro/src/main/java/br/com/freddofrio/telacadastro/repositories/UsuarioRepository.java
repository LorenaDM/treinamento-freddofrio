package br.com.freddofrio.telacadastro.repositories;
/*Essa pasta a gente guardar oq vai manipular o banco de dados*/

import br.com.freddofrio.telacadastro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/*salvar e deletar, procurar registros*/
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}