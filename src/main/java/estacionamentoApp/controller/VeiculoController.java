package estacionamentoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import estacionamentoApp.model.Veiculo;
import estacionamentoApp.repository.VeiculoRepository;

/**
 * @author Giovane
 *
 */
@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository vr;

	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.GET)
	public String form() {
		return "veiculo/formVeiculo";
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.POST)
	public String form(Veiculo veiculo) {
		vr.save(veiculo);
		return "redirect:/cadastrarVeiculo";
	}
	
	@RequestMapping("/veiculos")
	public ModelAndView listaVeiculos() {
		ModelAndView mv = new ModelAndView("lVeiculos");
		Iterable<Veiculo> veiculos = vr.findAll();
		mv.addObject("veiculos", veiculos);
		return mv;
	}

	/*	*/	
		
	  @RequestMapping(value="veiculo/{id}") 
	  public ModelAndView detalhesVeiculo(@PathVariable("id") long id){ 
		  Veiculo veiculo = vr.findById(id); 
		  ModelAndView mv = new ModelAndView("veiculo/detalhesVeiculo"); 
		  mv.addObject("veiculo", veiculo); 
		  return mv; 
	  }
 
	
	public VeiculoRepository getVr() {
		return vr;
	}

	public void setVr(VeiculoRepository vr) {
		this.vr = vr;
	}
}
