/**
 * 
 */
package com.rahul.imageapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.rahul.imageapp.entity.ImageInfo;

/**
 * @author rbarahpu
 *
 */
public interface ImageDAO extends CrudRepository<ImageInfo, Long> {
	
	
}
