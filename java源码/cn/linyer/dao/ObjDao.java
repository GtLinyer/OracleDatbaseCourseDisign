package cn.linyer.dao;
/**
 * @author Linyer
 * 增删改操作接口
 * 
 */
public interface ObjDao {
	//增
	public boolean addObj(Object object);
	//删
	public boolean deleObj(String no);
	//改
	public boolean exeObj(Object object);
}
