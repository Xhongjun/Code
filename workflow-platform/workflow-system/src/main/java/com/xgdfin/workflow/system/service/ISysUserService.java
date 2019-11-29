package com.xgdfin.workflow.system.service;

import com.xgdfin.workflow.system.domain.SysUser;

import java.util.HashMap;
import java.util.List;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    public SysUser selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    public SysUser selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);

    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);

    /**
     * 根据用户ID查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserPostGroup(Long userId);

    /**
     * <p>根据角色ID查询用户（分页）</p>
     * @param roleId 角色ID
     * @param page 页码
     * @param limit 每页显示条数
     * @return List<SysUser> 查询结果
     * @author FRH
     * @time 2019年1月11日上午10:30:52
     * @version 1.0
     */
	public List<SysUser> selectUserByRoleId(Long roleId, int page, int limit);

	/**
	 * <p>根据角色ID查询用户数量</p>
	 * @param roleId 角色ID
	 * @return int 用户数量
	 * @author FRH
	 * @time 2019年1月11日上午10:42:45
	 * @version 1.0
	 */
	public int countUserByRoleId(Long roleId);

	/**
	 * <p>查询角色Key下的所有用户</p>
	 * @param roleKey 角色key
	 * @return List<SysUser> 查询结果
	 * @author FRH
	 * @time 2019年1月14日上午10:31:03
	 * @version 1.0
	 */
	public List<SysUser> selectUserByRoleKey(String roleKey);

	/**
	 * <p>根据ID集合获取用户</p>
	 * @param idList id集合
	 * @return List<SysUser> 结果 
	 * @author FRH
	 * @time 2019年1月24日下午2:52:30
	 * @version 1.0
	 */
	public List<SysUser> selectUserByIds(List<Long> idList);

    /**
     * <p>查询部门id</p>
     * @return List<String> 结果
     * @author FRH
     * @time 2019年1月24日下午2:52:30
     * @version 1.0
     */
    List<HashMap<String, String>> queryDeptId();
}
