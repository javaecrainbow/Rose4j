package com.rose4j.util;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.honestspring.sys.model.ConditionParameter;
import com.honestspring.sys.model.SearchParameter;
import com.honestspring.sys.model.SortParameter;


/** 统一数据访问接口实现 */
public abstract class BaseDAOImpl extends HibernateDaoSupport implements BaseDAO {
	private StringBuffer sqlAppender = new StringBuffer();


	/** 统计指定类的查询结果 */
	public int countQuery(String hql) {
		final String counthql = hql;
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(counthql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return count.intValue();
	}

	/** 删除指定ID的持久化对象 */
	public void delById(Class clazz, Serializable id) {
		getHibernateTemplate().delete(getHibernateTemplate().load(clazz, id));
	}

	/** 装载指定类的所有持久化对象 */
	public List listAll(String clazz) {
		return getHibernateTemplate().find("from " + clazz + " as a ");
	}

	/** 分页装载指定类的所有持久化对象 */
	public List listAll(String clazz, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql = "from " + clazz + " as a";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setMaxResults(pSize);
				query.setFirstResult(pNo);
				List result = query.list();
				if (!Hibernate.isInitialized(result))
					Hibernate.initialize(result);
				return result;
			}
		});
		return list;
	}

	/** 加载指定ID的持久化对象 */
	public Object loadById(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/** 加载满足条件的持久化对象 */
	public Object loadObject(String hql) {
		final String hql1 = hql;
		Object obj = null;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
		if (list.size() > 0)
			obj = list.get(0);
		return obj;
	}

	/** 查询指定类的满足条件的持久化对象 */
	public List query(String hql) {
		final String hql1 = hql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
	}

	/** 分页查询指定类的满足条件的持久化对象 */
	public List query(String hql, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql1 = hql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql1);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo - 1) * pSize);
				List result = query.list();
				if (!Hibernate.isInitialized(result))
					Hibernate.initialize(result);
				return result;
			}
		});
	}

	/** 保存或更新指定的持久化对象 */
	public void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	/** 条件更新数据 */
	public int update(String hql) {
		final String hql1 = hql;
		return ((Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql1);
						return query.executeUpdate();
					}
				})).intValue();
	}

	/** 从连接池中取得一个JDBC连接 */
	public Connection getConnection() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.connection();
	}

	@Override
	public List listAll(SearchParameter searchParameter) {
		final int pageSize = searchParameter.getPageSize();
		final int pageNo = searchParameter.getPageNo();
		LinkedList<SortParameter> sortFields = searchParameter.getSortFields();
		LinkedList<ConditionParameter> conditionFields = searchParameter
				.getConditionFields();
		String targetClass = searchParameter.getClazz();
		sqlAppender.append("from ").append(targetClass).append(" as ").append(targetClass.toLowerCase());
		String hql = "";
		if (conditionFields != null && conditionFields.size() > 0) {
			sqlAppender.append(" WHERE ");
			for (ConditionParameter searchPara : conditionFields) {
				sqlAppender.append(searchPara.getFieldName())
				.append(" ").append(searchPara.getConditionType());
				if(searchPara.getFieldValue() instanceof String){
					sqlAppender.append(" '").append(searchPara.getFieldValue()).append("' AND ");
				}else if(searchPara.getFieldValue() instanceof Date){
					sqlAppender.append("TO_DATE('").append(searchPara.getFieldValue())
					.append("','yyyy-mm-dd')").append(" AND ");
				}else{
					sqlAppender.append(searchPara.getFieldValue()).append(" AND ");
				}
			}
			sqlAppender.append(" 1=1");
		}

		if (sortFields != null && sortFields.size() > 0) {
			sqlAppender.append(" ORDER BY");
			for (SortParameter sortPara : sortFields) {
				sqlAppender.append(" ").append(sortPara.getFieldName()).append(" ")
						.append(sortPara.getSortType());
			}
		}
		hql = sqlAppender.toString();
		sqlAppender.delete(0, sqlAppender.length());
		return query(hql,pageNo,pageSize);
	}

	@Override
	public List listAll(String clazz,
			LinkedList<ConditionParameter> conditionParameters) {
		String hql="";
		sqlAppender.append("from ").append(clazz).append(" as ").append(clazz.toLowerCase());
		if (conditionParameters != null && conditionParameters.size() > 0) {
			sqlAppender.append(" WHERE ");
			for (ConditionParameter searchPara : conditionParameters) {
				sqlAppender.append(searchPara.getFieldName())
						.append(" ").append(searchPara.getConditionType());
						if(searchPara.getFieldValue() instanceof String){
							sqlAppender.append(" '").append(searchPara.getFieldValue()).append("' AND ");
						}else if(searchPara.getFieldValue() instanceof Date){ 
							sqlAppender.append("TO_DATE('").append(searchPara.getFieldValue())
							.append("','yyyy-mm-dd')").append(" AND ");
						}else{
							sqlAppender.append(searchPara.getFieldValue()).append(" AND ");
						}
			}
			sqlAppender.append(" 1=1");
		}
		hql = sqlAppender.toString();
		sqlAppender.delete(0, sqlAppender.length());
		return getHibernateTemplate().find(hql);
	}

	@Override
	public int countAll(String clazz) {
		// TODO Auto-generated method stub
		return 0;
	}
}