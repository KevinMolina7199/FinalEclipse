package ups.edu.ec.ProyectoFinal.datos;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.ProyectoFinal.modelo.Tarifa;
import ups.edu.ec.ProyectoFinal.modelo.Ticket;


@Stateless
public class TarifaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Tarifa vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Tarifa vehiculo) {
		em.merge(vehiculo);
	}
	
	public Tarifa read(String id) {
		Tarifa t = em.find(Tarifa.class, id);
		return t;
	}
	
	public Tarifa readInt(int id) {
		Tarifa t = em.find(Tarifa.class, id);
		return t;
    }
	
	public void delete(String id) {
		Tarifa t = em.find(Tarifa.class, id);
		em.remove(t);
	}
	
	public void deleteTarifa(Tarifa v) {
		Tarifa tarifa = em.find(Tarifa.class, v.getId());
		if(tarifa != null) {
			em.remove(tarifa);
		}else {
			throw new IllegalArgumentException("No se encontro id" + v.getId());
		}
	}
	
	public List<Tarifa> getAll(){
		String jpql = "SELECT t FROM Tarifa t";
		return em.createQuery(jpql, Tarifa.class).getResultList();
	}
}
