package com.model;
public class ImageData {
	String id;
	String imagePath;
	String imageName;
	
	
	public ImageData(String id, String imagePath,String imageName) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.imageName=imageName;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public ImageData() {
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

}
