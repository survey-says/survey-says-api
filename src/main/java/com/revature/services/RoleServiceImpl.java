package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Role;
import com.revature.repos.RoleRepo;
import com.revature.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role save (Role p) {
		p.setRoleId(0);		
		return roleRepo.save(p);
	}

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepo.getOne(id);
	}
}
