package vir.project.pictureBrowser.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import vir.project.pictureBrowser.Entity.User;
import vir.project.pictureBrowser.User.UService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Pages {

    @Autowired
    private UService Uservices;


    //dobjon be a loginra ha betölt a html oldal, vagy login-ra megyünk (logout visz oda), vagy /
    @RequestMapping(value = {"", "/","/login"}, method = {
            RequestMethod.GET, RequestMethod.POST}
    )
    public String LoginPage() {

        return ("login");
    }

    //home oldal -> mindenki szamara elerhető
    @RequestMapping(value = {"/home"})
    public String HomePage(Model model){
        List<User> userList = Uservices.listAll();

        model.addAttribute("users", userList);
        return "home";
    }

    // edit oldal -> edit/felhasznalo -> a forrás videó szerint itt a primary key-t kell neki adni
    // és az id (primary key) alapjan kapjuk meg a usert amivel az edit oldalra megyünk
    @RequestMapping(value = {"/edit/{id}"})
    public ModelAndView EditUser(@PathVariable(name = "id") int id) {
        ModelAndView model = new ModelAndView("edit");
        User user = Uservices.getID(id);
        model.addObject("user", user);

        return model;
    }

    // mentésnél vissza kell térni (redirect) a /home oldalra
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        Uservices.updateRole(user.getUsername(),user.getRole());

        return "redirect:/home";
    }


    //ha valami hiba van, akkor /error oldalra dob a springboot -> most error html-re vigyen
    @RequestMapping(value = {"/error"}, method = {
            RequestMethod.GET, RequestMethod.POST}
    )
    public String ErrorPage()
    {

        return "error";
    }

}