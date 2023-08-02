package ups.edu.ec.ProyectoFinal.datos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import ups.edu.ec.ProyectoFinal.modelo.DetalleFactura;

//@Stateless
public class DetalleFacturaDAO {
	/*
	@PersistenceContext
    private EntityManager em;

    public void insert(DetalleFactura detalleFactura) {
        em.persist(detalleFactura);
    }

    public void update(DetalleFactura detalleFactura) {
        em.merge(detalleFactura);
    }

    public DetalleFactura read(int numero) {
        DetalleFactura df = em.find(DetalleFactura.class, numero);
		return df;
    }

    public void delete(int numero) {
    	DetalleFactura df = em.find(DetalleFactura.class, numero);
        em.remove(df);
    }

    public List<DetalleFactura> getAll() {
        String jpql = "SELECT df FROM DetalleFactura df";
        return em.createQuery(jpql, DetalleFactura.class).getResultList();
    }
    */
}