package com.NoticeBoard.org.ValidationCheck;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {

	@NotEmpty
	private String boardName;

	@NotEmpty
	@Size(min = 4, max = 250)
	private String password;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
