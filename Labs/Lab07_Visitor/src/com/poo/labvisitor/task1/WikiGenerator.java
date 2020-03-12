package com.poo.labvisitor.task1;

import com.poo.labvisitor.task1.document.TextSegment;
import com.poo.labvisitor.task1.visitors.DokuWikiVisitor;
import com.poo.labvisitor.task1.visitors.MarkdownVisitor;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        DokuWikiVisitor dokuWikiVisitor = new DokuWikiVisitor();

        for (TextSegment textSegment : textSegments) {
            textSegment.acceptVisitor(dokuWikiVisitor);
        }
        return dokuWikiVisitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        MarkdownVisitor markdownVisitor = new MarkdownVisitor();

        for (TextSegment textSegment : textSegments) {
            textSegment.acceptVisitor(markdownVisitor);
        }
        return markdownVisitor.getDocument();
    }
}
