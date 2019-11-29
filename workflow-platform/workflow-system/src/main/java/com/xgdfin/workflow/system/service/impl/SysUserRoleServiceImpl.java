package com.xgdfin.workflow.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgdfin.workflow.system.domain.SysUserRole;
import com.xgdfin.workflow.system.mapper.SysUserRoleMapper;
import com.xgdfin.workflow.system.service.ISysUserRoleService;


/**
 * <p>用户角色Service</p>
 * @author FRH
 * @time 2019年1月8日下午5:57:35
 * @version 1.0
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

	/** 用户角色关联表 */
	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Override
	public List<SysUserRole> selectByCondition(SysUserRole sysUserRole) {
		return userRoleMapper.selectList(sysUserRole);
	}
	
}
