package ups.edu.ec.ProyectoFinal.datos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import ups.edu.ec.ProyectoFinal.modelo.Ticket;

@Stateless
public class TicketDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Ticket ticket) {
        em.persist(ticket);
    }

    public void update(Ticket ticket) {
        em.merge(ticket);
    }

    public Ticket read(int numero) {
        Ticket t = em.find(Ticket.class, numero);
		return t;
    }

    public void delete(int numero) {
        Ticket t = em.find(Ticket.class, numero);
        em.remove(t);
    }
    
    public void deleteTicket(Ticket v) {
    	Ticket tarifa = em.find(Ticket.class, v.getNumero());
		if(tarifa != null) {
			em.remove(tarifa);
		}else {
			throw new IllegalArgumentException("No se encontro id" + v.getNumero());
		}
	}

    public List<Ticket> getAll() {
        String jpql = "SELECT t FROM Ticket t";
        return em.createQuery(jpql, Ticket.class).getResultList();
    }
}
