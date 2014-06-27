package com.honestspring.rose4j.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.honestspring.rose4j.wizard.CatelogGenerationWizard;
import com.honestspring.rose4j.wizard.CodeGenerationWizard;

public class BusinessParaGenerationAction implements IObjectActionDelegate{
	private Shell shell;
	private IStructuredSelection selection;
	@Override
	public void run(IAction arg0) {
		CatelogGenerationWizard wizard = new CatelogGenerationWizard();
		wizard.init(null, selection);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
		
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
		this.selection = (IStructuredSelection)selection;
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
		
	}

}
