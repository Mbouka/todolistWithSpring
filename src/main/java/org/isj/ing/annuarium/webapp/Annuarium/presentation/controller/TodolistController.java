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
        return "redirect:liste";
    }


    @GetMapping("/liste")
    public  String pageliste (Model model,String msg ){
        int tabSize;
        long num= iTodoList.countTask();
        long numTask = num;
        System.out.println(numTask);
        model.addAttribute("numTask",numTask);

        List<Todolist> todo = iTodoList.listTodo();
        tabSize=todo.size();
        model.addAttribute("todo",todo);

        msg="You have no task for the moment";
        if(tabSize == 0){
            System.out.println(msg);
            model.addAttribute("msg",msg);
        }else{
            model.addAttribute("msg", "");
        }
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
    @GetMapping("/rechercherlist" )
    public String rechercherTodoList( @RequestParam(name = "title") String title, Model model,String msg) {
        int tabSize;
        List<Todolist> todo=  iTodoList.searchTodoListByTitle(title);
        tabSize=todo.size();
        model.addAttribute("todo",todo);
        msg="no task of this name";
        if(tabSize == 0){
            System.out.println(msg);
            model.addAttribute("msg",msg);
        }else{
            model.addAttribute("msg", "");
        }
        return "rechercher";
    }

    @GetMapping("/rechercherlistform")
    public String pagerechercherform(Model model) {

        return "rechercher";
    }

    @GetMapping("/enregistrerlistform")
    public String enregistrerListForm( Model model) {
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
