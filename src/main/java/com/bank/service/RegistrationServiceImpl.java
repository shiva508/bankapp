package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.RegistrationDao;
import com.bank.formmodel.RegistrationForm;
import com.bank.model.Registration;

import ma.glasnost.orika.MapperFacade;

@Service

public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	@Autowired
	private RegistrationDao registrationDao;

	@Transactional
	public Integer saveUser(RegistrationForm registrationForm) {
		Registration registration=formDomineMapperfaced.map(registrationForm, Registration.class);
		return registrationDao.saveUser(registration);
	}

	@Transactional
	public List<Registration> usersList() {
		
		return registrationDao.usersList();
	}

	@Transactional
	public void updateUser(RegistrationForm registrationForm) {
		Registration registration=formDomineMapperfaced.map(registrationForm, Registration.class);
		registrationDao.updateUser(registration);
	}

	@Transactional
	public Integer deleteUser(Integer userid) {
		
		return registrationDao.deleteUser(userid);
	}

	@Transactional
	public RegistrationForm getUserByEmailAndPassword(String username, String password) {
		RegistrationForm registrationForm=null;
		Registration registration=registrationDao.getUserByEmailAndPassword(username, password);
		registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		return registrationForm;
	}

}
