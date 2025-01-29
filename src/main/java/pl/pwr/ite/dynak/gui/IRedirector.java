package pl.pwr.ite.dynak.gui;

import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public interface IRedirector {
    default void redirectConsoleOutput(TextArea textArea) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                textArea.appendText(String.valueOf((char) b));
            }
        };
        PrintStream consoleStream = new PrintStream(out, true);
        System.setOut(consoleStream);
        System.setErr(consoleStream);
    }
}
