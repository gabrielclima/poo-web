package controle.gerente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.FilmeDAO;
import modelo.dao.GerenteDAO;
import modelo.dominio.Filme;
import modelo.dominio.Gerente;

/**
 * Servlet implementation class ServletAbrirCadastro
 */
@WebServlet("/exibirCadastroGerentes")
public class ServletExibirCadastroGerentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExibirCadastroGerentes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GerenteDAO dao = new GerenteDAO();
		java.util.List<Gerente> lista = dao.lerTodos();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("gerente/cadastro-gerentes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
