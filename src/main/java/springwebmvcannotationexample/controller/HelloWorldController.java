package springwebmvcannotationexample.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 

 
@Controller
public class HelloWorldController {
 
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public ModelAndView greetings() {
		String model = "Hello How are you All ?";
		ModelAndView mv = new ModelAndView();
		mv.addObject("model",model);// setting data model
		mv.setViewName("greeting"); // name of the jsp is greeting.jsp
		return mv;
	}
}
 