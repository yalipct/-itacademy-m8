package com.video.domain;

import com.video.application.CamposVacios;

public class Tag {

	private String tagName;
	

	public Tag(String tagName) throws CamposVacios {
		if (tagName.equals("") || tagName == null)
			throw new CamposVacios("Campo obligatorio");
		this.tagName = tagName;
	}
	

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return getTagName();
	}

}
