package com.Dao;

import com.util.Pagination;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by wuwan on 2016/8/21.
 * 定义数据库操作
 */
public interface GeneralDao<T, ID extends Serializable> {
    /**
     * 《完整保存实体》
     *
     * @param t
     */
    void save(T t);

    /**
     * 《保存或更新实体》
     *
     * @param t
     */
    void saveOrUpdate(T t);

    // 删

    /**
     * 《删除表中t的记录》
     *
     * @param t
     */

    void delete(T t);

    /**
     * 《根据id删除记录》
     *
     * @param id
     * @return 删除结果
     */
    boolean deleteById(ID id);

    /**
     * 《删除集合中所有的记录》
     *
     * @param collections
     */
    void deleteAll(Collection<T> collections);

    // 改

    /**
     * 《更新表中记录》
     *
     * @param t
     */
    void update(T t);

    /**
     * 《更新表中记录:若session存在相同持久化实例，新实例化对象将覆盖原有的实例》
     *
     * @param t
     */
    void merge(T t);

    // 查

    /**
     * 《根据id获取单条记录》
     *
     * @param id
     * @return
     */
    T get(ID id);

    /**
     * 《根据SQL查询》
     *
     * @param sqlString
     * @param values
     */
    void queryBySQL(String sqlString, Object... values);

    /**
     * 《根据SQL获取唯一实体》
     *
     * @param sqlString
     * @param values
     * @return
     */
    T getBySQL(String sqlString, Object... values);

    /**
     * 《根据SQL获取实体集合》
     *
     * @param hqlString
     * @param values
     * @return
     */
    List<T> getListBySQL(String hqlString, Object... values);

    /**
     * 《根据HQL查询》
     *
     * @param hqlString
     * @param values
     */
    void queryByHQL(String hqlString, Object... values);

    /**
     * 《根据HQL获取唯一实体》
     *
     * @param hqlString
     * @param values
     * @return
     */
    T getByHQL(String hqlString, Object... values);

    /**
     * 《根据HQL获取实体集合》
     *
     * @param hqlString
     * @param values
     * @return
     */
    List<T> getListByHQL(String hqlString, Object... values);

    /**
     * 《根据HQL分页查询》
     *
     * @param hqlString
     * @param pageSize
     * @param pageNmuber
     * @param values
     * @return
     */
    Pagination getPageByHQL(String hqlString, Integer pageSize, Integer pageNmuber, Object... values);


//    其他

    /**
     * 《根据HQL得到记录数》
     *
     * @param hqlString
     * @param values
     * @return
     */
    long countByHQL(String hqlString, Object... values);


}
