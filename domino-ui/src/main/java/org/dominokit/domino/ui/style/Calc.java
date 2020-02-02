package org.dominokit.domino.ui.style;

public class Calc {

    public static String sub(String left, String right){
        return "calc("+left+" - "+right+")";
    }

    public static String sum(String left, String right){
        return "calc("+left+" + "+right+")";
    }
}
