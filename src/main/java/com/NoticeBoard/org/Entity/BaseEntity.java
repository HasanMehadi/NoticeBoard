package com.NoticeBoard.org.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<ID> {

	@Version
	private Long version;
	
	@Column(name = "Create_Date", nullable = false)
	private Date createDate;

	@Column(name="Last_Modified_Date", nullable=false)
	private Date lastModifiedDate;

	public Long getVersion() {

		return version;
	}

	public void setVersion(Long version) {

		this.version = version;
	}

	public Date getCreateDate() {

		return createDate;
	}

	public void setCreateDate(Date createDate) {

		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {

		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {

		this.lastModifiedDate = lastModifiedDate;
	}

	@PrePersist
	public void prePersist() {

		this.createDate = new Date();
		this.lastModifiedDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {

		this.lastModifiedDate = new Date();
	}

	public abstract ID getId();
}
