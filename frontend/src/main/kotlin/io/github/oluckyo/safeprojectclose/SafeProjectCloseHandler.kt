package io.github.oluckyo.safeprojectclose

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectCloseHandler
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages

/**
 * Asks before closing a project when another project will remain open.
 *
 * This extension belongs to the frontend module so the dialog is rendered locally by
 * JetBrains Client in Remote Development. Returning false vetoes the platform close.
 */
class SafeProjectCloseHandler : ProjectCloseHandler {
    override fun canClose(project: Project): Boolean {
        val openProjectCount = ProjectManager.getInstance().openProjects.size
        if (!requiresCloseConfirmation(openProjectCount)) {
            return true
        }

        return Messages.showOkCancelDialog(
            project,
            SafeProjectCloseBundle.message("dialog.message", project.name),
            SafeProjectCloseBundle.message("dialog.title"),
            SafeProjectCloseBundle.message("dialog.close"),
            SafeProjectCloseBundle.message("dialog.cancel"),
            Messages.getQuestionIcon(),
        ) == Messages.OK
    }
}

internal fun requiresCloseConfirmation(openProjectCount: Int): Boolean = openProjectCount > 1
