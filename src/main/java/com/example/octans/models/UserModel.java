package com.example.octans.models;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class UserModel{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_user;

    @OneToOne()
    @JoinColumn(name="id_rol", insertable = false, updatable = false)
    private RolModel rolModel;

    private Integer id_rol;
    private String name;
    private Boolean active;

    public Long getIdUser(){
        return id_user;
    }

    public void setIdUser( Long id_user ){
        this.id_user = id_user;
    }

    public Integer getIdRol(){
        return id_rol;
    }

    public void setIdRol( Integer id_rol ){
        this.id_rol = id_rol;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public Boolean getActive(){
        return active;
    }

    public void setActive( Boolean active ){
        this.active = active;
    }
   
}

