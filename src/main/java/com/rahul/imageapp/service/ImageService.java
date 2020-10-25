/**
 * 
 */
package com.rahul.imageapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.imageapp.dao.ImageDAO;
import com.rahul.imageapp.entity.ImageInfo;
import com.rahul.imageapp.util.RestClient;

/**
 * @author rbarahpu
 *
 */

@Service
public class ImageService {

	@Autowired
	private ImageDAO imageDao;
	@Autowired
	private RestClient restClient;
	String url = "https://picsum.photos/";

	public ResponseEntity<byte[]> getSingleRandomImage() {
		// fetch image by making http call to external API
		return restClient.get(url + "300");

	}

	public ResponseEntity<byte[]> getSingleRandomImageById(Long id) {
		// find image by id in the db first, if found then return the url, else make
		// http call to external API and save the image url by id in the db
		Optional<ImageInfo> imageInfo = imageDao.findById(id);
		if (imageInfo.isPresent()) {
			String url = imageInfo.get().getUrl();
			return restClient.get(url);
		} else {
			ResponseEntity<byte[]> res = restClient.get(url + "id/" + id + "/300/300");
			int resCode = res.getStatusCodeValue();
			if (resCode >= 200 && resCode < 300) {
				imageDao.save(new ImageInfo(url + "id/" + id + "/300/300", id));
			}
			return res;
		}
	}
	
	public Object getAllImages() {
		return  imageDao.findAll();
	}

}
