package org.isj.ing.annuarium.webapp.Annuarium.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Todolist;
import org.isj.ing.annuarium.webapp.Annuarium.service.ITodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class TodolistController {
    @Autowired
    ITodoList iTodoList;

    @GetMapping("/")
    public String pageAccueil(Model model) {
        System.out.println("helllo");
        return "redirect:enregistrer";
    }

    @GetMapping("/liste")
    public  String pageliste (Model model){
        List<Todolist> todo = iTodoList.listTodo();
        model.addAttribute("todo",todo);
        return "todolist";
    }

    @GetMapping("/supprimer")
    public String pageSupprimer(@RequestParam(name = "id") Long id,Model model){
        iTodoList.deleteTodo(id);
        return "redirect:liste";
    }


    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name = "id") Long id, Model model) {
        Optional<Todolist> todo = iTodoList.findToDoListById(id);
        model.addAttribute("todo",todo);
        return "redirect:liste";
    }
    @PostMapping("/rechercherlist" )
    public String rechercherTodoList( @RequestParam(name = "title") String title,
                                   Model model) {
        Optional<List<Todolist>> todo=  iTodoList.searchTodoListByTitle(title);
        model.addAttribute("todo",todo);
        return "todolist";
    }
    @GetMapping("/rechercherlistform")
    public String pagerechercherform(Model model) {
        List<Todolist> todo = iTodoList.listTodo();
        model.addAttribute("todo",todo);
        return "todolist";
    }

    @GetMapping("/enregistrerlistform")
    public String enregistrerListForm( Model model) {
        System.out.println("je passe ici");
        Todolist todolist=  new Todolist();
        model.addAttribute("todolist",todolist);
        return "enregistrer";
    }
    @PostMapping("/enregistrerlist")
    public String enregistrerlist(@ModelAttribute Todolist todolist) {
        iTodoList.saveTodo(todolist);
        return "redirect:liste";
    }
}
