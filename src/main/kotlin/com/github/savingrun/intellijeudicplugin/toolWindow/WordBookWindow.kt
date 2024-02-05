package com.github.savingrun.intellijeudicplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBViewport
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.table.JBTable
import com.intellij.ui.table.TableView
import com.intellij.util.ui.ColumnInfo
import com.intellij.util.ui.ListTableModel
import com.intellij.util.xml.DomElement
import com.intellij.util.xml.ui.StringColumnInfo
import java.awt.BorderLayout
import javax.swing.JTable
import javax.swing.table.DefaultTableModel
import javax.swing.table.TableModel


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
        jbPanel.isVisible = true
        setContent(jbPanel)
        val vocabularyList = listOf(
            Vocabulary("Apple", "A fruit"),
            Vocabulary("Banana", "A fruit"),
            Vocabulary("Cat", "An animal")
        )

        val columnNames = arrayOf("单词", "释义")
        val rowData = vocabularyList.map { arrayOf(it.name, it.definition) }.toTypedArray()
        val tableModel = DefaultTableModel(rowData, columnNames)

        val table = JBTable(tableModel)


        jbPanel.add(JBScrollPane(table))
    }

    data class Vocabulary(
        val name: String,
        val definition: String
    )

}
