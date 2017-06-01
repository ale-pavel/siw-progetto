package galleria.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import galleria.model.*;

@Stateless(name="quadroService")
public class QuadroService {
	
	@PersistenceContext(unitName = "siw-progetto-galleria")
    private EntityManager em;

	public void inserisciQuadro(Quadro q) {
		
	}
	
	public void rimuoviQuadro(Long id) {
		
	}
	
}
