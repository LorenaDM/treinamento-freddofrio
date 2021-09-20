package br.com.freddofrio.telacadastro.entity;
/*transforma classe em tabela*/
/*hibernate sabe que a classe é uma tabela*/
/*tabela, se não hover o name, a tabela fica com o nome padrão*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "usuarios")
public class Usuario extends AbstractPersistable<Long> {


    @NotBlank // Método de validação do hibernate validator
    @Size(min = 4, max = 255, message = "min:4 max:255") // Método de validação do hibernate validator
    @Column
    private String nome;

    @NotBlank(message = "vazio") // Método de validação do hibernate validator
    @Email(message = "email") // Método de validação do hibernate validator
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank // Método de validação do hibernate validator
    @Size(min = 4, max = 255, message = "min:4 max:255") // Método de validação do hibernate validator
    @Column(name = "username",nullable = false, unique = true)
    private String username;

    @NotBlank // Método de validação do hibernate validator
    @Size(min = 6) // Método de validação do hibernate validator
    @Column(nullable = false)
    private String senha;


    @Transient // Transient: objeto que não será salvo no banco de dados
    @Size(min=6)
    private String reSenha;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getReSenha() {
        return reSenha;
    }

    public void setReSenha(String reSenha) {
        this.reSenha = reSenha;
    }
}