package galleria.servlet;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.omnifaces.cdi.GraphicImageBean;

import galleria.service.QuadroService;

@ManagedBean(name="imgLoad")
//Notazione omnifaces necessaria per poter usare o:graphicImage senza dataURI="true" (vedere quadro.jsf e listaQuadri.jsf)
@GraphicImageBean
@ApplicationScoped
public class ImageController {
	
	//Classe non necessaria del tutto potendo usare dataURI="true", dentro quadro.xhtml per ora è necessaria per evitare errori a runtime
	
	@EJB(beanName="quadroService")
	private QuadroService quadroService;

	public byte[] get(Long id) {
		byte[] b = quadroService.ottieniQuadro(id).getImgFile();
		return b;
	}
}
