package galleria.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import galleria.model.*;

@Stateless(name="quadroService")
public class QuadroService {
	
	@PersistenceContext(unitName = "siw-progetto-galleria")
    private EntityManager em;
	
	public Quadro inserisciQuadro(String titolo, Integer anno, String tecnica, String dimensioni, Long idAutore) {
		Quadro q = new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
		q.setAutore(em.find(Autore.class, idAutore));
		em.persist(q);
		return q;
	}
	
	public void rimuoviQuadro(Long id) {
		
	}

}
