package dio.web.api.repository;

import java.util.List;
import java.util.ArrayList;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
    public void save(Usuario usuario) {
        if(usuario.getUsername() == null) {
            throw new CampoObrigatorioException("login");
        }

        if(usuario.getPassword() == null) {
            throw new CampoObrigatorioException("password");
        }

        if(usuario.getId() == null) {
            System.out.println("SAVE -- Recebendo o usuário na camada de repositório");
        } else {
            System.out.println("UPDATE -- Recebendo o usuário na camada de repositório");
        }

        System.out.println(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id -- Recebendo o id: %d para excluir", id));
        System.out.println(id);
    }

    public List<Usuario> findAll() {
        System.out.println("LIST -- Listando os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("italo", "12345"));
        usuarios.add(new Usuario("alice", "54321"));

        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id -- Recebendo o id: %d para localizar o usuário"));
        return new Usuario("Jack", "titanic");
    }

    public Usuario findByUsername(String username) {
        System.out.println("FIND/id -- Recebendo o id: %d para localizar o usuário");
        return new Usuario("Rose", "titanic2");
    }
}
