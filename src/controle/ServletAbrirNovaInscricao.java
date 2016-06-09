package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Concurso;
import modelo.dao.ConcursoDAO;

/**
 * Servlet implementation class ServletAbrirNovaInscricao
 */
@WebServlet("/abrirNovaInscricao")
public class ServletAbrirNovaInscricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirNovaInscricao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConcursoDAO dao = new ConcursoDAO();
		List<Concurso> lista = dao.obterConcursos();
		request.setAttribute("lista", lista);
		
		// FAZER A TRANSI��O PARA A P�GINA
		request.getRequestDispatcher("inscricao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
		// response.sendError(403, "Acesso via POST n�o permitido.");
	
	}

}
