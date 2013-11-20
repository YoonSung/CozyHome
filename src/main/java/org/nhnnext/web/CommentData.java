package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class CommentData {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

//	@Column(length=20) because 꼬임....
	private String writer;

	
	@Column(length=1000, nullable=false)
	private String comment;

	@ManyToOne
	@JsonIgnore
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
	
	public Long getId() {
		return id;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
