package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_flower_intor database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbFlowerIntor extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer itemSeq;
	private String description;
	private String isShow;
	private String itemCharacter;
	private String itemPics;
	private String title;
	private String usages;

    public SmTbFlowerIntor() {
    }

	public Integer getItemSeq() {
		return this.itemSeq;
	}
	public void setItemSeq(Integer itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsShow() {
		return this.isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getItemCharacter() {
		return this.itemCharacter;
	}
	public void setItemCharacter(String itemCharacter) {
		this.itemCharacter = itemCharacter;
	}

	public String getItemPics() {
		return this.itemPics;
	}
	public void setItemPics(String itemPics) {
		this.itemPics = itemPics;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsages() {
		return this.usages;
	}
	public void setUsages(String usages) {
		this.usages = usages;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("itemSeq", getItemSeq())
			.toString();
	}
}