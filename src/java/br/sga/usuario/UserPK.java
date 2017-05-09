/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sga.usuario;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tarcio
 */
@Embeddable
public class UserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @Column(name = "cargo_user")
    private int cargoUser;

    public UserPK() {
    }

    public UserPK(int idUser, int cargoUser) {
        this.idUser = idUser;
        this.cargoUser = cargoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getCargoUser() {
        return cargoUser;
    }

    public void setCargoUser(int cargoUser) {
        this.cargoUser = cargoUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) cargoUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPK)) {
            return false;
        }
        UserPK other = (UserPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.cargoUser != other.cargoUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.sga.usuario.UserPK[ idUser=" + idUser + ", cargoUser=" + cargoUser + " ]";
    }
    
}
