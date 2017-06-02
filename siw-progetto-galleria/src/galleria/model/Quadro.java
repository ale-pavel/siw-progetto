package galleria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quadro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titolo;
	private String anno;
	private String tecnica;
	private String dimensioni;
	@ManyToOne
	private Autore autore;
	
	public Quadro() {}
	
	public Long getId() {
		return id;
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
	public Autore getAutore() {
		return autore;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
