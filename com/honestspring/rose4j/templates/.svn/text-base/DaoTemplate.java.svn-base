package com.honestspring.rose4j.templates;

import com.honestspring.rose4j.model.*;

public class DaoTemplate
{
  protected static String nl;
  public static synchronized DaoTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    DaoTemplate result = new DaoTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "import org.springframework.stereotype.Repository;" + NL + "" + NL + "@Repository" + NL + "public class ";
  protected final String TEXT_3 = " extends BaseDAOImpl" + NL + "{" + NL + "}";
  protected final String TEXT_4 = NL;

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
    stringBuffer.append(args.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
