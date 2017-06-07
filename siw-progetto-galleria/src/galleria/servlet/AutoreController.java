package galleria.servlet;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.model.Autore;
import galleria.service.AutoreService;

@ManagedBean(name="autoreController")
public class AutoreController {
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	@EJB(beanName="autoreService")
	private AutoreService autoreService;
	
	public String inserisciAutore() {
		autoreService.inserisciAutore(nome,cognome,nazionalita,dataNascita,dataMorte);
		return "autore";
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