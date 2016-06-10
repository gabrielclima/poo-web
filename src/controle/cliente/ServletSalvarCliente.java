package controle.cliente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDAO;
import modelo.dao.GerenteDAO;
import modelo.dominio.Cliente;
import modelo.dominio.Gerente;

/**
 * Servlet implementation class ServletRegistrarUsuario
 */
@WebServlet("/salvarCliente")
public class ServletSalvarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendError(403, "Acesso Negado!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login 			= request.getParameter("login");
		String nome 			= request.getParameter("nome");
		String senha 			= request.getParameter("senha");
		String senhaConf 		= request.getParameter("senhaConf");
		String cpf 				= request.getParameter("cpf");
		String dataNascimento 	= request.getParameter("dataNascimento");
		
		boolean dadosOK = true;
		String pagina = null;
		String mensagem = null;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date data;
		
		if (dadosOK) {
			ClienteDAO clienteDao = new ClienteDAO();
			Cliente cliente = clienteDao.obterPorLogin(login);
			
			if (cliente != null) {
				dadosOK = false;
				mensagem = "Já temos um cliente com esse login!";
			}
		}		
		
		try {
			data = format.parse(dataNascimento);
		} catch (ParseException e) {
			data = null;
		}
		
		if (!senha.equals(senhaConf)) {
			dadosOK = false;
			mensagem = "As senhas devem ser iguais.";
		}
		
		if (dadosOK){
			Cliente cliente = new Cliente();
			cliente.setLogin(login);
			cliente.setSenha(senhaConf);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setDataNascimento(data);
			
			pagina = "cliente/confirmacao-registro-admin-cliente.jsp";
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			request.setAttribute("cliente", cliente);
		}
		else{
			pagina = "cliente/registrar-cliente.jsp";
		}
		
		request.setAttribute("mensagem", mensagem);

		RequestDispatcher disp = request.getRequestDispatcher(pagina);

		disp.forward(request, response);
	}
	
}
