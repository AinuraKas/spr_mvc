package com.ainura.spr_mvc.controllers;


import com.ainura.spr_mvc.dao.PeopleDao;
import com.ainura.spr_mvc.models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleDao peopleDao;
    @Autowired
    public PeopleController(PeopleDao peopleDao) {

        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("per", peopleDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("people", peopleDao.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPeople(Model model){
        model.addAttribute("people", new People());
        return  "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("people") People per){
        peopleDao.save(per);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("people", peopleDao.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("people") People per,@PathVariable("id") int id )
    {
        peopleDao.update(per, id);
        return "redirect:/people";

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id )
    {
        peopleDao.delete(id);
        return "redirect:/people";

    }
}
