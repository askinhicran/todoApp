package com.todo.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.dto.TodoItemDto;
import com.todo.todo.service.TodoItemService;

@RestController
@RequestMapping(value = "/todo")
public class TodoItemController {

	private TodoItemService todoItemService;

	public TodoItemController(TodoItemService todoItemService) {
		this.todoItemService = todoItemService;
	}

	@GetMapping(value = "/getAllTodoList")
	public ResponseEntity<List<TodoItemDto>> getAllTodoList() {
		return ResponseEntity.ok(todoItemService.getAllTodoList());

	}

	@PostMapping(value = "/create")
	public ResponseEntity<TodoItemDto> createTodo(@RequestBody TodoItemDto todoItemDto) {
		return ResponseEntity.ok(todoItemService.createTodoItem(todoItemDto));

	}

	@PutMapping(value = "/update")
	public ResponseEntity<TodoItemDto> updateTodo(@RequestBody TodoItemDto todoItemDto) {
		return ResponseEntity.ok(todoItemService.updateTodoItem(todoItemDto));

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable(value = "id") Long id) {
		todoItemService.deleteTodoItem(id);
		return ResponseEntity.ok().build();

	}

}
