package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.modelo.Produto;
import br.com.casadocodigo.loja.modelo.TipoDeLivro;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private FileSaver fileSaver;

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("/produtos/form");
		modelAndView.addObject("tipos", TipoDeLivro.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile sumario, @Valid Produto produto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(produto);
		}
		String webPath = fileSaver.write("uploaded-images", sumario);
		produto.setSummaryPath(webPath);
		produtoDAO.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method=RequestMethod.GET, value="/show")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("/produtos/list");
		modelAndView.addObject("produtos", produtoDAO.list());
		return modelAndView;
	}
	
	@RequestMapping("{/id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/produtos/show");
		Produto produto = produtoDAO.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}
}
