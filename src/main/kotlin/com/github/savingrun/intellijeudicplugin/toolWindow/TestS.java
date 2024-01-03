package com.github.savingrun.intellijeudicplugin.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBLabel;

import javax.swing.*;

/**
 * <p> TestS
 * <p> 2024.1.2
 *
 * @author <a href="https://github.com/savingrun">Saving</a>
 * @version 1.0
 **/
public class TestS extends SimpleToolWindowPanel {

    private final Project project;
    private final ToolWindow toolWindow;

    private JPanel rootPanel;
    private JTable tableS;
    private JToolBar toolBarS;
    private JLabel title;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public TestS(Project project, ToolWindow toolWindow) {
        super(false, false);
        this.project = project;
        this.toolWindow = toolWindow;
        initUI();
    }

    private void initUI() {
        rootPanel.add(new JBLabel("initUI"));
    }

    public JTable getTableS() {
        return tableS;
    }

    public void setTableS(JTable tableS) {
        this.tableS = tableS;
    }

    public JToolBar getToolBarS() {
        return toolBarS;
    }

    public void setToolBarS(JToolBar toolBarS) {
        this.toolBarS = toolBarS;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
