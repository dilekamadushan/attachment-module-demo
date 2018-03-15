package madushan.springframework.repositories;

import madushan.springframework.domain.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AttachmentRepository extends CrudRepository<Attachment, Integer>{
}
