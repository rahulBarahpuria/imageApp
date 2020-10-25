/**
 * 
 */
package com.rahul.imageapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.imageapp.service.ImageService;

/**
 * @author rbarahpu
 *
 */
@RestController
@RequestMapping(value = "image")
public class ImageResourceController {
	
	@Autowired
	private  ImageService imageService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() {
		
		return imageService.getSingleRandomImage();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
		System.out.println("I am hit!!!!!");
		return imageService.getSingleRandomImageById(id);
	}
	
	@RequestMapping(value = "images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllImages () {
		return imageService.getAllImages();
	}
}
