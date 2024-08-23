package br.com.yuri.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.yuri.data.vo.v2.PersonVO2;
import br.com.yuri.model.Person;

@Service
public class PersonMapper {

	public Person convertVoToEntity(PersonVO2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return entity;
	}
	
	public PersonVO2 convertEntityToVo(Person person) {
		PersonVO2 vo = new PersonVO2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		
		return vo;
	}
}
