package com.sankha.hibernate.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private int id = 0;
	private String name = null;
	private String director = null;
	private String genre = null;
}
