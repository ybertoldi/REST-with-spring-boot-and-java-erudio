package br.com.yuri.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuri.data.vo.v1.PersonVO;
import br.com.yuri.data.vo.v2.PersonVO2;
import br.com.yuri.exception.ResourceNotFoundException;
import br.com.yuri.mapper.DozerMapper;
import br.com.yuri.mapper.custom.PersonMapper;
import br.com.yuri.model.Person;
import br.com.yuri.repositories.PersonRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people...");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	@Transactional
	public PersonVO create(PersonVO person) {
		logger.info("creating one person...");
		
		Person p = DozerMapper.parseObject(person, Person.class);
		
		PersonVO vo = DozerMapper.parseObject(repository.save(p), PersonVO.class) ;
		return vo;
	}
	
	
	@Transactional
	public PersonVO2 createV2(PersonVO2 person) {
		logger.info("creating one person with V2!");
		
		Person p = mapper.convertVoToEntity(person);
		PersonVO2 vo = mapper.convertEntityToVo(repository.save(p));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("creating one person...");
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found by this id!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(long id) {
		logger.info("Deleting one person...");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found by this id!"));
		repository.delete(entity);
	}
	
	public PersonVO findByID(Long id) {
		logger.info("Finding one person...");
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found by this id!"));
	
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
}
