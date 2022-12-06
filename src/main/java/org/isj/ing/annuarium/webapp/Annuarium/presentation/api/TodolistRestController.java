package org.isj.ing.annuarium.webapp.Annuarium.presentation.api;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Todolist;
import org.isj.ing.annuarium.webapp.Annuarium.service.ITodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
@Slf4j
public class TodolistRestController {
@Autowired
    ITodoList iTodoList;
    @PostMapping("/save")
    public void Save (@RequestBody Todolist todolist) {
        TodolistRestController.log.info("Tache enregistrer");
        iTodoList.saveTodo(todolist);
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody Todolist todolist,@PathVariable Long id){
        TodolistRestController.log.info("Tache modifier");
        iTodoList.updateTodo(todolist,id);
    }
    @GetMapping("/data")
    public ResponseEntity<List<Todolist>> list(){
        return ResponseEntity.ok(iTodoList.listTodo());
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        return iTodoList.deleteTodo(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?>getTodo(@PathVariable Long  id){
        Optional<Todolist> todo=iTodoList.findToDoListById(id);
        return new ResponseEntity<> (todo, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?>getTodoByTitle(@PathVariable String  title){
        Optional<List<Todolist>> todolistList=iTodoList.searchTodoListByTitle(title);
        return  new ResponseEntity<>(todolistList,HttpStatus.NOT_FOUND);
    }

}
