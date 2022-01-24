package com.todo.todo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import com.todo.todo.converter.TodoItemConverter;
import com.todo.todo.dto.TodoItemDto;
import com.todo.todo.entity.Status;
import com.todo.todo.entity.TodoItem;
import com.todo.todo.repository.TodoItemRepository;

import junit.framework.Assert;

@Service
public class TodoItemServiceTest {

	private TodoItemService todoItemService;

	@Mock
	private TodoItemRepository todoItemRepo;

	@Mock
	private TodoItemConverter todoItemConverter;

	public TodoItemServiceTest() {
		
	}


	@Before
	public void setUp() throws Exception {
		todoItemRepo = Mockito.mock(TodoItemRepository.class);
		todoItemConverter = Mockito.mock(TodoItemConverter.class);
		todoItemService = new TodoItemService(todoItemRepo, todoItemConverter);
	}


	@Test
	public void getAllTodoListTest() {
	List<TodoItem> items = new ArrayList();
	Mockito.when(todoItemRepo.findAll()).thenReturn(items);
	List<TodoItemDto> expected = todoItemService.getAllTodoList();
	assertEquals(expected, items);
	Mockito.verify(todoItemRepo).findAll();
	
	
	}

	@Test
	public void updateTodoItemTest() {
		TodoItemDto todoItemDto = new TodoItemDto();
		todoItemDto.setId(1234L);
		todoItemDto.setTitle("Go Shopping");
		todoItemDto.setStatus(Status.UNDONE);
		todoItemDto.setDateToBeDone("24-01-2022 10:00:00");

		TodoItem todoItem = new TodoItem();
		todoItem.setId(1234L);
		todoItem.setTitle("Go Shopping");
		todoItem.setStatus(Status.UNDONE);
		todoItem.setDateToBeDone("24-01-2022 10:00:00");

		Mockito.when(todoItemRepo.findById(1234L)).thenReturn(Optional.of(todoItem));
		Mockito.when(todoItemRepo.save(todoItem)).thenReturn(todoItem);
		TodoItemDto result = todoItemService.updateTodoItem(todoItemDto);

		Assert.assertEquals(result, todoItemDto);
		Mockito.verify(todoItemRepo).findById(1234L);
		Mockito.verify(todoItemRepo).save(todoItem);
		

	}
	
	@Test
	public void deleteTodoItemTest(){
		TodoItem todoItem = new TodoItem();
		todoItem.setId(1234L);
		Mockito.when(todoItemRepo.findById(todoItem.getId())).thenReturn(Optional.of(todoItem));
		todoItemService.deleteTodoItem(todoItem.getId());
		Mockito.verify(todoItemRepo).deleteById(todoItem.getId());
		}
	
	
}
