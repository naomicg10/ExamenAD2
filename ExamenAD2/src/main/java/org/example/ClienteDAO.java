package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente>{
    @Override
    public void insertarCliente(Cliente cliente) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Cliente getCliente(Long id) {
        Cliente cliente = null;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.id = :id", Cliente.class);
            query.setParameter("id", id);
            List<Cliente> resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                cliente = resultado.get(0);
            }
        } finally {
            em.close();
        }
        System.out.println(cliente);
        return cliente;
    }

    @Override
    public void listarMejoresClientes(Long cantidad) {
        List<Cliente> clientes = new ArrayList<>(0);

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.totalVentas > :totalVentas ORDER BY c.totalVentas DESC", Cliente.class);
            query.setParameter("totalVentas", 300L);
            clientes = query.getResultList();
        } finally {
            em.close();
        }

        System.out.println("Número de mejores clientes: " + clientes.size());
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void estadisticas(){
        List<Cliente> clientes = new ArrayList<>(0);

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Cliente> q = em.createQuery("select a from Cliente a", Cliente.class);
        clientes = q.getResultList();

        long totalVentas = 0;

        for (Cliente cliente : clientes) {
            totalVentas += cliente.getTotalVentas();
        }

        System.out.println("Total de ventas entre todos los clientes: " + totalVentas);

        long totalVentasActivos = 0;
        int cantidadClientesActivos = 0;

        for (Cliente cliente : clientes) {
            if (cliente.getEstado()==true) {
                totalVentasActivos += cliente.getTotalVentas();
                cantidadClientesActivos++;
            }
        }

        double promedioVentasActivos = 0.0;
        if (cantidadClientesActivos > 0) {
            promedioVentasActivos = (double) totalVentasActivos / cantidadClientesActivos;
        }

        System.out.println("Promedio de ventas de los clientes activos: " + promedioVentasActivos);

        int cantidadClientesInactivosVentasPositivas = 0;

        for (Cliente cliente : clientes) {
            if (!cliente.getEstado()==true && cliente.getTotalVentas() > 0) {
                cantidadClientesInactivosVentasPositivas++;
            }
        }

        System.out.println("Cantidad de clientes inactivos con ventas mayores a 0: " + cantidadClientesInactivosVentasPositivas);
    }

}
