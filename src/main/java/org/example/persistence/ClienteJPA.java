package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.entities.Cliente;

import java.util.List;

public class ClienteJPA {

    public static void crearCliente(Cliente cliente) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }
    }

    public static List<Cliente> getClientes() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {

            return em.createQuery("FROM Cliente", Cliente.class).getResultList();

        }
    }

    public static List<Cliente> consultarClientesPorCiudad(String ciudad) {
        try (EntityManager em = ConfigJPA.getEntityManager();) {
            //Filtramos la busqueda, y pasamos a minusculas para que no haya conflicto entre mayus y minus.
            TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente c WHERE LOWER(c.ciudad) = LOWER(:ciudad)", Cliente.class);
            q.setParameter("ciudad", ciudad);
            return q.getResultList();
        }
    }

    public static boolean eliminarCliente(Long idCliente) {
        try (EntityManager em = ConfigJPA.getEntityManager();) {
            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }

    }

    public static boolean actualizarCliente(Long idCliente, String nuevoNombre, String nuevoApellidos, String nuevoSexo, String nuevoCiudad, String nuevoFechaNacimiento, int nuevoNumTelf, String nuevoEmail) {

        try (EntityManager em = ConfigJPA.getEntityManager();) {

            Cliente cliente = em.find(Cliente.class, idCliente);

            if (cliente != null) {

                em.getTransaction().begin();
                cliente.setNombre(nuevoNombre);
                cliente.setApellidos(nuevoApellidos);
                cliente.setSexo(nuevoSexo);
                cliente.setCiudad(nuevoCiudad);
                cliente.setFechaNacimiento(nuevoFechaNacimiento);
                cliente.setNumTelf(nuevoNumTelf);
                cliente.setEmail(nuevoEmail);
                em.merge(cliente);
                em.getTransaction().commit();
                return true;

            }

            return false;

        }
    }
}
