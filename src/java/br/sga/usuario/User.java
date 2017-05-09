/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sga.usuario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tarcio
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.userPK.idUser = :idUser")
    , @NamedQuery(name = "User.findByNomeUser", query = "SELECT u FROM User u WHERE u.nomeUser = :nomeUser")
    , @NamedQuery(name = "User.findByLoginUser", query = "SELECT u FROM User u WHERE u.loginUser = :loginUser")
    , @NamedQuery(name = "User.findByEmailUser", query = "SELECT u FROM User u WHERE u.emailUser = :emailUser")
    , @NamedQuery(name = "User.findByCargoUser", query = "SELECT u FROM User u WHERE u.userPK.cargoUser = :cargoUser")
    , @NamedQuery(name = "User.findBySenhaUser", query = "SELECT u FROM User u WHERE u.senhaUser = :senhaUser")
    , @NamedQuery(name = "User.findByDtCreateUser", query = "SELECT u FROM User u WHERE u.dtCreateUser = :dtCreateUser")
    , @NamedQuery(name = "User.findByStatusUser", query = "SELECT u FROM User u WHERE u.statusUser = :statusUser")
    , @NamedQuery(name = "User.findByUserTipo", query = "SELECT u FROM User u WHERE u.userTipo = :userTipo")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @Column(name = "nome_user")
    private String nomeUser;
    @Basic(optional = false)
    @Column(name = "login_user")
    private String loginUser;
    @Basic(optional = false)
    @Column(name = "email_user")
    private String emailUser;
    @Column(name = "senha_user")
    private String senhaUser;
    @Basic(optional = false)
    @Column(name = "dt_create_user")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreateUser;
    @Basic(optional = false)
    @Column(name = "status_user")
    private boolean statusUser;
    @Basic(optional = false)
    @Column(name = "user_tipo")
    private String userTipo;
    @JoinColumn(name = "cargo_user", referencedColumnName = "id_cargo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cargo cargo;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String nomeUser, String loginUser, String emailUser, Date dtCreateUser, boolean statusUser, String userTipo) {
        this.userPK = userPK;
        this.nomeUser = nomeUser;
        this.loginUser = loginUser;
        this.emailUser = emailUser;
        this.dtCreateUser = dtCreateUser;
        this.statusUser = statusUser;
        this.userTipo = userTipo;
    }

    public User(int idUser, int cargoUser) {
        this.userPK = new UserPK(idUser, cargoUser);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public Date getDtCreateUser() {
        return dtCreateUser;
    }

    public void setDtCreateUser(Date dtCreateUser) {
        this.dtCreateUser = dtCreateUser;
    }

    public boolean getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(boolean statusUser) {
        this.statusUser = statusUser;
    }

    public String getUserTipo() {
        return userTipo;
    }

    public void setUserTipo(String userTipo) {
        this.userTipo = userTipo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sga.usuario.User[ userPK=" + userPK + " ]";
    }
    
}
