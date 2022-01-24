package com.todo.todo.dto;

import java.util.Date;

import com.todo.todo.entity.Status;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TodoItemDto {
	
	private Long id;
	
	private String title;

	private Status status;
	
	private String dateToBeDone;
	

}
