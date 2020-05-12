package com.avs.lojainfo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.avs.lojainfo.domain.interfaces.services.ICategoriaService;
import com.avs.lojainfo.domain.interfaces.services.IProdutoService;
import com.avs.lojainfo.domain.model.Categoria;
import com.avs.lojainfo.domain.model.Produto;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	//private IBaseService<Categoria, Integer> categoriaService;
	private ICategoriaService _categoriaService;

	@Autowired
	//private IBaseService<Produto, Integer> produtoService;
	private IProdutoService _produtoService;

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

	}

}
