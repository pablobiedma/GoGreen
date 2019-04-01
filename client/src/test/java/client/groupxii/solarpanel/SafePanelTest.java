package client.groupxii.solarpanel;


import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class SafePanelTest {
    private SafePanel safePanel = new SafePanel();

    @Test
    public void safePanel() throws IOException {
        assertTrue(safePanel.safePanel("Hello", 50).contains("Hello"));

    }
}
