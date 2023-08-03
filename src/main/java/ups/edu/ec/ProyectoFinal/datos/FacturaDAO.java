package ups.edu.ec.ProyectoFinal.datos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import ups.edu.ec.ProyectoFinal.modelo.Cliente;
import ups.edu.ec.ProyectoFinal.modelo.Factura;

@Stateless
public class FacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Factura factura) {
        em.persist(factura);
    }

    public void update(Factura factura) {
        em.merge(factura);
    }

    public Factura read(int numero) {
        Factura f = em.find(Factura.class, numero);
		return f;
    }

    public void delete(int numero) {
        Factura f = em.find(Factura.class, numero);
        em.remove(f);
    }
    
    public void deleteFactura(Factura c) {
		Cliente cliente = em.find(Cliente.class, c.getNumero());
		if(cliente != null) {
			em.remove(cliente);
		}else {
			throw new IllegalArgumentException("No se encontro id" + c.getNumero());
		}
	}

    public List<Factura> getAll() {
        String jpql = "SELECT f FROM Factura f";
        return em.createQuery(jpql, Factura.class).getResultList();
    }
}
