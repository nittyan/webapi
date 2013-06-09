package nittyan.hatena.keyword;

import android.util.Log;
import android.util.Xml;
import nittyan.search.Result;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class KeywordResult implements Result {

    private static final String TAG = "KeywordResult";
    public List<KeywordItem> items = new ArrayList<KeywordItem>();

    public KeywordResult(String response) {
        this.parseRSS(response);
    }

    private void parseRSS(String rss) {
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(new StringReader(rss));
            this.parseDocument(parser);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void parseDocument(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        KeywordItem item = null;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = "";
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    KeywordItem returnItem = this.checkTagContent(item, parser);
                    if (null != returnItem) {
                        item = returnItem;
                    }
                    this.checkTagContent(item, parser);

                    break;
                case XmlPullParser.END_TAG:
                    tagName = parser.getName();
                    if ("item".equals(tagName)) {
                        this.items.add(item);
                        item = null;
                    }
                    break;
                default:

            }
            eventType = parser.next();
        }
    }

    private KeywordItem checkTagContent(KeywordItem item, XmlPullParser parser) throws XmlPullParserException, IOException {
        String tagName = parser.getName();
        if ("item".equals(tagName)) {
            return new KeywordItem();
        }
        if (null == item) {
            return null;
        }

        if ("title".equals(tagName)) {
            item.title = parser.nextText();
        } else if ("link".equals(tagName)) {
            item.link = parser.nextText();
        } else if ("description".equals(tagName)) {
            item.description = parser.nextText();
        } else if ("subject".equals(tagName)) {
            item.subject = parser.nextText();
        } else if ("score".equals(tagName)) {
            item.score = Integer.parseInt(parser.nextText());
        } else if ("contentscore".equals(tagName)) {
            item.contentScore = Integer.parseInt(parser.nextText());
        } else if ("furigana".equals(tagName)) {
            item.furigana = parser.nextText();
        }

        return null;
    }

}
