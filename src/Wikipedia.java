/*
A commented and tweaked example of using jsoup from https://github.com/jhy/jsoup/blob/master/src/main/java/org/jsoup/examples/Wikipedia.java
*/

// Import Jsoup library to parse HTML documents
import org.jsoup.Jsoup;

// Import classes to work with HTML document elements
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// Import CSS-style element selector class to select HTML elements
import org.jsoup.select.Elements;

// Import IOException class to handle input/output operations
import java.io.IOException;

public class Wikipedia {
    public static void main(String[] args) throws IOException {
        // Connects to Wikipedia's main page and retrieves the HTML content
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
            //doc variable of Document type
                // connects to url (wikipedia) with jsoup library
                    // get method retrieves HTML content from url

        // Logs the title of the retrieved page 
        log(doc.title());
            // calls the log method
                // retrieves title of HTML document stored in the doc

        //-- Selects elements with the class "mp-thumb" that are descendants/nested of an element with the id "mp-otd"
        //Elements newsHeadlines = doc.select("#mp-otd .mp-thumb a");
            // This selects thumbnail images linked to Wikipedia's "On this day" section

        //-- select all links under the Today's Feature Picture div
        // Elements newsHeadlines = doc.select("#mp-tfp * a");

        //-- selects only the bold links from "in the news" div
        Elements newsHeadlines = doc.select("#mp-itn b a");
        
        // Iterates over the selected elements (thumbnail images)
        for (Element headline : newsHeadlines) {
            // Logs the title attribute of the image (caption) and the absolute URL of the image
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    // Method to print/log messages to the console
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}



