package galleria.servlet;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.model.Autore;
import galleria.model.Quadro;
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
	
	public String inserisciAutore() {
		autoreService.inserisciAutore(nome,cognome,nazionalita,dataNascita,dataMorte);
		return "autore.jsf";
	}
	
	public String rimuoviAutore(Long id) {
		autoreService.rimuoviAutore(id);
		return "modificaPaginaAutore.jsf";
	}
	public String modificaPaginaAutore(Long id){
		autoreCorrente=autoreService.ottieniAutore(id);
		return "modificaAutore.jsf";
	}
	public String modificaAutore(Long id){
		autoreCorrente.setCognome(cognome);
		autoreCorrente.setDataMorte(dataMorte);
		autoreCorrente.setDataNascita(dataNascita);
		autoreCorrente.setNazionalita(nazionalita);
		autoreCorrente.setNome(nome);
		return "autore.jsf";
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