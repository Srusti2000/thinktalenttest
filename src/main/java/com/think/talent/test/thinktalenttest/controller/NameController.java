package com.think.talent.test.thinktalenttest.controller;

import com.think.talent.test.thinktalenttest.dao.NameDao;
import com.think.talent.test.thinktalenttest.domain.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NameController {

    @Autowired
    private NameDao dao;
    @RequestMapping("/name")
    public String viewHomePage(Model model) {
        List<Name> listName = dao.list();
        model.addAttribute("listName", listName);
        return "name";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Name name = new Name();
        model.addAttribute("name", name);
        return "newform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("name") Name name) {
        dao.save(name);
        System.out.println("Name Saved Successfully");
        return "redirect:/name";
    }

}
