package Garipov.traffic.op.Controllers;

import Garipov.traffic.op.Repositiry.NumberRepository;
import Garipov.traffic.op.Service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private NumberService numberService;


    @Autowired
    private NumberRepository numberRepository;

    @Autowired
    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }
    // спустившись чуть ниже есть Get-запросы с html)
    //   http://localhost:3081/number/next    или с html:    http://localhost:3081/number/html/next
    @GetMapping("/next")
    @ResponseBody
    public String nextNumber() {
        return numberService.addNextNumber();
    }

    //   http://localhost:3081/number/random   или с html:    http://localhost:3081/number/html/random
    @GetMapping("/random")
    @ResponseBody
    public String randomNumber() {
        return numberService.addRandomNumber();
    }

    //   http://localhost:3081/number//all или с html:    http://localhost:3081/number/html/all
    @GetMapping("/all")
    @ResponseBody
    public String allNumbers() {
        return numberService.getNumbers().toString();
    }


    //   http://localhost:3081/number/home
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/html/next")
    public String nextNumberPage(Model model) {
        model.addAttribute("number", numberService.addNextNumber());
        model.addAttribute("numbers", numberRepository.getNumbers());
        return "nextNumber";
    }

    @GetMapping("/html/random")
    public String randomNumberPage(Model model) {
        model.addAttribute("number", numberService.addRandomNumber());
        model.addAttribute("numbers", numberRepository.getNumbers());
        return "randomNumber";
    }

    @GetMapping("/html/all")
    public String allNumbersPage(Model model) {
        model.addAttribute("numbers", numberService.getNumbers());
        return "allNumbers";
    }
}