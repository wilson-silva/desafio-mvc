package com.gft.gerenciadorEventos.services;

import com.gft.gerenciadorEventos.entities.Usuario;
import com.gft.gerenciadorEventos.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    //-----------------------------------------------------------------------
    public Usuario salvarUsuario(Usuario usuario){
        usuario.setSenha(passwordEncoder().encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    //-----------------------------------------------------------------------
    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    //-----------------------------------------------------------------------
    public Usuario obterUsuario(String login) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(login);

        if(usuario.isEmpty()){
            throw new Exception("Usuario não encontrado!");
        }

        return usuario.get();
    }
    //-----------------------------------------------------------------------
    public void excluirUsuario(String login){
        usuarioRepository.deleteById(login);
    }
}
