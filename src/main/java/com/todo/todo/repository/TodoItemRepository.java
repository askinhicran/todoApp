package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.entity.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
