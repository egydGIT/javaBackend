package iostringwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWords {

    public void writeTo(List<String> longWords, Writer writer) {
        PrintWriter pw = new PrintWriter(writer);
        for (String w: longWords) {
            pw.print(w + ": ");
            pw.println(w.length());
        }
    }

    public String useMethod(List<String> longWords) {
        try (StringWriter stringWriter = new StringWriter()) {
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
