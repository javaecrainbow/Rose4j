package com.honestspring.rose4j.templates;

import com.honestspring.rose4j.model.*;

public class BaseDaoTemplate
{
  protected static String nl;
  public static synchronized BaseDaoTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    BaseDaoTemplate result = new BaseDaoTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.sql.Connection;" + NL + "import java.util.*;" + NL + "import java.io.Serializable;" + NL + "import com.honestspring.sys.model.ConditionParameter;" + NL + "import com.honestspring.sys.model.SearchParameter;" + NL + "" + NL + "/** 统一数据访问接口 " + NL + " * @tag pattern" + NL + " * id = \"688da21b-d7db-455e-9510-d4810ee832cc\"" + NL + " * schema = \"e044b2e2-4b64-49ac-ba9f-d095173f0287\"" + NL + " * role = \"Command\"" + NL + " * comment = \"\"*/" + NL + "public interface BaseDAO {" + NL + "\t/** 加载指定ID的持久化对象 */" + NL + "\tpublic Object loadById(Class clazz,Serializable id);" + NL + "\t" + NL + "\t/** 加载满足条件的持久化对象 */" + NL + "\tpublic Object loadObject(String hql);" + NL + "\t" + NL + "\t/** 删除指定ID的持久化对象 */" + NL + "\tpublic void delById(Class clazz,Serializable id);" + NL + "\t" + NL + "\t/** 保存或更新指定的持久化对象 */" + NL + "\tpublic void saveOrUpdate(Object obj);" + NL + "\t" + NL + "\t/** 装载指定类的所有持久化对象 */" + NL + "\tpublic List listAll(String clazz);" + NL + "\t/** 装载指定类的所有持久化对象 */" + NL + "\tpublic List listAll(String clazz,LinkedList<ConditionParameter> conditionParameters);" + NL + "\t" + NL + "\t/** 分页装载指定类的所有持久化对象 */" + NL + "\tpublic List listAll(String clazz,int pageNo,int pageSize);" + NL + "\t" + NL + "\t/*分页排序装载指定类的所有持久化对象*/" + NL + "\tpublic List listAll(SearchParameter searchParameter);" + NL + "\t/** 统计指定类的所有持久化对象 */" + NL + "\tpublic int countAll(String clazz);" + NL + "\t" + NL + "\t/** 查询指定类的满足条件的持久化对象 */" + NL + "\tpublic List query(String hql);" + NL + "\t" + NL + "\t/** 分页查询指定类的满足条件的持久化对象 */" + NL + "\tpublic List query(String hql,int pageNo,int pageSize);" + NL + "\t" + NL + "\t/** 统计指定类的查询结果 */" + NL + "\tpublic int countQuery(String hql);" + NL + "\t" + NL + "\t/** 条件更新数据 */" + NL + "\tpublic int update(String hql);" + NL + "\t" + NL + "\t/** 从连接池中取得一个JDBC连接 */" + NL + "\tpublic Connection getConnection();" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	JavaTemplateArgs args = (JavaTemplateArgs)argument;
	String modeName = args.getModeName();
	String packageName = args.getPackageName();
	String className = args.getClassName();
	String entityPackageName = args.getPackageNameInfo().getEntityPackageName();
	String daoPackageName = args.getPackageNameInfo().getDaoPackageName();
	String servicePackageName = args.getPackageNameInfo().getServicPackageName();
	String actionPackageName = args.getPackageNameInfo().getActionPackageName();
	
	String entityClassName = args.getClassNameInfo().getEntityClassName();
	String daoClassName = args.getClassNameInfo().getDaoClassName();
	String serviceClassName = args.getClassNameInfo().getServicClassName();
	String actionClassName = args.getClassNameInfo().getActionClassName();
	
	String entityObjectName = args.getClassNameInfo().getEntityObjectName();
	String daoObjectName = args.getClassNameInfo().getDaoObjectName();
	String serviceObjectName = args.getClassNameInfo().getServicObjectName();
	String actionObjectName = args.getClassNameInfo().getActionObjectName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(args.getPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
