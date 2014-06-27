package com.honestspring.rose4j.model;

/**
 * 
 * @author lijingjing
 *
 */
public class JavaTemplateArgs extends BaseTemplateArgs
{
	private String packageName;//包名
	private String className;//类名
	private JavaTemplateType type;//模板类型

	public String getModeName()
	{
		return getPackageNameInfo().getModeName();
	}

	public String getPackageName()
	{
		switch (type) 
		{
		case DAO:
			packageName = getPackageNameInfo().getDaoPackageName();
			break;
		case SERVICE:
			packageName = getPackageNameInfo().getServicPackageName();
			break;
		case ACTION:
			packageName = getPackageNameInfo().getActionPackageName();
			break;
		case AJAX:
			packageName = getPackageNameInfo().getAjaxPackageName();
		}
		return packageName;
	}

	public String getClassName()
	{
		switch (type)
		{
		case DAO:
			className = getClassNameInfo().getDaoClassName();
			break;
		case SERVICE:
			className = getClassNameInfo().getServicClassName();
			break;
		case ACTION:
			className = getClassNameInfo().getActionClassName();
			break;
		case AJAX:
			className = getClassNameInfo().getAjaxClassName();
		}
		return className;
	}

	public JavaTemplateType getType()
	{
		return type;
	}

	public void setType(JavaTemplateType type)
	{
		this.type = type;
	}

	public enum JavaTemplateType
	{
		DAO, SERVICE, ACTION,AJAX,BASEDAO
	}
}
