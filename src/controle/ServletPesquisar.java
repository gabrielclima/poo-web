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
@WebServlet("/pesquisarInscricao")
public class ServletPesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "Método pesquisar não pode ser executado sem o envio dos dados. Por favor preenche o formulário novamente");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean dadosOK = true;
		String mensagem = null;
		
		String codigoConcurso = request.getParameter("codigoConcurso");
		String cpf = request.getParameter("cpf");
		
		InscricaoDAO daoInscricao = new InscricaoDAO();
		
		ConcursoDAO daoConcurso = new ConcursoDAO();
		Concurso concurso = null;
		
		try {
			Integer idConcurso = Integer.parseInt(codigoConcurso);
			concurso = daoConcurso.lerPorId(idConcurso);
		} catch (NumberFormatException e) {
			concurso = null;
		}
		
		// verifica se já existe este CPF para o concurso
		Inscricao existente = daoInscricao.lerPorCpfConcurso(cpf, concurso);
		if (existente == null)
		{
			dadosOK = false;
			mensagem = "Não existe uma inscrição com este CPF para este Concurso!";
		}

		request.setAttribute("mensagem", mensagem);

		List<Concurso> lista = daoConcurso.obterConcursos();
		request.setAttribute("lista", lista);

		// FAZER A TRANSIÇÃO PARA A PÁGINA
		if (dadosOK)
		{
			request.setAttribute("inscricao", existente);
			request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("pesquisa.jsp").forward(request, response);
		}
	}

}
