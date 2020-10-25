/**
 * 
 */
package com.rahul.imageapp.util;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author rbarahpu
 *
 */

@Component
public class RestClient {
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public RestClient() {
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
	}

	public ResponseEntity<byte[]> get(String url) {
		
		HttpEntity<byte[]> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<byte[]> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity,
				byte[].class);
		this.setStatus(responseEntity.getStatusCode());
		System.out.println("In Rest Client status code --> " + responseEntity.getStatusCode());
		HttpHeaders resHeaders = responseEntity.getHeaders();
		Map<String, String> headers = resHeaders.toSingleValueMap();
		System.out.println("------------------------------------");
		for (String h: headers.keySet()) {
			System.out.println(h + " --> " + headers.get(h));
		}
		System.out.println("------------------------------------");
		return responseEntity;
	}

	public String post(String url, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
		ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.POST, requestEntity,
				String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	public void put(String url, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
		ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.PUT, requestEntity,
				String.class);
		this.setStatus(responseEntity.getStatusCode());
	}

	public void delete(String url) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.DELETE, requestEntity,
				String.class);
		this.setStatus(responseEntity.getStatusCode());
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
