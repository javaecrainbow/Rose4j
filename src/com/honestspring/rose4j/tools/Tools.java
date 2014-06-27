package com.honestspring.rose4j.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.honestspring.rose4j.model.ClassNameInfo;
import com.honestspring.rose4j.model.EntityFieldInfo;
import com.honestspring.rose4j.model.JavaTemplateArgs;
import com.honestspring.rose4j.model.JspTemplateArgs;
import com.honestspring.rose4j.model.PackageNameInfo;
import com.honestspring.rose4j.model.JavaTemplateArgs.JavaTemplateType;
import com.honestspring.rose4j.model.JspTemplateArgs.JspTemplateType;

/**
 * 工具类
 * @author yangzhibin
 *
 */
@SuppressWarnings("restriction")
public class Tools
{
	/**
	 * 拷贝文件到项目中（用于搭建开发环境）
	 */
	public static void copyFileToProject(String source, String target) throws IOException
	{
		File sourceFile = new File(source);
		File targetFile = new File(target);

		if (sourceFile.isDirectory())
		{
			File[] files = sourceFile.listFiles();
			for (File file : files)
			{
				if (file.isDirectory())
				{
					FileUtils.copyDirectoryToDirectory(file, targetFile);
				} else
				{
					FileUtils.copyFileToDirectory(file, targetFile, true);
				}
			}
		} else
		{
			FileUtils.copyFileToDirectory(sourceFile, targetFile, true);
		}

	}

	/**
	 * 创建文件夹（用于jsp代码生成）
	 * @param path
	 */
	public static void createDirectory(String path)
	{
		File file = new File(path);
		//如果文件夹存在，则删除
		if (file.exists())
		{
			file.delete();
		}
		file.mkdirs();
	}

	/**
	 * 创建文件（用于jsp代码生成）
	 * @param path
	 * @return
	 */
	public static void createFile(String path)
	{
		File file = new File(path);
		if (file.exists())
		{
			file.delete();
		}
		try
		{
			file.createNewFile();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 往文件中写入字符串（用于jsp代码生成）
	 * @param filePath
	 * @param content
	 */
	public static void writeStringToFile(String filePath, String content)
	{
		File file = new File(filePath);
		try
		{
			FileUtils.writeStringToFile(file, content, "utf-8");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private static List<EntityFieldInfo> scanEntityField(ICompilationUnit compilationUnit)
	{
		List<EntityFieldInfo> entityFieldVos = new ArrayList<EntityFieldInfo>();
		//分析实体类的字段
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(compilationUnit);//设置资源
		parser.setResolveBindings(true);// 后面需要绑定
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		List types = cu.types();
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		FieldDeclaration[] fieldDecs = typeDec.getFields();

		for (FieldDeclaration fieldDec : fieldDecs)
		{
			EntityFieldInfo entityFieldVo = new EntityFieldInfo();
			//字段类型
			entityFieldVo.setFieldType(fieldDec.getType().toString());
			for (Object fragment : fieldDec.fragments())
			{
				VariableDeclarationFragment frag = (VariableDeclarationFragment) fragment;
				//字段名称
				entityFieldVo.addFieldName(frag.getName().toString());
			}
			entityFieldVos.add(entityFieldVo);
		}
		return entityFieldVos;
	}

	/**
	 * 生成java代码生成值对象
	 * @param selection
	 * @return
	 * @throws Exception 
	 */
	public static List<JavaTemplateArgs> createJavaTemplateArgsList(IStructuredSelection selection) throws Exception
	{
		List<JavaTemplateArgs> javaTemplateArgsList = new ArrayList<JavaTemplateArgs>();

		Object obj = selection.getFirstElement();
		if (obj instanceof PackageFragment)
		{
			PackageFragment packageFragment = (PackageFragment) obj;
			//获取包名对象
			PackageNameInfo packageNameInfo = new PackageNameInfo(packageFragment);
			ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
			//遍历实体类
			for (ICompilationUnit compilationUnit : compilationUnits)
			{
				//获取各个层的类名
				ClassNameInfo classNameInfo = new ClassNameInfo(compilationUnit);
				//获取实体类属性
				//List<EntityFieldInfo> entityFieldInfoList = scanEntityField(compilationUnit);
				//-------------------------------dao-------------------------------
				JavaTemplateArgs daoTemplateArgs = new JavaTemplateArgs();
				daoTemplateArgs.setPackageNameInfo(packageNameInfo);
				daoTemplateArgs.setClassNameInfo(classNameInfo);
				//daoTemplateArgs.setEntityFieldInfoList(entityFieldInfoList);
				daoTemplateArgs.setType(JavaTemplateType.DAO);
				javaTemplateArgsList.add(daoTemplateArgs);
				//-------------------------------service-------------------------------
				JavaTemplateArgs serviceTemplateArgs = new JavaTemplateArgs();
				serviceTemplateArgs.setPackageNameInfo(packageNameInfo);
				serviceTemplateArgs.setClassNameInfo(classNameInfo);
				//serviceTemplateArgs.setEntityFieldInfoList(entityFieldInfoList);
				serviceTemplateArgs.setType(JavaTemplateType.SERVICE);
				javaTemplateArgsList.add(serviceTemplateArgs);
				//-------------------------------action-------------------------------
				JavaTemplateArgs actionTemplateArgs = new JavaTemplateArgs();
				actionTemplateArgs.setPackageNameInfo(packageNameInfo);
				actionTemplateArgs.setClassNameInfo(classNameInfo);
				//actionTemplateArgs.setEntityFieldInfoList(entityFieldInfoList);
				actionTemplateArgs.setType(JavaTemplateType.ACTION);
				javaTemplateArgsList.add(actionTemplateArgs);
			}
		}
		return javaTemplateArgsList;
	}

	/**
	 * 生成jsp代码生成值对象
	 * @param selection
	 * @return
	 * @throws Exception 
	 */
	public static List<JspTemplateArgs> createJspTemplateArgsList(IStructuredSelection selection) throws Exception
	{
		List<JspTemplateArgs> jspTemplateArgsList = new ArrayList<JspTemplateArgs>();

		Object obj = selection.getFirstElement();
		if (obj instanceof PackageFragment)
		{
			PackageFragment packageFragment = (PackageFragment) obj;
			//获取包名对象
			PackageNameInfo packageNameInfo = new PackageNameInfo(packageFragment);
			ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
			//遍历实体类
			for (ICompilationUnit compilationUnit : compilationUnits)
			{
				//获取各个层的类名
				ClassNameInfo classNameInfo = new ClassNameInfo(compilationUnit);
				//获取实体类属性
				//List<EntityFieldInfo> entityFieldInfoList = scanEntityField(compilationUnit);
				//-------------------------------list-------------------------------
				JspTemplateArgs JspListTemplateArgs = new JspTemplateArgs();
				JspListTemplateArgs.setPackageNameInfo(packageNameInfo);
				JspListTemplateArgs.setClassNameInfo(classNameInfo);
				//JspListTemplateArgs.setEntityFieldInfoList(entityFieldInfoList);
				JspListTemplateArgs.setType(JspTemplateType.LIST);
				jspTemplateArgsList.add(JspListTemplateArgs);
				//-------------------------------input-------------------------------
				JspTemplateArgs JspInputTemplateArgs = new JspTemplateArgs();
				JspInputTemplateArgs.setPackageNameInfo(packageNameInfo);
				JspInputTemplateArgs.setClassNameInfo(classNameInfo);
				//JspInputTemplateArgs.setEntityFieldInfoList(entityFieldInfoList);
				JspInputTemplateArgs.setType(JspTemplateType.INPUT);
				jspTemplateArgsList.add(JspInputTemplateArgs);
			}
		}
		return jspTemplateArgsList;
	}

}
