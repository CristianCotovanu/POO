package com.poo.labvisitor.task1.document;

import com.poo.labvisitor.task1.visitors.DocumentVisitor;

public class UrlSegment extends TextSegment {
    String url;
    String description;

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public UrlSegment(String url, String description) {
        super("Continut");
        this.url = url;
        this.description = description;
    }

    @Override
    public void acceptVisitor(DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }
}
