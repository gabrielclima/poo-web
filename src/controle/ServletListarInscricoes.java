package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Concurso;
import modelo.Inscricao;
import modelo.dao.ConcursoDAO;
import modelo.dao.InscricaoDAO;

/**
 * Servlet implementation class ServletSalvarInscricao
 */
@WebServlet("/listarInscricoes")
public class ServletListarInscricoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarInscricoes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigoConcurso = request.getParameter("codigoConcurso");
		
		InscricaoDAO daoInscricao = new InscricaoDAO();
		
		ConcursoDAO daoConcurso = new ConcursoDAO();
		Concurso concurso = null;
		
		try {
			Integer idConcurso = Integer.parseInt(codigoConcurso);
			concurso = daoConcurso.lerPorId(idConcurso);
		} catch (NumberFormatException e) {
			concurso = null;
		}
		
		List<Concurso> lista = daoConcurso.obterConcursos();
		request.setAttribute("lista", lista);
		
		if (concurso != null)
		{
			List<Inscricao> inscricoes = daoInscricao.lerPorConcurso(concurso);
			request.setAttribute("inscricoes", inscricoes);
		}

		request.getRequestDispatcher("listar.jsp").forward(request, response);
	}

}
