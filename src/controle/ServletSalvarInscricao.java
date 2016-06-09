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
@WebServlet("/salvarInscricao")
public class ServletSalvarInscricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarInscricao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "M�todo salvar n�o pode ser executado sem o envio dos dados. Por favor preenche o formul�rio novamente");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean dadosOK = true;
		String mensagem = null;
		
		// TODO necess�rio fazer as valida��es
		String codigoConcurso = request.getParameter("codigoConcurso");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("nascimento");
		Date data = null;
		
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = formatar.parse(nascimento);
		} catch (ParseException e) {
			data = null;
		}
		
		InscricaoDAO daoInscricao = new InscricaoDAO();
		
		ConcursoDAO daoConcurso = new ConcursoDAO();
		Concurso concurso = null;
		
		try {
			Integer idConcurso = Integer.parseInt(codigoConcurso);
			concurso = daoConcurso.lerPorId(idConcurso);
		} catch (NumberFormatException e) {
			concurso = null;
		}
		
		Inscricao inscricao = new Inscricao();
		inscricao.setNome(nome);
		inscricao.setCpf(cpf);
		inscricao.setNascimento(data);
		inscricao.setConcurso(concurso);
		
		if ((nome == null) || (nome.equals("")) )
		{
			dadosOK=  false;
			mensagem = "O campo NOME � obrigat�rio.";
		}
		else
		if (data == null)
		{
			dadosOK=  false;
			mensagem = "O campo DATA � inv�lido.";
		}
		else
		{
			// verifica se j� existe este CPF para o concurso
			Inscricao existente = daoInscricao.lerPorCpfConcurso(cpf, concurso);
			if (existente != null)
			{
				dadosOK = false;
				mensagem = "J� existe uma inscri��o com este CPF para este Concurso!";
			}
		}

		request.setAttribute("mensagem", mensagem);

		List<Concurso> lista = daoConcurso.obterConcursos();
		request.setAttribute("lista", lista);

		// FAZER A TRANSI��O PARA A P�GINA
		if (dadosOK)
		{
			// INCLUIR O OBJETO NO BANCO
			Inscricao outra = daoInscricao.salvar(inscricao);
			// ATUALIZAR A REFER�NCIA
			inscricao = outra;
			
			request.setAttribute("inscricao", inscricao);
			request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("inscricao", inscricao);
			request.getRequestDispatcher("inscricao.jsp").forward(request, response);
		}
	}

}
