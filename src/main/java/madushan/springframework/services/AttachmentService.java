package madushan.springframework.services;


import madushan.springframework.domain.Attachment;

import java.util.List;

public interface AttachmentService {
    List<Attachment> listAllFiles();

    Attachment getFileById(Integer id);

    Iterable<Attachment> saveFile(List<Attachment> attachments);

    void deleteFile(Integer id);
}

