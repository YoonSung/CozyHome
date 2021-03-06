package org.nhnnext.web;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BoardData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=20, nullable=false)
	private String title;
	
	@Column(length=150, nullable=false)
	private String contents;
	
	@Column(length=100, nullable=true)
	private String fileName;

	@Column(length=30, nullable=true)
	private String writer;
	
	@OneToMany(mappedBy = "boardData", fetch = FetchType.EAGER)
	private List<CommentData> comments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<CommentData> getComments() {
		return comments;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "BoardData [id=" + id + ", title=" + title + ", writer="
				+ writer + ", contents=" + contents + ", fileName=" + fileName
				+ ", comments=" + comments + "]";
	} 
}
