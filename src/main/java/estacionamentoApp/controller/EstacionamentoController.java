package estacionamentoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import estacionamentoApp.model.Estacionamento;
import estacionamentoApp.model.Veiculo;
import estacionamentoApp.repository.EstacionamentoRepository;
import estacionamentoApp.repository.VeiculoRepository;

@Controller
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository er;
	
	@Autowired
	private VeiculoRepository vr;
	

	@RequestMapping(value="/cadastrarEstacionamento", method=RequestMethod.GET)
	public String form() {
		return "estacionamento/formEstacionamento";
	}
	
	@RequestMapping(value="estacionamento/{id}", method=RequestMethod.POST)
	public String form(Estacionamento estacionamento) {
		er.save(estacionamento);
		return "redirect:/cadastrarEstacionamento";
	}

	@RequestMapping(value="/estacionamentos")
	public ModelAndView listaEstacionamentos() {
		ModelAndView mv = new ModelAndView("lEstacionamentos");
		Iterable<Estacionamento> estacionamentos = er.findAll();
		mv.addObject("estacionamentos", estacionamentos);
		return mv;
	}
	
	@RequestMapping(value="/{Id}", method = RequestMethod.GET)
	public ModelAndView detalhesEstacionamentos(@PathVariable("Id") long Id) {
		Estacionamento estacionamento = er.findById(Id);
		ModelAndView mv = new ModelAndView("estacionamento/detalhesEstacionamento");
		mv.addObject("estacionamento", estacionamento);
		return mv;
	}
	
	@RequestMapping(value="/{Id}", method = RequestMethod.POST)
	public String detalhesEstacionamentos(@PathVariable("Id") long Id, Veiculo veiculo) {
		Estacionamento estacionamento = er.findById(Id);
		veiculo.setEstacionamento(estacionamento);
		vr.save(veiculo);
		//attributes.addFlashAttribute("mensagem", "Estacionamento adicionado com sucesso");
		return "redirect:/{Id}";
	}
	
	public EstacionamentoRepository getEr() {
		return er;
	}

	public void setEr(EstacionamentoRepository er) {
		this.er = er;
	}
}
