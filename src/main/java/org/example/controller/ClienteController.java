package org.example.controller;

import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;

import java.util.List;

public class ClienteController {

    public static void crearCliente(String nombre, String apellidos, String sexo, String ciudad, String fechaNacimiento, int numTelf, String email) {

      ClienteJPA.crearCliente(new Cliente(nombre, apellidos, sexo, ciudad, fechaNacimiento, numTelf, email));
    }

    public static List<Cliente> getClientes() {
        return ClienteJPA.getClientes();
    }

    public static List<Cliente> consultarClientePorCiudad(String ciudad) {
        return ClienteJPA.consultarClientesPorCiudad(ciudad);
    }

    public static boolean eliminarCliente(Long idCliente) {
        return ClienteJPA.eliminarCliente(idCliente);
    }

    public static boolean actualizarCliente(Long idCliente, String nuevoNombre, String nuevoApellidos, String nuevoSexo, String nuevoCiudad, String nuevoFechaNacimiento, int nuevoNumTelf, String nuevoEmail) {

        return ClienteJPA.actualizarCliente(idCliente, nuevoNombre, nuevoApellidos, nuevoSexo, nuevoCiudad, nuevoFechaNacimiento, nuevoNumTelf, nuevoEmail);
    }

}
