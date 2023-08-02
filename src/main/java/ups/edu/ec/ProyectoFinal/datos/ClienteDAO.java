package ups.edu.ec.ProyectoFinal.datos;
import ups.edu.ec.ProyectoFinal.modelo.Cliente;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente read(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		return c;
	}
	
	public void delete(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		em.remove(c);
	}
	
	public void deleteCliente(Cliente c) {
		Cliente cliente = em.find(Cliente.class, c.getCedula());
		if(cliente != null) {
			em.remove(cliente);
		}else {
			throw new IllegalArgumentException("No se encontro id" + c.getCedula());
		}
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql);
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
}
