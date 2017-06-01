package galleria.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import galleria.model.*;

@Stateless(name="autoreService")
public class AutoreService {
	
	@PersistenceContext(unitName = "siw-progetto-galleria")
    private EntityManager em;


	public void inserisciAutore(Autore a) {
		
	}
	
	public void rimuoviAutore(Long id) {
		
	}
	
}
