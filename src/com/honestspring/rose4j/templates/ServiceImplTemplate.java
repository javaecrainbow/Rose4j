package com.honestspring.rose4j.templates;

import com.honestspring.rose4j.model.*;

public class ServiceImplTemplate
{
  protected static String nl;
  public static synchronized ServiceImplTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServiceImplTemplate result = new ServiceImplTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";" + NL + "import java.util.HashMap;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "" + NL + "import org.springframework.beans.factory.annotation.Autowired;" + NL + "import org.springframework.stereotype.Service;" + NL + "import com.honestspring.sys.component.HSResolveObj;" + NL + "import com.honestspring.sys.model.ConditionParameter;" + NL + "import com.honestspring.sys.model.SearchParameter;" + NL + "import com.honestspring.sys.model.SortParameter;" + NL + "import com.honestspring.sys.util.DataGridModel;" + NL + "" + NL + "@Service" + NL + "public class ";
  protected final String TEXT_7 = "{" + NL + "@Autowired" + NL + "\tprivate ";
  protected final String TEXT_8 = " baseDao;" + NL + "\tpublic Map<String, Object> getList(DataGridModel dmg, String clazz," + NL + "\t\t\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ") throws Exception {" + NL + "" + NL + "\t\tMap<String, Object> result = new HashMap<String, Object>(2); " + NL + "\t\tLinkedList<ConditionParameter> conditionFields =  HSResolveObj.getConditionParameter(";
  protected final String TEXT_11 = ");" + NL + "" + NL + "\t\tList<";
  protected final String TEXT_12 = "> total = baseDao.listAll(clazz,conditionFields);" + NL + "\t\tSortParameter sortParameter = new SortParameter(dmg.getSort(),dmg.getOrder());" + NL + "\t\tLinkedList sortFields = new LinkedList();" + NL + "\t\tsortFields.add(sortParameter);" + NL + "\t\tSearchParameter  searchParameter= new SearchParameter(dmg.getPage(), clazz, dmg.getRows(), sortFields,conditionFields);" + NL + "\t\tList<";
  protected final String TEXT_13 = "> pageList = baseDao.listAll(searchParameter);" + NL + "\t\tresult.put(\"total\", total == null ? 0 : total.size());" + NL + "\t\tresult.put(\"rows\", pageList);" + NL + "\t\treturn result;" + NL + "\t" + NL + "\t}" + NL + "" + NL + "\tpublic void addOrUpdate(";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = ") throws Exception {" + NL + "\t\tbaseDao.saveOrUpdate(";
  protected final String TEXT_16 = ");" + NL + "" + NL + "\t}" + NL + "" + NL + "\tpublic void delete(List<Integer> financeIds) throws Exception {" + NL + "\t\tif(financeIds != null && financeIds.size() > 0) {" + NL + "\t\t\tfor(Integer id:financeIds){" + NL + "\t\t\t\tbaseDao.delById(";
  protected final String TEXT_17 = ".class, id);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_18 = NL + "\tpublic Userinfo getUserByName(String name)" + NL + "\t\t\tthrows Exception {" + NL + "\t\tString sql = \"FROM Userinfo WHERE userName = '\"+name+\"'\";" + NL + "\t\tUserinfo userInfo = (Userinfo) baseDao.loadObject(sql);" + NL + "\t\treturn userInfo;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_19 = NL + NL + NL + "}";
  protected final String TEXT_20 = NL;

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
	
	String entityClassName = args.getClassNameInfo().getEntityClassName();
	String daoClassName = args.getClassNameInfo().getDaoClassName();
	String serviceClassName = args.getClassNameInfo().getServicClassName();
	
	String entityObjectName = args.getClassNameInfo().getEntityObjectName();
	String daoObjectName = args.getClassNameInfo().getDaoObjectName();
	String serviceObjectName = args.getClassNameInfo().getServicObjectName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(args.getPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(daoPackageName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(daoClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(args.getPackageNameInfo().getEntityPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(args.getClassNameInfo().getEntityClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(args.getClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(daoClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_17);
     if("userinfo".equals(entityObjectName)) { 
    stringBuffer.append(TEXT_18);
     
	}
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
