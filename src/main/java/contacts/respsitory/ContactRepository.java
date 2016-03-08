package contacts.respsitory;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import contacts.entity.Contact;

public interface ContactRepository {
	
	List<Contact> findAll();

	// cache put ��δ��ɣ�û�з��ز����ֵ
	@CachePut(value = "contactcache", key="#contact.firstName")
	void save(Contact contact) ;
	
	@Cacheable(value = "contactcache", key = "#contact.firstName")
	Contact findContactByFirstName(String firstName);
	
	// update ֻ���ø� redis key ����ʧЧ����δ��������ֵ
	@CacheEvict(value = "contactcache", key = "#contact.firstName")
	void updateContact(Long id, Contact contact);
}
