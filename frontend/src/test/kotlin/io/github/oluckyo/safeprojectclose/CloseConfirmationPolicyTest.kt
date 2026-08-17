package io.github.oluckyo.safeprojectclose

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CloseConfirmationPolicyTest {
    @Test
    fun `last project uses the IDE default close flow`() {
        assertFalse(requiresCloseConfirmation(openProjectCount = 1))
    }

    @Test
    fun `closing while another project remains requires confirmation`() {
        assertTrue(requiresCloseConfirmation(openProjectCount = 2))
    }

    @Test
    fun `no open project does not require confirmation`() {
        assertFalse(requiresCloseConfirmation(openProjectCount = 0))
    }
}
