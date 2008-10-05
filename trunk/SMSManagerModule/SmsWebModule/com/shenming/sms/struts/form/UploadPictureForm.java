package com.shenming.sms.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadPictureForm extends ActionForm {
	private FormFile pic;
	private String idx;

	public FormFile getPic() {
		return pic;
	}
	
	public void setPic(FormFile pic) {
		this.pic = pic;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}
}
