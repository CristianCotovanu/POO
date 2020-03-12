package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitors.DocumentVisitor;

public class PlainTextSegment extends TextSegment {
    public PlainTextSegment(String content) {
        super(content);
    }

    @Override
    public void acceptVisitor(DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
