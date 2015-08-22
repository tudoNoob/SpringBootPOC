package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {

	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping("/home")
	public String helloWorld(){
		
		return "index";
	}
	
	@ModelAttribute("listaPessoa")
	public List<Pessoa> findAllPessoas(){
		return (List<Pessoa>) repository.findAll();
	}
	
	
	
	
	
}
