package com.github.savingrun.intellijeudicplugin.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.savingrun.intellijeudicplugin.MyBundle
import com.github.savingrun.intellijeudicplugin.services.MyProjectService
import com.intellij.notification.Notification
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidgetProvider
import com.intellij.ui.table.JBTable
import com.intellij.util.ui.table.JBListTable
import com.intellij.util.ui.table.JBListTableModel
import javax.swing.JButton
import javax.swing.JPanel


class MyToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
//        val myToolWindow = MyToolWindow(toolWindow)
        val testS = TestS()
        testS.title = JBLabel("This a Test Label 66")
        val content = ContentFactory.getInstance().createContent(testS.rootPanel, null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true



    class MyToolWindow(toolWindow: ToolWindow) {


        private val service = toolWindow.project.service<MyProjectService>()


        fun getContent() = JBPanel<JBPanel<*>>().apply {
            val label = JBLabel(MyBundle.message("randomLabel", "?"))
            thisLogger().info("saving")
            add(label)
            add(JBLabel("Hello world! Saving"))

            add(JButton(MyBundle.message("shuffle")).apply {
                addActionListener {
                    label.text = MyBundle.message("randomLabel", service.getRandomNumber())

                }
            })

        }

    }

}
