package org.example;

import org.example.controller.ClienteController;
import org.example.entities.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opt;
        Scanner input = new Scanner(System.in);
        String nombre, apellidos, sexo, ciudad, fecha, email;
        int telf;
        Long idCliente;


        while (true){

            mostrarMenu();

            opt = input.nextInt();
            input.nextLine();

            switch (opt) {
                case 1:

                    //Crear cliente nuevo

                    System.out.println("Nombre: ");
                    nombre = input.nextLine();
                    System.out.println("Apellidos: ");
                    apellidos = input.nextLine();
                    System.out.println("Sexo: ");
                    sexo = input.nextLine();
                    System.out.println("Ciudad: ");
                    ciudad = input.nextLine();
                    System.out.println("Fecha de nacimiento: ");
                    fecha = input.nextLine();
                    System.out.println("Teléfono: ");
                    telf = input.nextInt();
                    input.nextLine();
                    System.out.println("Email: ");
                    email = input.nextLine();

                    ClienteController.crearCliente(nombre, apellidos, sexo,ciudad, fecha, telf, email);
                    System.out.println("Cliente agregado");
                    break;
                case 2:

                    //Listar clientes
                    List<Cliente> clientes = ClienteController.getClientes();
                    for(Cliente cliente : clientes){
                        System.out.println(cliente);
                    }
                    break;

                case 3:
                    //eliminar cliente
                    System.out.println("Indique el id del cliente a eliminar");

                    idCliente = input.nextLong();
                    System.out.println(ClienteController.eliminarCliente(idCliente) ? "Cliente eliminado" : "Cliente no encontrado");
                    break;
                case 4:
                    //consultar por ciudad
                    System.out.println("Que ciudad desea consultar?");
                    ciudad = input.nextLine();
                    System.out.println(ClienteController.consultarClientePorCiudad(ciudad));
                    break;
                case 5:
                    //actualizar
                    System.out.println("Introduzca codigo del cliente: ");
                    idCliente = input.nextLong();
                    input.nextLine();
                    System.out.println("Nombre actualizado: ");
                    String nombreNuevo = input.nextLine();
                    System.out.println("Apellidos actualizados: ");
                    String apellidosNuevo = input.nextLine();
                    System.out.println("Sexo actualizado: ");
                    String sexoNuevo = input.nextLine();
                    System.out.println("Ciudad actualizada: ");
                    String ciudadNuevo = input.nextLine();
                    System.out.println("Fecha de nacimiento actualizada: ");
                    String fechaNuevo = input.nextLine();
                    System.out.println("Teléfono actualizado: ");
                    int telfNuevo = input.nextInt();
                    input.nextLine();
                    System.out.println("Email actualizado: ");
                    String emailNuevo = input.nextLine();
                    System.out.println(ClienteController.actualizarCliente(idCliente, nombreNuevo, apellidosNuevo, sexoNuevo,ciudadNuevo, fechaNuevo, telfNuevo, emailNuevo) ? "Cliente actualizado!" : "Cliente no encontrado" );
                    break;
                case 6:
                    //salir
                    System.out.println("Hasta pronto");
                    return;


            }

        }


    }

    private static void mostrarMenu(){
        System.out.println("\n ---------------- MENU ----------------\nQué operacion desea realizar?");
        System.out.println("1- Crear cliente");
        System.out.println("2- Lista de clientes");
        System.out.println("3- Eliminar cliente");
        System.out.println("4- Consultar cliente por ciudad");
        System.out.println("5- Actualizar cliente");
        System.out.println("6- Salir");
    }
}