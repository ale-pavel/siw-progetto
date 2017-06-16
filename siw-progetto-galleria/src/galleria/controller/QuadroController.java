package galleria.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import galleria.model.Quadro;
import galleria.service.QuadroService;

@ManagedBean(name="quadroController")
public class QuadroController{
	private String titolo;
	private Integer anno;
	private String tecnica;
	private String dimensioni;
	private Long idAutore;
	//"File" (di tipo Part) ottenuto dal form inserimentoQuadro.jsf mediante h:inputFile
	private Part imgFile;
	private byte[] imgFileByte;
	private Quadro quadroCorrente;
	private String nomeQuadro;
	@EJB(beanName="quadroService")
	private QuadroService quadroService;
	private Map<String,Object> attributiSessione = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public String inserisciQuadro() {
		Quadro q = new Quadro(titolo, anno, tecnica, dimensioni);
		q.setImgFile(this.getImgFromPart(imgFile));
		quadroCorrente = quadroService.inserisciQuadro(q, idAutore);
		return "/faces/quadro.jsf";
	}

	private byte[] getImgFromPart(Part imgPart) {
		byte[] imgByte;
		try {
			InputStream is = imgPart.getInputStream();
			byte[] buffer = new byte[(int)imgPart.getSize()];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			for (int length=0;(length=is.read(buffer))>0;) 
				output.write(buffer,0,length);
			imgByte = output.toByteArray();
		} catch (IOException | NullPointerException e) {	//Nel caso in cui l'immagine non viene inserita
			imgByte = new byte[0];
		}
		return imgByte;
	}

	public String rimuoviQuadro(Long id) {
		quadroService.rimuoviQuadro(id);
		return "/protetto/gestioneQuadri.jsf";
	}

	public String visualizzaQuadroCorrente(Long id) {
		quadroCorrente = quadroService.ottieniQuadro(id);
		return "/faces/quadro.jsf";
	}
	public String predisponiModificaQuadro(Long id){
		quadroCorrente = quadroService.ottieniQuadro(id);
		attributiSessione.put("quadroTemp", quadroCorrente);
		return "/protetto/modificaQuadro.jsf";
	}

	public String modificaQuadro(Quadro quadroTemp){
		byte[] imgForm = this.getImgFromPart(imgFile);
		if(imgForm.length > 0)	//Se la lunghezza è > 0 vuol dire che è stata caricata una nuova immagine, da sostituire a quella in Quadro
			quadroTemp.setImgFile(imgForm);
		quadroService.aggiornaQuadro(quadroTemp, idAutore);
		attributiSessione.remove("quadroTemp");
		return "/protetto/gestioneQuadri.jsf";
	}

	public List<Quadro> listaQuadri() {
		return quadroService.listaQuadri();
	}
	
	public String getNomeQuadro() {
		return nomeQuadro;
	}

	public void setNomeQuadro(String nomeQuadro) {
		this.nomeQuadro = nomeQuadro;
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
