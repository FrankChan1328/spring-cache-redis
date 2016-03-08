package contacts.respsitory;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import contacts.entity.Contact;

public interface ContactRepository {
	
	List<Contact> findAll();

	// cache put 尚未完成，没有返回插入的值
	@CachePut(value = "contactcache", key="#contact.firstName")
	void save(Contact contact) ;
	
	@Cacheable(value = "contactcache", key = "#contact.firstName")
	Contact findContactByFirstName(String firstName);
	
	// update 只是让改 redis key 缓存失效，尚未存入插入的值
	@CacheEvict(value = "contactcache", key = "#contact.firstName")
	void updateContact(Long id, Contact contact);
}
