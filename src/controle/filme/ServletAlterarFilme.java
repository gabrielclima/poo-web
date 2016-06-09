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
@WebServlet(name = "alterarFilme", urlPatterns = { "/alterarFilme" })
public class ServletAlterarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarFilme() {
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
		String dataLancamento 	= request.getParameter("dataLancamento");
		String categoria 		= request.getParameter("categoria");
		String registro			= request.getParameter("registro");

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date data;
		
		try {
			data = format.parse(dataLancamento);
		} catch (ParseException e) {
			data = null;
		}
		
		FilmeDAO filmeDao = new FilmeDAO();
		Filme filme = filmeDao.lerPorId(registro);
		filme.setNomeFilme(nomeFilme);
		filme.setDescricao(descricao);
		filme.setDataLancamento(data);
		filme.setCategoria(categoria);
		
		filmeDao.alterar(filme);
		request.setAttribute("filme", filme);
		
		request.getRequestDispatcher("filme/confirmacao-alteracao-filme.jsp").forward(request, response);
	}
}
