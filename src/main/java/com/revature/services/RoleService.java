package com.revature.services;

import java.util.List;
import com.revature.model.Role;

public interface RoleService {
	
	List<Role> findAll();
	Role findById(int id);
	Role save(Role r);	
}
