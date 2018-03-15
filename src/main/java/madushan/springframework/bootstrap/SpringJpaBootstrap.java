package madushan.springframework.bootstrap;

import madushan.springframework.domain.Attachment;
import madushan.springframework.domain.Product;
import madushan.springframework.repositories.AttachmentRepository;
import madushan.springframework.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
	private AttachmentRepository attachmentRepository;


    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository, AttachmentRepository attachmentRepository) {
        this.productRepository = productRepository;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadAttachmentFiles();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
	
	private  void loadAttachmentFiles(){
		Attachment attachment = new Attachment();
		attachment.setId(1);
		attachment.setType("image");
		attachment.setSize(12);
		attachment.setDescription("Test");
		this.attachmentRepository.save(attachment);
		
		Attachment attachment2 = new Attachment();
		attachment2.setId(2);
		attachment2.setType("image");
		attachment2.setSize(5);
		attachment2.setDescription("Test2");
		this.attachmentRepository.save(attachment2);
	}


    }



