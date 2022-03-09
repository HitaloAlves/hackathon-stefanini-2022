package com.stefanini.repositeries;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entities.UsuarioEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long >{
   
    public List<UsuarioDTO> listarUsuarios(){
       List<UsuarioEntity> usuarios = this.listAll();
       return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
   }

   @Transactional
   public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
       UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
       this.save(usuarioEntity);
       return new UsuarioDTO(usuarioEntity);
   }

   public UsuarioDTO pegarUsuarioPorID(Long id){
       return new UsuarioDTO(this.findById(id));
   }

   @Transactional
   public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
   }

   @Transactional
   public void deletarUsuario(Long idUsuario){this.delete(idUsuario);}

   public List<UsuarioDTO> listaDeAniversariantes(){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tb_usuario WHERE month(data_nascimento) = ?");
        nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultadoLista = nativeQuery.getResultList();
        return resultadoLista.stream().map(UsuarioDTO::new).collect(Collectors.toList());
   }

   public List<UsuarioDTO> listaDeNomeInicial(String inicial){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tb_usuario WHERE nome LIKE ?");
        nativeQuery.setParameter(1, inicial + "%");
        List<UsuarioEntity> resultadoLista = nativeQuery.getResultList();
        return resultadoLista.stream().map(UsuarioDTO::new).collect(Collectors.toList());
   }

}
