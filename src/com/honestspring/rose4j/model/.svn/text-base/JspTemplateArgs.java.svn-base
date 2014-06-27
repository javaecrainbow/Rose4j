package com.honestspring.rose4j.model;

public class JspTemplateArgs extends BaseTemplateArgs
{
	private String entityName;//实体名称
	private String jspName;//jsp名称
	private JspTemplateType type;//模板类型

	public String getModeName()
	{
		return getPackageNameInfo().getModeName();
	}

	public String getEntityName()
	{
		return entityName;
	}

	public void setEntityName(String entityName)
	{
		this.entityName = entityName;
	}

	public String getJspName()
	{
		switch (type)
		{
		case LIST:
			jspName = "list.jsp";
			break;
		case INPUT:
			jspName = "input.jsp";
			break;
		}
		return jspName;
	}

	public JspTemplateType getType()
	{
		return type;
	}

	public void setType(JspTemplateType type)
	{
		this.type = type;
	}

	public enum JspTemplateType
	{
		LIST, INPUT
	}
}
