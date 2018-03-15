package madushan.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@ApiModelProperty(notes = "The database generated concept ID")
	private Integer id;
	
	//@ApiModelProperty(notes = "The concept label")
	private Integer size;
	
	private String type;
	
	//@ApiModelProperty(notes = "The concept description")
	
	private String description;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getSize() {
		return  this.size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
