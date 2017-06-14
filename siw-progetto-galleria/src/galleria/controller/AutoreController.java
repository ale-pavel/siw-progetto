package galleria.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import galleria.model.Autore;
import galleria.service.AutoreService;

@ManagedBean(name="autoreController")
public class AutoreController {
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	private Autore autoreCorrente;
	@EJB(beanName="autoreService")
	private AutoreService autoreService;
	private Map<String,Object> attributiSessione = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	public String inserisciAutore() {
		autoreCorrente=autoreService.inserisciAutore(nome,cognome,nazionalita,dataNascita,dataMorte);
		return "/faces/autore.jsf";
	}
	
	public String rimuoviAutore(Long id) {
		autoreService.rimuoviAutore(id);
		return "/protetto/gestioneAutori.jsf";
	}
	
	public String predisponiModificaAutore(Long id){
		autoreCorrente = autoreService.ottieniAutore(id);
		attributiSessione.put("autoreTemp", autoreCorrente);
		return "/protetto/modificaAutore.jsf";
	}
	
	public String modificaAutore(Autore autoreTemp){
		autoreService.aggiornaAutore(autoreTemp);
		attributiSessione.remove("autoreTemp");
		return "/protetto/gestioneAutori.jsf";
	}
	
	public List<Autore> listaAutori() {
		return autoreService.listaAutori();
	}
	
	public AutoreService getAutoreService() {
		return autoreService;
	}
	
	public void setAutoreService(AutoreService autoreService) {
		this.autoreService = autoreService;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Autore getAutoreCorrente() {
		return autoreCorrente;
	}

	public void setAutoreCorrente(Autore autoreCorrente) {
		this.autoreCorrente = autoreCorrente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNazionalita() {
		return nazionalita;
	}
	
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public Date getDataMorte() {
		return dataMorte;
	}
	
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
}