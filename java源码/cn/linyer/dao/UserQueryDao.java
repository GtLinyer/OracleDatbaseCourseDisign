package cn.linyer.dao;

import cn.linyer.entity.UserLoginMsg;
/**
 * @author Linyer
 * 用户登录查询数据库接口
 * 
 */
public interface UserQueryDao {
	//查询用户信息
	public UserLoginMsg queryUser(String no,String pwd);
}