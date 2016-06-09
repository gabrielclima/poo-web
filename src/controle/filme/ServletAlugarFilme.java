package controle.filme;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.FilmeDAO;
import modelo.dao.LocacaoDAO;
import modelo.dominio.Cliente;
import modelo.dominio.Filme;
import modelo.dominio.Locacao;

/**
 * Servlet implementation class ServletAlugarFilme
 */
@WebServlet("/alugarFilme")
public class ServletAlugarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlugarFilme() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String registro = request.getParameter("registro");
		
		HttpSession session = request.getSession(true);
		Cliente cliente = (Cliente) session.getAttribute("usuario");
				
		FilmeDAO dao = new FilmeDAO();
		Filme filme = dao.lerPorId(registro);
		
		Locacao locacao = new Locacao(cliente, filme);		
		LocacaoDAO locacaoDao = new LocacaoDAO();
		locacaoDao.salvar(locacao);			
		
		request.setAttribute("filme", filme);
		
		request.getRequestDispatcher("filme/confirmacao-aluguel-filme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
