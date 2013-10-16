package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommentData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length=1000, nullable=false)
	private String comment;

	@ManyToOne
	private BoardData boardData;
	
	public CommentData() {
	}
	
	public CommentData(BoardData boardData, String comment) {
		this.boardData = boardData;
		this.comment = comment;
	}
	
	public BoardData getBoardData() {
		return boardData;
	}
	
	public String getComment() {
		return comment;
	}
	
	public int getId() {
		return id;
	}
}
