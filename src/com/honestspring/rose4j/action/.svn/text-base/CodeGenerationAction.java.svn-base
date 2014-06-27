package com.honestspring.rose4j.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.honestspring.rose4j.wizard.CodeGenerationWizard;

public class CodeGenerationAction implements IObjectActionDelegate
{
	private Shell shell;
	private IStructuredSelection selection;

	public CodeGenerationAction()
	{
		super();
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();
	}

	@Override
	public void run(IAction action)
	{
		//打开向导对话框
		CodeGenerationWizard wizard = new CodeGenerationWizard();
		wizard.init(null, selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection)
	{
		this.selection = (IStructuredSelection)selection;
	}

}
