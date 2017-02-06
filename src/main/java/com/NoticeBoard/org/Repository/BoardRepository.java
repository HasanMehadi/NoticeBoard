package com.NoticeBoard.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NoticeBoard.org.Entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	
	public Board findByName(String name);
}
