package com.poo.labvisitor.task1.visitors;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public class DokuWikiVisitor implements DocumentVisitor {
    private StringBuilder document = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("**").append(italicTextSegment.getContent()).append("**");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[[").append(urlSegment.getUrl()).append("|").append(urlSegment.getDescription()).append("]]");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("**").append(boldTextSegment.getContent()).append("**");
    }

    @Override
    public StringBuilder getDocument() {
        return document;
    }
}
