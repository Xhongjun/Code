package com.xgdfin.workflow.system.service;

import com.xgdfin.workflow.system.domain.SysUserRole;

import java.util.List;

/**
 * <p>用户角色关联Service</p>
 * @author FRH
 * @time 2019年1月8日下午5:56:30
 * @version 1.0
 */
public interface ISysUserRoleService {

	/**
	 * <p>条件查询用户角色关联</p>
	 * @param sysUserRole 查询条件
	 * @return List<SysUserRole> 查询结果 
	 * @author FRH
	 * @time 2019年1月8日下午6:01:08
	 * @version 1.0
	 */
	public List<SysUserRole> selectByCondition(SysUserRole sysUserRole);

}
