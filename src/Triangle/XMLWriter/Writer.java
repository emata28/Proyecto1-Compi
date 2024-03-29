package Triangle.XMLWriter;

import Triangle.AbstractSyntaxTrees.Program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private final String fileName;
    private final String sourceName;

    public Writer(String sourceName,String fileName) {
        this.fileName = fileName;
        this.sourceName = sourceName;
    }// TODO

    // Draw the AST representing a complete program.
    public void write(Program ast) {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(this.sourceName.replace(".tri", ".xml"));

            //XML header
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");

            WriterVisitor layout = new WriterVisitor(fileWriter);
            ast.visit(layout, null);
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }

}
