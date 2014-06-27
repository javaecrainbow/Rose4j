package com.honestspring.rose4j.templates;

import com.honestspring.rose4j.model.*;

public class ServiceTemplate
{
  protected static String nl;
  public static synchronized ServiceTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ServiceTemplate result = new ServiceTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ";" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "import com.honestspring.util.DataGridModel;" + NL + "" + NL + "public interface ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\tMap<String,Object> getFinanceList(DataGridModel dmg,String clazz,";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = ") throws Exception;" + NL + "\tvoid addOrUpdateFinance(";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ") throws Exception;" + NL + "\tvoid deleteFinance(List<Integer> financeIds)throws Exception;" + NL + "}";
  protected final String TEXT_10 = NL;

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
    stringBuffer.append(args.getPackageNameInfo().getEntityPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(args.getClassNameInfo().getEntityClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(args.getClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
