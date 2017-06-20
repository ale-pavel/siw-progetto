package galleria.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import galleria.model.Quadro;
import galleria.service.AutoreService;
import galleria.service.QuadroService;

@ManagedBean(name="queryController")
public class QueryController {
	private String quadroCercato;
	private String autoreCercato;
	@EJB(beanName="quadroService")
	private QuadroService quadroService;
	@EJB(beanName="autoreService")
	private AutoreService autoreService;

	public List<Quadro> listaQuadriQuery() {
		List<Quadro> result;
		if (quadroCercato!=null && autoreCercato==null) {
			result = quadroService.queryQuadriNome(quadroCercato);
		} else if (autoreCercato!=null && quadroCercato==null) {
			result = quadroService.queryQuadriAutore(autoreCercato);
		} else
			result = quadroService.listaQuadri();
		return result;
	}

	public String getQuadroCercato() {
		return quadroCercato;
	}

	public String getAutoreCercato() {
		return autoreCercato;
	}

	public QuadroService getQuadroService() {
		return quadroService;
	}

	public AutoreService getAutoreService() {
		return autoreService;
	}

	public void setQuadroCercato(String quadroCercato) {
		this.quadroCercato = quadroCercato;
	}

	public void setAutoreCercato(String autoreCercato) {
		this.autoreCercato = autoreCercato;
	}

	public void setQuadroService(QuadroService quadroService) {
		this.quadroService = quadroService;
	}

	public void setAutoreService(AutoreService autoreService) {
		this.autoreService = autoreService;
	}

}
