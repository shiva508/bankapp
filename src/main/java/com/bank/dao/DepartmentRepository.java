package com.bank.dao;

import java.util.List;

import com.bank.model.Department;

public interface DepartmentRepository {
public Department finfDepartmentById(Integer departmentId);
public List<Department> findDepartmentByStoredProcedureUsingcreateSQLQuery();
public List<Department> findDepartmentByStoredProcedureUsinggetNamedQuery();
}
