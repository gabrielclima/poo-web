package controle.filme;

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

import modelo.dao.FilmeDAO;
import modelo.dominio.Filme;

/**
 * Servlet implementation class ServletSalvarFilme
 */
@WebServlet(name = "salvarFilme", urlPatterns = { "/salvarFilme" })
public class ServletSalvarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeFilme 		= request.getParameter("nomeFilme");
		String descricao 		= request.getParameter("descricao");
		String dataLancamento 	= request.getParameter("data");
		String categoria 		= request.getParameter("categoria");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date data;
		
		try {
			data = format.parse(dataLancamento);
		} catch (ParseException e) {	
			data = null;
		}
		
		Filme filme = new Filme(nomeFilme, descricao, data, categoria);
		boolean dadosOK = true;
		String pagina = null;
		String mensagem = null;
		
//		// TESTAR VALIDAÇÕES
//		if (data == null)
//		{
//			dadosOK = false;
//			mensagem = "A data de nascimento é inválida.";
//		}
//		else
//		if ((email == null) || (email.length() < 7))
//		{
//			dadosOK = false;
//			mensagem = "O e-mail é inválido.";
//		}
		
		if (dadosOK)
		{
			pagina = "filme/confirmacao-registro-filme.jsp";
			FilmeDAO dao = new FilmeDAO();
			
			dao.alterar(filme);
		}
		else
		{
			pagina = "filme/cadastro-filmes.jsp";
		}
		
		request.setAttribute("filme", filme);
		request.setAttribute("mensagem", mensagem);

		RequestDispatcher disp = request.getRequestDispatcher(pagina);

		disp.forward(request, response);
	}
}
