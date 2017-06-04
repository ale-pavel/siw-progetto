package galleria.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.model.Autore;
import galleria.model.Quadro;
import galleria.service.AutoreService;

@ManagedBean(name="autoreController")
public class AutoreController {

	private Long id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	private Autore autoreCorrente;
	private List<Quadro> quadri;

	@EJB(beanName="autoreService")
	private AutoreService autoreService;
	
	public String inserisciAutore() {
		Autore a = new Autore();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setNazionalita(nazionalita);
		a.setDataNascita(dataNascita);
		a.setDataMorte(dataMorte);
		a.setQuadri(new ArrayList<Quadro>());
		autoreCorrente = autoreService.inserisciAutore(a);
		return "autore";
	}
	public Autore getAutoreCorrente() {
		return autoreCorrente;
	}
	public void setAutoreCorrente(Autore autoreCorrente) {
		this.autoreCorrente = autoreCorrente;
	}
	public AutoreService getAutoreService() {
		return autoreService;
	}
	public Long getId() {
		return id;
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
	public List<Quadro> getQuadri() {
		return quadri;
	}
	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}
}