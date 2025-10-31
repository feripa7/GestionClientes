package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String apellidos;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String ciudad;
    @Column(nullable = false)
    private String fechaNacimiento;
    @Column(nullable = false)
    private int numTelf;
    @Column(nullable = false)
    private String email;


    public Cliente(){

    }

    //Constructor para cliente que cubra todos los campos
    public Cliente(String nombre, String apellidos, String sexo, String ciudad, String fechaNacimiento, int numTelf, String email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.numTelf = numTelf;
        this.email = email;
    }


    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(int numTelf) {
        this.numTelf = numTelf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", sexo=" + sexo +
                ", ciudad='" + ciudad + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", numTelf=" + numTelf +
                ", email='" + email + '\'' +
                '}';
    }
}
