package madushan.springframework.services;

import madushan.springframework.domain.Attachment;
import madushan.springframework.repositories.AttachmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AttachmentRepository attachmentRepository;

    @Autowired
    public void setAttachmentRepository(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public List<Attachment> listAllFiles() {
        logger.debug("listAllFiles called");
        return (List<Attachment>) attachmentRepository.findAll();
    }

    @Override
    public Attachment getFileById(Integer id) {
        logger.debug("getFileById called");
        return attachmentRepository.findOne(id);
    }

    public Iterable<Attachment> saveFile(List<Attachment> attachments) {
        logger.debug("saveFile called");
        return attachmentRepository.save(attachments);
    }

    @Override
    public void deleteFile(Integer id) {
        logger.debug("deleteFile called");
        attachmentRepository.delete(id);
    }
}
