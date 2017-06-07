package galleria.servlet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.service.QuadroService;

@ManagedBean(name="quadroController")
public class QuadroController{
	private String titolo;
	private Integer anno;
	private String tecnica;
	private String dimensioni;
	private Long idAutore;	
	@EJB(beanName="quadroService")
	private QuadroService quadroService;
	
	public String inserisciQuadro() {
		quadroService.inserisciQuadro(titolo,anno,tecnica,dimensioni,idAutore);
		return "quadro";
	}
	
	public String getTitolo() {
		return titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public QuadroService getQuadroService() {
		return quadroService;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Long getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}

	public void setQuadroService(QuadroService quadroService) {
		this.quadroService = quadroService;
	}
	
}
