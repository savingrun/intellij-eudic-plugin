package com.github.savingrun.intellijeudicplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.JBColor
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.table.JBTable
import com.intellij.util.ui.JBUI
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.awt.BorderLayout
import java.awt.Color
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.DefaultTableModel


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
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url("https://api.frdic.com/api/open/v1/studylist/words/0?language=en")
//            .addHeader("Authorization", "xxxxxxx")
//            .build()
//        val response = client.newCall(request).execute()
//        val decodeFromString = Json.decodeFromString<EudicResponse>(response.body!!.string())
        val jsonStr = "{\"data\":[{\"word\":\"unfortunately for me\",\"exp\":\"\"},{\"word\":\"repository\",\"exp\":\"n. 仓库，贮藏室，存放处; 智囊，知识渊博的人，知识宝典\"},{\"word\":\"per\",\"exp\":\"prep. 〈拉〉通过, 由; 依照, 根据; 每<br><br>PERabbr. Phase Engineering Report 阶段工程报告\"},{\"word\":\"PRE\",\"exp\":\"abbr. Petroleum Refining Engineer 炼油工程师\"},{\"word\":\"direct\",\"exp\":\"adj. 直的, 笔直的, 径直的; 直接的, 直系的; 率直的, 坦率的, 坦白的; 恰好的, 完全的; adv. 径直地, 笔直地; 直接地, 亲自地; vt. 指示方向, 指引; 在…...\"},{\"word\":\"voucher\",\"exp\":\"n. 证人；保证人；证明者；收据<br>时 态:   vouchered, vouchering, vouchers  <br>\"},{\"word\":\"french\",\"exp\":\"adj. 法国的；法语的；法国人的; n. 法国人；法语<br><br><br>frenchv. 做法国菜；将肉排表面浅割或将荚菜豆切成纵条时 态:   frenched，frenching，frenc...\"},{\"word\":\"english\",\"exp\":\"adj. 英国人的；英国的；英文的; n. 英语；英国人；英文；英格兰人; vt. 把…译成英语；使旋转前进<br><br>时 态:   Englished, Englishing, English...\"}],\"message\":\"\"}"
        val decodeFromString = Json.decodeFromString<EudicResponse>(jsonStr)
        val jbPanel = JBPanel<JBPanel<*>>()
        jbPanel.layout = BorderLayout()
        jbPanel.isVisible = true
        setContent(jbPanel)
        val vocabularyList = mutableListOf<Vocabulary>()
        decodeFromString.data.forEach {
            vocabularyList.add(Vocabulary(it.word, it.exp))
        }
        val columnNames = arrayOf("单词", "释义")
        val rowData = vocabularyList.map { arrayOf(it.word, it.exp) }.toTypedArray()
        val tableModel = DefaultTableModel(rowData, columnNames)
        val table = JBTable(tableModel)
        table.showHorizontalLines = false
        table.showVerticalLines = false
        table.intercellSpacing = JBUI.emptySize()
        table.setDefaultRenderer(Any::class.java, AlternateRowRenderer())

        jbPanel.add(JBScrollPane(table))
    }

    @Serializable
    data class EudicResponse(
        val data: List<Vocabulary>,
        val message: String
    )

    @Serializable
    data class Vocabulary(
        val word: String,
        val exp: String
    )

    class AlternateRowRenderer : DefaultTableCellRenderer() {
        override fun getTableCellRendererComponent(
            table: JTable,
            value: Any?,
            isSelected: Boolean,
            hasFocus: Boolean,
            row: Int,
            column: Int
        ) = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column).apply {
            if (!isSelected) {
                background = if (row % 2 == 0) JBColor(Color(245, 248, 254), Color(77, 77, 77)) else JBColor.white
            }
        }
    }

}
