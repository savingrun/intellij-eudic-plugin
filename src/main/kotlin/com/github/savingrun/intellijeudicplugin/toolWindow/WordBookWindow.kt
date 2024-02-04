package com.github.savingrun.intellijeudicplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MasterDetailsComponent.MyNode
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBRadioButton
import com.intellij.ui.components.JBTreeTable
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.treeStructure.treetable.TreeTableModel
import com.intellij.util.ui.ColumnInfo
import java.awt.BorderLayout
import javax.swing.JTree
import javax.swing.event.TreeModelListener
import javax.swing.tree.TreePath


/**
 * <p> WordBookWindow
 * <p> 2024.1.3
 *
 * @author <a href="https://github.com/savingrun">Saving</a>
 * @version 1.0
 **/
class WordBookWindow(project: Project, toolWindow: ToolWindow) : SimpleToolWindowPanel(false, false) {

    init {
        basis()
//        val testS = TestS(project, toolWindow)
//        setContent(testS)

        val content = ContentFactory.getInstance().createContent(getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    private fun basis() {
        val jbPanel = JBPanel<JBPanel<*>>()
        jbPanel.layout = BorderLayout()
        jbPanel.add(JBLabel("WordBookWindow Test 666"))
        setContent(jbPanel)
        jbPanel.isVisible = true
        val tableJbPanel = JBPanel<JBPanel<*>>()
        tableJbPanel.add(JBRadioButton("Sync"))
        jbPanel.add(tableJbPanel)
    }

}
