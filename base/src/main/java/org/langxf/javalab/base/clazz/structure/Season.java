package org.langxf.javalab.base.clazz.structure;

public enum Season {

    SPRING, WINTER;

    private int season;

    Season() {}

    Season(int season) {
        this.season = season;
    }

    public static void main(String[] args) {
        Season.values();
    }
}
