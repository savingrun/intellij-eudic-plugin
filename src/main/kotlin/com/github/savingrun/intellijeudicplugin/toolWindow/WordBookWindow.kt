package com.github.savingrun.intellijeudicplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import javax.swing.JPanel

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
        val content = ContentFactory.getInstance().createContent(getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    private fun basis() {
        val jbPanel = JBPanel<JBPanel<*>>()
        jbPanel.add(JBLabel("WordBookWindow Test 666"))
        setContent(jbPanel)
    }

}