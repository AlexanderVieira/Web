package com.avs.lojainfo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avs.lojainfo.domain.model.Categoria;
import com.avs.lojainfo.domain.model.Cidade;
import com.avs.lojainfo.domain.model.Estado;
import com.avs.lojainfo.domain.model.Produto;
import com.avs.lojainfo.domain.services.interfaces.ICategoriaService;
import com.avs.lojainfo.domain.services.interfaces.ICidadeService;
import com.avs.lojainfo.domain.services.interfaces.IEstadoService;
import com.avs.lojainfo.domain.services.interfaces.IProdutoService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	//private IBaseService<Categoria, Integer> categoriaService;
	private ICategoriaService _categoriaService;

	@Autowired
	//private IBaseService<Produto, Integer> produtoService;
	private IProdutoService _produtoService;
	
	@Autowired
	private IEstadoService _estadoService;
	
	@Autowired
	private ICidadeService _cidadeService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria catInformatica = new Categoria(null, "Informática");
		Categoria catEscritorio = new Categoria(null, "Escritório");

		Produto prodNotebook = new Produto(null, "Notebook", 2980.00);
		Produto prodDesktop = new Produto(null, "Desktop", 1980.00);
		Produto prodTeclado = new Produto(null, "Teclado", 29.00);
		Produto prodMouse = new Produto(null, "Mouse", 15.00);
		Produto prodImpressora = new Produto(null, "Impressora", 989.00);

		catInformatica.getProdutos()
				.addAll(Arrays.asList(prodNotebook, prodDesktop, prodTeclado, prodMouse, prodImpressora));
		catEscritorio.getProdutos().addAll(Arrays.asList(prodImpressora));

		prodNotebook.getCategorias().addAll(Arrays.asList(catInformatica));
		prodDesktop.getCategorias().addAll(Arrays.asList(catInformatica));
		prodTeclado.getCategorias().addAll(Arrays.asList(catInformatica));
		prodMouse.getCategorias().addAll(Arrays.asList(catInformatica));
		prodImpressora.getCategorias().addAll(Arrays.asList(catInformatica, catEscritorio));

		_categoriaService.saveAll(Arrays.asList(catInformatica, catEscritorio));
		_produtoService.saveAll(Arrays.asList(prodNotebook, prodDesktop, prodTeclado, prodMouse, prodImpressora));
		
		Estado minasGerais = new Estado(null, "Minas Gerais");
		Estado saoPaulo = new Estado(null, "São Paulo");
		
		Cidade cidUberlandia = new Cidade(null, "Uberlândia", minasGerais);
		Cidade cidSaoPaulo = new Cidade(null, "São Paulo", saoPaulo);
		Cidade cidCampinas = new Cidade(null, "Campinas", saoPaulo);
		
		minasGerais.getCidades().addAll(Arrays.asList(cidUberlandia));
		saoPaulo.getCidades().addAll(Arrays.asList(cidSaoPaulo, cidCampinas));

		_estadoService.saveAll(Arrays.asList(minasGerais, saoPaulo));
		_cidadeService.saveAll(Arrays.asList(cidUberlandia, cidSaoPaulo, cidCampinas));

	}

}
