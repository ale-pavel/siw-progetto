package galleria.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import galleria.model.Quadro;
import galleria.service.QuadroService;
@SessionScoped
@ManagedBean(name="quadroController")
public class QuadroController{
	private Long id;
	private String titolo;
	private Integer anno;
	private String tecnica;
	private String dimensioni;
	//Id dell'autore scelto tra quelli esistenti nella checklist, di default è vuoto nel form
	private Long idAutore;
	//"File" (di tipo Part) ottenuto dal form inserimentoQuadro.jsf mediante h:inputFile
	private Part imgFile;
	private byte[] imgFileByte;

	@EJB(beanName="quadroService")
	private QuadroService quadroService;
	//Utilizzato per mostrare il quadro desiderato (mediante visualizzaQuadroCorrente) sulla pagina quadro.jsf, e dopo l'inserimento nel db in automatico
	private Quadro quadroCorrente;

	public String inserisciQuadro() {
		Quadro q = new Quadro();
		q.setTitolo(titolo);
		q.setAnno(anno);
		q.setTecnica(tecnica);
		q.setDimensioni(dimensioni);
		//Conversione di imgFile da Part a byte[] per l'inserimento nel db (Postgres)
		//byte[] img = new byte[(int)imgFile.getSize()];
		try {
			InputStream is = imgFile.getInputStream();
			byte[] buffer = new byte[(int)imgFile.getSize()];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			for (int length=0;(length=is.read(buffer))>0;) 
				output.write(buffer,0,length);
			q.setImgFile(output.toByteArray());
		} catch (IOException | NullPointerException e) {
			return "inserimentoQuadro.jsf";
		}	
		//Try - catch da sistemare in modo ottimale, comunque funzionante
		quadroCorrente = quadroService.inserisciQuadro(q, idAutore);
		return "quadro.jsf";
	}

	public String rimuoviQuadro(Long id) {
		quadroService.rimuoviQuadro(id);
		return "modificaPaginaQuadro.jsf";
	}

	public String visualizzaQuadroCorrente(Long id) {
		quadroCorrente = quadroService.ottieniQuadro(id);
		return "quadro.jsf";
	}
	public String modificaPaginaQuadro(Long id){
		quadroCorrente=quadroService.ottieniQuadro(id);
		this.id=quadroCorrente.getId();
		
		titolo=quadroCorrente.getTitolo();
		anno=quadroCorrente.getAnno();
		tecnica=quadroCorrente.getTecnica();
		dimensioni=quadroCorrente.getDimensioni();
		imgFileByte=quadroCorrente.getImgFile();
		idAutore=quadroCorrente.getAutore().getId();
		return "modificaQuadro.jsf";
	}
	public String modificaQuadro(Long id){
		quadroService.rimuoviQuadro(id);
		if(imgFile==null){
			Quadro q = new Quadro();
			q.setTitolo(titolo);
			q.setAnno(anno);
			q.setTecnica(tecnica);
			q.setDimensioni(dimensioni);
			q.setImgFile(imgFileByte);
			quadroCorrente = quadroService.inserisciQuadro(q, idAutore);
		}
		else{
			inserisciQuadro();
		}
		return "quadro.jsf";
	}

	public List<Quadro> listaQuadri() {
		return quadroService.listaQuadri();
	}

	public Part getImgFile() {
		return imgFile;
	}

	public void setImgFile(Part imgFile) {
		this.imgFile = imgFile;
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

	public byte[] getImgFileByte() {
		return imgFileByte;
	}

	public void setImgFileByte(byte[] imgFileByte) {
		this.imgFileByte = imgFileByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Quadro getQuadroCorrente() {
		return quadroCorrente;
	}

	public void setQuadroCorrente(Quadro quadroCorrente) {
		this.quadroCorrente = quadroCorrente;
	}

}
