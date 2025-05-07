package com.mvc.model;

import java.sql.Date;

public class BoardDto {
	private int id;
	private String title;
	private String content;
	private String userId;
	private Date createdAt;
	private int groupId;
	private int orderInGroup;
	private int depth;

	public BoardDto() {
	}

	public BoardDto(int id, String title, String content, String userId, Date createdAt, int groupId, int orderInGroup,
			int depth) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.createdAt = createdAt;
		this.groupId = groupId;
		this.orderInGroup = orderInGroup;
		this.depth = depth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getOrderInGroup() {
		return orderInGroup;
	}

	public void setOrderInGroup(int orderInGroup) {
		this.orderInGroup = orderInGroup;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", createdAt=" + createdAt + ", groupId=" + groupId + ", orderInGroup=" + orderInGroup + ", depth="
				+ depth + "]";
	}

}