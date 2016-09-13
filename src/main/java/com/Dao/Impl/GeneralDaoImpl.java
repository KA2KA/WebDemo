package com.Dao.Impl;

import com.Dao.GeneralDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.util.Pagination;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by wuwan on 2016/8/21.
 */

@Repository("baseDao")
public class GeneralDaoImpl<T, ID extends Serializable> implements GeneralDao<T, ID> {


    private Session session;
    @Autowired
    private SessionFactory sessionFactory;


    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        if (entityClass == null) {
            entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }

    @Override
    public void save(T t) {
        this.getSession().save(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        this.getSession().delete(t);
    }

    @Override
    public boolean deleteById(ID id) {
        T t = this.get(id);
        if (t == null)
            return false;
        delete(t);
        return false;
    }

    @Override
    public void deleteAll(Collection<T> collections) {
        for (T t : collections) {
            this.getSession().delete(t);
        }
    }

    @Override
    public void update(T t) {
        this.getSession().update(t);
    }

    @Override
    public void merge(T t) {
        this.getSession().merge(t);
    }

    @Override
    public T get(ID id) {
        return (T) this.getSession().get(getEntityClass(), id);
    }

    @Override
    public void queryBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createNativeQuery(sqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
            query.executeUpdate();
        }

    }

    @Override
    public T getBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createNativeQuery(sqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> getListBySQL(String hqlString, Object... values) {
        NativeQuery query = this.getSession().createNativeQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();


    }

    @Override
    public void queryByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.executeUpdate();

    }

    @Override
    public T getByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> getListByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();
    }

    @Override
    public Pagination getPageByHQL(String hqlString, Integer pageSize, Integer pageNmuber, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.setFetchSize(pageSize * (pageNmuber - 1));
        query.setMaxResults(pageSize);
        long totalCount = (long) query.uniqueResult();
        Pagination pagination = new Pagination(pageSize, pageNmuber, totalCount);
        pagination.setList(query.list());
        return pagination;
    }

    @Override
    public long countByHQL(String hqlString, Object... values) {
        NativeQuery query = this.getSession().createNativeQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (long) query.uniqueResult();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
