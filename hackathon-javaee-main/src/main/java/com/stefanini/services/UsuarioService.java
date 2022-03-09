package com.stefanini.services;


import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repositeries.UsuarioRepository;

import java.util.Base64;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;



@ApplicationScoped
public class UsuarioService {
    
    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO pegarUsuarioPorID(Long idUsuario) {
        return usuarioRepository.pegarUsuarioPorID(idUsuario);
    }
    
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        if(Objects.nonNull(usuarioDTO.getIdUsuario())){
            throw new RuntimeException("Não mande ID para cadastrar usuário");
        }
        if(!usuarioDTO.getSenha().isEmpty()){
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
        }
        return usuarioRepository.criarUsuario(usuarioDTO);
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        if(!Objects.nonNull(usuarioDTO.getIdUsuario())){
            throw new RuntimeException("Mande ID para alterar usuário");
        }
        
        if(!usuarioDTO.getSenha().isEmpty()){
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
        }
        
        return usuarioRepository.atualizarUsuario(usuarioDTO);
    }

    public void deletarUsuario(Long idUsuario){
        usuarioRepository.deletarUsuario(idUsuario);
    }


    public List<UsuarioDTO> pegarMes(){
        return usuarioRepository.listaDeAniversariantes();
    }

    public List<UsuarioDTO> pegarInicial(String inicial){
        return usuarioRepository.listaDeNomeInicial(inicial);
    }

    //public List<String> pegarProvedores(){
        //List<String> listarProvedores = new ArrayList<>();

    //}
}
