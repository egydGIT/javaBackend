package iostringwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWords {

    public void writeTo(List<String> longWords, Writer writer) {
        try {
            for (String w: longWords) {
                writer.write(w);
                writer.write(" / ");
                writer.write(w.length());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("List is not found. ", e);
        }
    }

    public String useMethod(List<String> longWords) {
        StringWriter stringWriter = new StringWriter();
        try (stringWriter) {
            writeTo(longWords, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("List is not found. ", e);
        }
    }



    // solution

    public void writeLongWords(Writer writer, List<String> words){

        PrintWriter printWriter = new PrintWriter(writer);
        for(String s : words){
            printWriter.print(s);
            printWriter.print(":");
            printWriter.println(s.length());
        }
    }


    public String writeWithStringWriter(List<String> words){
        try(StringWriter sw = new StringWriter()){
            writeLongWords(sw,words);
            return sw.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write!",e);
        }
    }
}
