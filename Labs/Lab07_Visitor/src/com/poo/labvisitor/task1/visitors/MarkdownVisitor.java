package com.poo.labvisitor.task1.visitors;

import com.poo.labvisitor.task1.document.BoldTextSegment;
import com.poo.labvisitor.task1.document.ItalicTextSegment;
import com.poo.labvisitor.task1.document.PlainTextSegment;
import com.poo.labvisitor.task1.document.UrlSegment;

public class MarkdownVisitor implements DocumentVisitor {
    private StringBuilder document = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("*").append(italicTextSegment.getContent()).append("*");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[").append(urlSegment.getDescription()).append("]").append("(").append(urlSegment.getUrl()).append(")");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append(boldTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return document;
    }
}
