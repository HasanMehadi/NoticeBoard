package com.NoticeBoard.org.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
@SequenceGenerator(name = "BoardSequence", initialValue = 1, allocationSize = 1000)
public class Board extends BaseEntity<Long> {

	@Id
	@GeneratedValue(generator = "BoardSequence", strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "Name", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "Password", nullable = false, length = 250)
	private String password;
	
	@Column(name="Content")
	@Type(type="text")
	private String content;

	public Board() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [Id=" + Id + ", name=" + name + ", content=" + content + "]";
	}

	
}
