package com.honestspring.rose4j.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.operation.IRunnableWithProgress;

import com.honestspring.rose4j.model.PluginProject;
import com.honestspring.rose4j.model.ProjectBean;
import com.honestspring.rose4j.tools.Tools;

public class BuildEnvironmentTask implements IRunnableWithProgress {
	private ProjectBean project ;
	public BuildEnvironmentTask(ProjectBean project) {
		this.project = project;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		monitor.beginTask("搭建开发环境,请稍等......", 2);
		System.out.println("搭建开发环境,请稍等......");
		try
		{
			//第一步：向WebRoot中导入所需的文件
			monitor.worked(1);
			monitor.subTask("向" + project.getWebRootName() + "中导入所需的文件");
			System.out.println("向" + project.getWebRootName() + "中导入所需的文件");
			Tools.copyFileToProject(PluginProject.getWebRoot(), project.getWebRoot());
			//第二步：向classpath中导入所需的文件
			monitor.worked(1);
			monitor.subTask("向src中导入所需的文件");
			System.out.println("向src中导入所需的文件");
			copyFile(PluginProject.getSrc(), project.getSrc());
			copyUtilClass();
			Tools.copyFileToProject(PluginProject.getResources(), project.getResources());
		} catch (IOException e)
		{
			System.out.println(ExceptionUtils.getFullStackTrace(e));
		}

		monitor.done();
	
	}

	private void copyFile(String from,String target){
		File srcFile = new File(from);
		File[] files = srcFile.listFiles();
		File targetFile = new File(target);
		try{
		for(File file:files){
			FileUtils.copyFileToDirectory(file, targetFile);
		}
		}catch(Exception e){
			System.out.println(ExceptionUtils.getFullStackTrace(e));
		}
	}
	private void copyUtilClass(){
		try{
		IPackageFragmentRoot packageFragmentRoot = project.getJavaProject().findPackageFragmentRoot(new Path("/" + project.getName() + "/src"));
		IPackageFragment packageFragment = packageFragmentRoot.getPackageFragment("com.rose4j.util");
		if (!packageFragment.exists())
		{
			packageFragment = packageFragmentRoot.createPackageFragment("com.rose4j.util", true, null);
		}
		File srcFile = new File(PluginProject.getSrc()+"/util");
		File[] files = srcFile.listFiles();
		for(File file:files){
			packageFragment.createCompilationUnit(file.getName(), FileUtils.readFileToString(file), true, new NullProgressMonitor());
		}
		}catch(Exception e){
			System.out.println(ExceptionUtils.getFullStackTrace(e));
		}
	}
}
