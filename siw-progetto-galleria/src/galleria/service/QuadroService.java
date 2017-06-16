package galleria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import galleria.model.*;

@Stateless(name="quadroService")
public class QuadroService {
	
	@PersistenceContext(unitName = "siw-progetto-galleria")
    private EntityManager em;
	
	public Quadro inserisciQuadro(Quadro q, Long idAutore) {
		q.setAutore(em.find(Autore.class, idAutore));
		em.persist(q);
		return q;
	}
	
	public void rimuoviQuadro(Long id) {
		Quadro q = em.find(Quadro.class, id);
		em.remove(q);
	}
	
	public Quadro ottieniQuadro(Long id) {
		return em.find(Quadro.class, id);
	}

	public List<Quadro> listaQuadri() {
		TypedQuery<Quadro> query = em.createQuery("SELECT a FROM Quadro a",Quadro.class);
		return query.getResultList();
	}
	
	public void aggiornaQuadro(Quadro quadroTemp, Long idAutore) {
		quadroTemp.setAutore(em.find(Autore.class, idAutore));
		em.merge(quadroTemp);
	}

	public List<Quadro> listaQuadriNome(String nome) {
		TypedQuery<Quadro> query = em.createQuery("SELECT a FROM Quadro a WHERE a.titolo like '%"+nome+"%'",Quadro.class);
		return query.getResultList();
	}

}
