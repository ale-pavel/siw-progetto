package galleria.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import galleria.model.*;

@Stateless(name="autoreService")
public class AutoreService {
	
	@PersistenceContext(unitName = "siw-progetto-galleria")
    private EntityManager em;

	public Autore inserisciAutore(String nome, String cognome, String nazionalita, Date dataNascita, Date dataMorte) {
		Autore a = new Autore();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setNazionalita(nazionalita);
		a.setDataNascita(dataNascita);
		a.setDataMorte(dataMorte);
		em.persist(a);
		return a;
	}
	
	public void rimuoviAutore(Long id) {
		Autore a = em.find(Autore.class, id);
		em.remove(a);
	}
	public Autore ottieniAutore(Long id) {
		return em.find(Autore.class, id);
	}
	public List<Autore> listaAutori() {
		TypedQuery<Autore> query = em.createQuery("SELECT a FROM Autore a",Autore.class);
		return query.getResultList();
	}

	public void aggiornaAutore(Autore autoreTemp) {
		em.merge(autoreTemp);
	}
	
}
