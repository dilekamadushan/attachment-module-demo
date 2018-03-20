
package madushan.springframework.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import madushan.springframework.domain.AttachmentRequest;
import madushan.springframework.domain.Attachment;
import madushan.springframework.services.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value=" Attachment  Rest Module", description="Operations pertaining Attachments")
public class AttachmentController {

    private AttachmentServiceImpl attachmentService;

    @Autowired 
	    public void setAttachmentService (AttachmentServiceImpl attachmentService){
		    this.attachmentService = attachmentService;
	    }
	
  @ApiOperation(value = "Get all attachments",
		 // response = Attachment.class,
		  responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

  
  @RequestMapping(value = "/attachment", method= RequestMethod.GET, produces = "application/json")
    public List<Attachment> showAttachments(Model model){
        List<Attachment> attachmentList = (List<Attachment>) attachmentService.listAllFiles();
        return attachmentList;
    }
	
	@ApiOperation(value = "Get an attachment  ",response = Attachment.class)
	@RequestMapping(value = "/attachment/{attachmentUUID}", method= RequestMethod.GET, produces = "application/json")
	public Attachment showAttachment(@PathVariable Integer attachmentId, Model model){
		Attachment attachment = attachmentService.getFileById(attachmentId);
		return attachment;
	}

    @ApiOperation(value = "Search for an attachment with an patientId, encounterId, visitId ",response = Attachment.class)
    @RequestMapping(value = "/attachment/{patientUUID}/{encounterUUID}/{visitUUID}", method= RequestMethod.GET, produces = "application/json")
    public List<Attachment> showAttachment(@PathVariable Integer patientId, @PathVariable Integer encounterId, @PathVariable Integer visitId, Model model){
       List<Attachment> attachmentList = attachmentService.listAllFiles();
	   return attachmentList;
    }

    @ApiOperation(value = "Add a attachment")
    @RequestMapping(value = "/attachment", method = RequestMethod.POST)
    public void saveAttachment(@RequestBody AttachmentRequest attachmentRequest){
    	
        attachmentService.saveFile(attachmentRequest.getAttachments());
    }

    @ApiOperation(value = "Update a attachment")
    @RequestMapping(value = "/attachment/{attachmentUUID}", method = RequestMethod.PUT)
    public void updateAttachment(@PathVariable Integer patientId, @RequestBody AttachmentRequest attachmentRequest){
        Attachment storedAttachment = attachmentService.getFileById(patientId);
   
    }

    @ApiOperation(value = "Delete a attachment")
    @RequestMapping(value="/attachment/{attachmentUUID}", method = RequestMethod.DELETE)
    public void deleteAttachment(@PathVariable Integer attachmentId){
        attachmentService.deleteFile(attachmentId);

    }

}

