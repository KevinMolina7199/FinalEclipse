package ups.edu.ec.ProyectoFinal.datos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import ups.edu.ec.ProyectoFinal.modelo.Cliente;
import ups.edu.ec.ProyectoFinal.modelo.Vehiculo;

@Stateless
public class VehiculoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		return v;
	}
	
	public void delete(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		em.remove(v);
	}
	
	public void deleteVehiculo(Vehiculo v) {
		Vehiculo cliente = em.find(Vehiculo.class, v.getPlaca());
		if(cliente != null) {
			em.remove(cliente);
		}else {
			throw new IllegalArgumentException("No se encontro id" + v.getPlaca());
		}
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT v FROM Vehiculo v";
		return em.createQuery(jpql, Vehiculo.class).getResultList();
	}
}
