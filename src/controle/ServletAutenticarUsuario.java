package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.ClienteDAO;
import modelo.dao.GerenteDAO;

/**
 * Servlet implementation class ServletAutenticar
 */
@WebServlet("/autenticar")
public class ServletAutenticarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticarUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "ACESSO NEGADO");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Object user = null;
		
		if(!login.equals("") && login != null){
			ClienteDAO clienteDao = new ClienteDAO();
			user = clienteDao.obterPorLogin(login);
			
			if (user == null){				
				GerenteDAO gerenteDao = new GerenteDAO();
				user = gerenteDao.obterPorLogin(login);
			}
		}
		
		if (user == null){
			request.setAttribute("mensagem", "Usuário não existe.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if (senha != "" && senha != null){
			
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", user);
			
			if (user.getClass().getSimpleName().equals("Gerente")) {				
				request.getRequestDispatcher("painel-admin.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("exibirCatalogo").forward(request, response);
			}
		}
		else{
			request.setAttribute("mensagem", "Login ou Senha inválida.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}











