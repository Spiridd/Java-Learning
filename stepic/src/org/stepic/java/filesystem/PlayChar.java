package org.stepic.java.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dimon on 28.08.17.
 */
public class PlayChar {
    public static void main(String[] args) throws IOException {
        //System.out.println(Charset.defaultCharset());
        //OutputStream outputStream = Files.newOutputStream(Paths.get("seeme.txt"));
        //Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write('a');
        writer.write(10);
        writer.write('Ы');
        writer.close();
    }
}
