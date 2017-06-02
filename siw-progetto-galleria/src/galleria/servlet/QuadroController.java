package galleria.servlet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.model.Autore;
import galleria.model.Quadro;
import galleria.service.QuadroService;

@ManagedBean(name="quadroController")
public class QuadroController{
	
	private Long id;
	private String titolo;
	private String anno;
	private String tecnica;
	private String dimensioni;
	private Autore autore;	
	private Quadro quadroCorrente;
	@EJB(beanName="quadroService")
	private QuadroService quadroService;
	
	public String inserisciQuadro() {
		Quadro q = new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
		//q.setAutore(autore);
		quadroCorrente = quadroService.inserisciQuadro(q);
		return "quadro";
	}
	
	public String getTitolo() {
		return titolo;
	}

	public String getAnno() {
		return anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public Long getId() {
		return id;
	}

	public Autore getAutore() {
		return autore;
	}

	public QuadroService getQuadroService() {
		return quadroService;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public void setQuadroService(QuadroService quadroService) {
		this.quadroService = quadroService;
	}
	
}
