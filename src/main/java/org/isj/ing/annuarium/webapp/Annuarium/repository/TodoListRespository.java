package org.isj.ing.annuarium.webapp.Annuarium.repository;

import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoListRespository extends JpaRepository<Todolist,Long> {
    Optional<List<Todolist>> findTodoListByTitle(String title);
}
