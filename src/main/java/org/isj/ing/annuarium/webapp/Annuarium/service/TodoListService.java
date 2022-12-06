package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Todolist;
import org.isj.ing.annuarium.webapp.Annuarium.repository.TodoListRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoListService implements ITodoList{
    @Autowired
    TodoListRespository todoListRespository;
    @Override
    public Todolist saveTodo(Todolist todolist) {
        todolist.setId(todolist.getId());
        todolist.setContent(todolist.getContent());
        todolist.setTitle(todolist.getTitle());
        todolist.setStatus(todolist.getStatus());
        todolist.setDate(todolist.getDate());
        Todolist saveTodolist = todoListRespository.save(todolist);
        return saveTodolist;
    }

    @Override
    public Todolist updateTodo(Todolist todolist, Long id) {
        todolist.setStatus(todolist.getStatus());
        todolist.setTitle(todolist.getTitle());
        todolist.setContent(todolist.getContent());
        todolist.setDate(todolist.getDate());
        Todolist updateTodoList = todoListRespository.save(todolist);
        return updateTodoList;
    }

    @Override
    public List<Todolist> listTodo() {
        List<Todolist> list =todoListRespository.findAll();
        return list;
    }

    @Override
    public String deleteTodo(Long id) {
        todoListRespository.deleteById(id);
        return "Tache supprimer avec succes";
    }

    @Override
    public Optional<Todolist> findToDoListById(Long id) {
        return todoListRespository.findById(id);
    }

    @Override
    public Optional<List<Todolist>> searchTodoListByTitle(String title) {
        return todoListRespository.findToDoListByTitle(title);
    }
}
