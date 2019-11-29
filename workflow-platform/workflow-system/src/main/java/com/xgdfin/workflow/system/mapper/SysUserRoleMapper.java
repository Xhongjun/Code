package com.xgdfin.workflow.system.mapper;

import java.util.List;
import com.xgdfin.workflow.system.domain.SysUserRole;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserRoleMapper
{
    /**
     * 通过用户ID删除用户和角色关联
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserRole(Long[] ids);

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 批量新增用户角色信息
     * 
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
	 * <p>条件查询用户角色关联</p>
	 * @param sysUserRole 查询条件
	 * @return List<SysUserRole> 查询结果 
	 * @author FRH
	 * @time 2019年1月8日下午6:01:08
	 * @version 1.0
	 */
	public List<SysUserRole> selectList(SysUserRole sysUserRole);
}
