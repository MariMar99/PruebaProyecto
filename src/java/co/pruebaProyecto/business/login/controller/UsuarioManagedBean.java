/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.pruebaProyecto.business.login.controller;


import co.pruebaProyecto.backend.persistence.entity.Rol;
import co.pruebaProyecto.backend.persistence.entity.Usuario;
import co.pruebaProyecto.backend.persistence.facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import org.primefaces.context.RequestContext;

/**
 *
 * @author Mariana
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {

    @EJB
    private UsuarioFacade usufc;
    
    private Usuario usuario;
    private Rol rol;
            
    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
        
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void registrarUsuario(){
        try {
            usufc.create(usuario);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarUsuario(Usuario usuario){
        try {
            usufc.remove(usuario);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        try {
            usufc.edit(usuario);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<Usuario> listarUsuario(){
        return usufc.findAll();
    }
    
     private void mensajeError(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha Producido el siguiente Error: ", e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Insertar:", e.getMessage());
//        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }

    private void mensajeExito(String operacion) {
        String msg = "Se ha realizado exitosamente la operacion de " + operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción con Exito : ", msg);
//        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }
    
    
    public String loginControl(){
        try{
           usuario = usufc.ingresar(usuario);
            if (usuario != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioL", usuario);
                return "/sesionProtegido/index.xhtml?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                return "";
            }
        }catch(Exception e){
            return "";
        }
    }

    
}

