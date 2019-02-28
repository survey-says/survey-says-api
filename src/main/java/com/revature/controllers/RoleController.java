package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Role;
import com.revature.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public List<Role> findAll() {
		return roleService.findAll();
	}
	
	@GetMapping("/{id}")
	public Role findById(@PathVariable int id) {
		return roleService.findById(id);
	}	
	
	@PostMapping
	public Role save(@Valid @RequestBody Role r) {
		return roleService.save(r);
	}
}
