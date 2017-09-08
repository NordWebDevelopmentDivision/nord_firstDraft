package is.nord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** Höfundar:
 *      Kári Snær Kárason (ksk12@hi.is),
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 *      Stella Rut Guðmundsdóttir (srg30@hi.is)
 * Ath. skrifað eftir fyrirlestri hjá Ebbu Þóru 31. ágúst 2017.
 */

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun.
 */

@Controller
@RequestMapping("/") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /news fyrir allar skipanir
public class NewsController {

    @RequestMapping("/")
    public String showNews () {
        return "news/index";
    }

    @RequestMapping("/makeNews")
    public String makeNews () { return "news/makeNews";}

    @RequestMapping(value="/addNews", method= RequestMethod.POST)
    public String addNews (@RequestParam(value="titill", required=false) String titill,
                           @RequestParam(value="meginmal", required=false) String meginmal,
                           ModelMap model) {
        model.addAttribute("titill", titill);
        model.addAttribute("meginmal", meginmal);
        return "news/index";
    }
}
