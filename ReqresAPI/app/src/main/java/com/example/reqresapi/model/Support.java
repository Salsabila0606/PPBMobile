package com.example.reqresapi.model;

import com.google.gson.annotations.SerializedName;

public class Support{

	@SerializedName("text")
	private String text;

	@SerializedName("url")
	private String url;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Support{" + 
			"text = '" + text + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}