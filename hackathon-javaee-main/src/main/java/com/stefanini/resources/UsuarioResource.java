package com.stefanini.resources;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.services.UsuarioService;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response listarUsuarios(){
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }
    
    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorID(@PathParam("idUsuario")Long idUsuario){
        return Response.status(Response.Status.OK).entity(usuarioService.pegarUsuarioPorID(idUsuario)).build();
    }

    @POST
    public Response criarUsuario(@Valid @NotNull UsuarioDTO usuarioDTO){
        return Response.status(Response.Status.CREATED).entity(usuarioService.criarUsuario(usuarioDTO)).build();
    }
    
    @PUT
    public Response atualizarUsuario(@Valid UsuarioDTO usuarioDTO){
        return Response.status(Response.Status.OK).entity(usuarioService.atualizarUsuario(usuarioDTO)).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response deletarUsuario(@PathParam("idUsuario") Long idUsuario){
        usuarioService.deletarUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/aniversariantes")
    public Response pegarMes(){
        return Response.status(Response.Status.OK).entity(usuarioService.pegarMes()).build();
    }

    @GET
    @Path("/inicial/{inicial}")
    public Response listaDeNomeInicial(@PathParam("inicial") String inicial){
        return Response.status(Response.Status.OK).entity(usuarioService.pegarInicial(inicial)).build();
    }
}
