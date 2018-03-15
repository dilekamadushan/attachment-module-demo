package madushan.springframework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dileka on 3/3/18.
 */
@Entity
public class AttachmentRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@ApiModelProperty(notes = "The database generated concept ID")
	private Integer patientId;
	
	private Integer visitId;
	
	private Integer providerId;
	
	private Integer encounterId;
	
	private String fileCaption;
	//@ApiModelProperty(notes = "The concept label")
	@ElementCollection
	List<Attachment> attachments = new ArrayList<>();
	
	//@ApiModelProperty(notes = "The concept description")
	
	
	public List<Attachment> getAttachments() {
		return attachments;
	}
	
	public void addFiles(List<Attachment> attachments) {
		this.attachments.addAll(attachments);
	}
	
	public void setpatientId(Integer patientId){
		this.patientId = patientId;
	}
	
	public Integer getPatientId(){
		return this.patientId;
	}
	
	public void setencounterId(Integer encounterId){
		this.encounterId = encounterId;
	}
	
	public Integer getEncounterId(){
		return this.encounterId;
	}
	
	public void setProviderId(Integer providerId){
		this.providerId = providerId;
	}
	
	public Integer getProviderId(){
		return this.providerId;
	}
	
}
