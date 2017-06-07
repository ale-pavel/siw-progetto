package galleria.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quadro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titolo;
	private Integer anno;
	private String tecnica;
	private String dimensioni;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="autoreId")
	private Autore autore;
	
	public Quadro() {}
	
	public Long getId() {
		return id;
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
	public Autore getAutore() {
		return autore;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
}
