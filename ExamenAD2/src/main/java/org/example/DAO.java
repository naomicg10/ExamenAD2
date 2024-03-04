package org.example;

public interface DAO<T> {
    void insertarCliente(T t);
    Cliente getCliente(Long id);
    void listarMejoresClientes(Long cantidad);
}
