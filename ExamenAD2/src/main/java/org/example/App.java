package org.example;

public class App 
{
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            Cliente cliente1 = new Cliente(1L, "Naomi", 500L, true);
            Cliente cliente2 = new Cliente(2L, "Carlos", 1000L, true);
            Cliente cliente3 = new Cliente(3L, "Jorge", 800L, true);
            Cliente cliente4 = new Cliente(4L, "Carmen", 300L, true);
            Cliente cliente5 = new Cliente(5L, "Lorena", 100L, true);

            clienteDAO.insertarCliente(cliente1);
            clienteDAO.insertarCliente(cliente2);
            clienteDAO.insertarCliente(cliente3);
            clienteDAO.insertarCliente(cliente4);
            clienteDAO.insertarCliente(cliente5);

            System.out.println("Clientes insertados");

        } catch (Exception e) {
        }

        Long clienteId = 1L;
        Cliente clienteRecuperado = clienteDAO.getCliente(clienteId);
        System.out.println("Cliente recuperado por ID " + clienteId + ": " + clienteRecuperado);

        Long cantidadMejoresClientes = 5L;
        System.out.println("Los mejores clientes:");
        clienteDAO.listarMejoresClientes(cantidadMejoresClientes);

        clienteDAO.estadisticas();
    }
}
