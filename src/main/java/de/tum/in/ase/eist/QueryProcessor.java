package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Rafael";
        } else if (query.contains("which of the following numbers is the largest")){ // TODO extend the programm here
            String s = query.substring(query.indexOf("which"),query.length()-1);
            String sub = query.substring(query.indexOf(':'),query.length()-1);
            String filter = sub.replaceAll(" ","");
            String[] x = filter.split(",");
            int[] b = new int[x.length];
            for (int i = 0; i < x.length; i++) {
                b[i] = Integer.parseInt(x[i]);
            }
            if(b.length == 0){
                return "";
            }
            int max = b[0];
            for (int i = 0; i < b.length; i++) {
                if (b[i] > max){
                    max = b[i];
                }
            }
            return Integer.toString(max);
        }else if(query.contains("what is") && query.contains("plus")){
            String s = query.substring(query.indexOf("what"),query.length()-1);
            String sub = s.replaceAll("is ", "");
            sub = sub.replaceAll("plus", ",");
            sub = sub.replaceAll(" ", "");
            String[] a = sub.split(",");
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }
            int res = 0;
            for (int i = 0; i < b.length; i++) {
                res += b[i];
            }
            return Integer.toString(res);
        }else {
            return "";
        }
    }
}
