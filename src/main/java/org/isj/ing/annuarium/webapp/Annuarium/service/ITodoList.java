package org.isj.ing.annuarium.webapp.Annuarium.service;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Todolist;

import java.util.List;
import java.util.Optional;

public interface ITodoList {
    Todolist saveTodo( Todolist todolist);
    Todolist updateTodo ( Todolist todolist,Long id);
    List<Todolist> listTodo();
    String deleteTodo(Long id);
    Optional<Todolist> findToDoListById(Long id);
    Optional<List<Todolist>> searchTodoListByTitle(String title);
}
