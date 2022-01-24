package com.todo.todo.converter;

import com.todo.todo.dto.TodoItemDto;
import com.todo.todo.entity.Status;
import com.todo.todo.entity.TodoItem;

public class TodoItemConverter {
	

	public static TodoItemDto convert(TodoItem item) {
		return new TodoItemDto(item.getId(),item.getTitle(),item.getStatus(),item.getDateToBeDone());
		
	}

}
