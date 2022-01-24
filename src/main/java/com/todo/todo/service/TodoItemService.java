package com.todo.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.todo.todo.converter.TodoItemConverter;
import com.todo.todo.dto.TodoItemDto;
import com.todo.todo.entity.TodoItem;
import com.todo.todo.exception.TodoItemNotFoundException;
import com.todo.todo.repository.TodoItemRepository;

@Service
public class TodoItemService {

	private TodoItemRepository todoItemRepo;

	private TodoItemConverter todoItemConverter;



	public TodoItemService(TodoItemRepository todoItemRepo, TodoItemConverter todoItemConverter) {
		super();
		this.todoItemRepo = todoItemRepo;
		this.todoItemConverter = todoItemConverter;
	}

	public List<TodoItemDto> getAllTodoList() {
		return todoItemRepo.findAll().stream().map(TodoItemConverter::convert).collect(Collectors.toList());
	}

	public TodoItemDto createTodoItem(TodoItemDto request) {
		TodoItem item = new TodoItem();
		item.setTitle(request.getTitle());
		item.setStatus(request.getStatus());
		item.setDateToBeDone(request.getDateToBeDone());
		item = todoItemRepo.save(item);
		TodoItemDto itemDto = TodoItemConverter.convert(item);
		return itemDto;

	}

	public TodoItemDto updateTodoItem(TodoItemDto request) {
		TodoItem item = new TodoItem();
		if (request.getId() != null) {
			Optional<TodoItem> itemopt = todoItemRepo.findById(request.getId());
			item = itemopt.get();
			item.setTitle(request.getTitle());
			item.setStatus(request.getStatus());
			item.setDateToBeDone(request.getDateToBeDone());
			item = todoItemRepo.save(item);
		}else {
			throw new TodoItemNotFoundException("ToDo Item couldn't be found by following id:" + request.getId());
		}

		TodoItemDto itemDto = TodoItemConverter.convert(item);
		return itemDto;

	}

	public void deleteTodoItem(Long id) {
		todoItemRepo.deleteById(id);

	}

}
