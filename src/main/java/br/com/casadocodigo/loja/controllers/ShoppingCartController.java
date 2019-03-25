package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.modelo.Produto;
import br.com.casadocodigo.loja.modelo.ShoppingCart;
import br.com.casadocodigo.loja.modelo.ShoppingItem;
import br.com.casadocodigo.loja.modelo.TipoDeLivro;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(Integer idDoProduto, TipoDeLivro tipoDeLivro) {
		ShoppingItem item = createItem(idDoProduto, tipoDeLivro);
		shoppingCart.add(item);
		return new ModelAndView("redirect:/produtos");
	}

	private ShoppingItem createItem(Integer idDoProduto, TipoDeLivro tipoDeLivro) {
		Produto produto = produtoDAO.find(idDoProduto);
		ShoppingItem item = new ShoppingItem(produto, tipoDeLivro);
		return item;
	}
}
