/**
 * 
 */
package com.rahul.imageapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rbarahpu
 *
 */
@Entity
@Table(name = "image_info")
public class ImageInfo {

	@Column(name = "url")
	private String url;

	@Column(name = "id")
	@Id
	private long id;

	public ImageInfo(String url, long id) {
		super();
		this.url = url;
		this.id = id;
	}

	public ImageInfo() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public long getId() {
		return id;
	}

}
