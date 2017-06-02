package galleria.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import galleria.model.Quadro;
import galleria.service.AutoreService;

@ManagedBean("autoreController")
public class AutoreController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	private List<Quadro> quadri;

	@EJB(beanName="autoreService")
	private AutoreService autoreService;
	
}