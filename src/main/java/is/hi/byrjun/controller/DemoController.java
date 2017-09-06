package is.hi.byrjun.controller;

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
@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir 
public class DemoController {

    /**
     * Fallið sér um að birta hvadaNotandi.jsp skránna í vafra.
     * @return .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/hvadaNotandi.jsp
     */
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi () {
        return "demo/hvadaNotandi";
    }

    /**
     * Fallið sér um að birta synaNotandi.jsp skránna í vafra.
     * @param nafn Nafnið sem er slegið inn á vefsíðunni
     * @param model Módelið sem bæta á nafninu við
     * @return .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/synaNotandi.jsp
     */
    @RequestMapping(value="/hver", method= RequestMethod.POST)
    public String hver (@RequestParam(value="nafn", required=false) String nafn, ModelMap model) {
        model.addAttribute("nafn", nafn);
        return "demo/synaNotandi";
    }

}
