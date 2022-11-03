package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if(words == null || sample == null){
            return 0;
        }
        if(words.length == 0 || sample.length() == 0){
            return 0;
        }
        int count = 0;
        sample = sample.trim();
        for (String word : words) {
            word = word.trim();
            if (word.toUpperCase().equals(sample.toUpperCase())) {
                ++count;
            }
        }
        return count;
    }


    public static String[] splitWords(String text) {
        if(text == null){
            return null;
        }
        if(text.length() == 0){
            return null;
        }
        String[] result = new String[text.length()];
        int star = 0, end = 0, num = 0;
        text = text.replace(',', ' ');
        text = text.replace('.', ' ');
        text = text.replace(';', ' ');
        text = text.replace(':', ' ');
        text = text.replace('?', ' ');
        text = text.replace('!', ' ');
        text = text.trim();
        int count = 0;
        for(int c = 0; c < text.length(); ++c){
            if(text.charAt(c) == ' '){
                ++count;
            }
        }
        if(count == text.length()){
            return null;
        }
        for (int i = 0; i < text.length(); ++i){
            if (text.charAt(i) == ' ' && i - 1 >= 0){
                if (text.charAt(i - 1) != ' '){
                    end = i;
                    if (end - star >= 1){
                        result[num] = text.substring(star, end);
                        ++num;
                    }
                    if(i + 1 < text.length() && text.charAt(i + 1) != ' '){
                        star = i + 1;
                    }
                }
                if (i + 1 < text.length() && text.charAt(i + 1) != ' ') {
                    star = i + 1;
                    if (end - star >= 1){
                        result[num] = text.substring(star, end);
                        ++num;
                    }
                }
            }
            if(i == text.length() - 1){
                end = i + 1;
                if (end - star >= 1){
                    result[num] = text.substring(star, end);
                    ++num;
                }
            }
        }
        String [] results = new String[num];
        for (int k = 0; k < result.length; ++k){
            if (result[k] != null){
                results[k] = result[k];
            }
        }
        return results;
    }

    public static String convertPath(String path, boolean toWin) {
        int num1 = 0, num2 = 0, num3 = 0;
        String result = "";
        if (path == null || path.length() == 0){
            return null;
        }
        for (int i = 0; i < path.length(); ++i){
            if(path.charAt(i) == '/'){
                ++num3;
            }
            if(path.charAt(i) == '~'){
                ++num1;
                if(i != 0){
                    return null;
                }
                if(num1 == 2){
                    return null;
                }
            }
            if(path.charAt(i) == 'C' && path.charAt(i +1) == ':' && i + 1 < path.length()){
                ++num2;
                if(i != 0){
                    return null;
                }
                if(num2 == 2){
                    return null;
                }
            }
            if(num1 >= 1 && path.charAt(i) == '\\'){
                return null;
            }
            if(num2 >= 1 && path.charAt(i) == '/'){
                return null;
            }
            if(num3 >= 1 && path.charAt(i) == '\\'){
                return null;
            }
        }

        int flag1 = 0;
        if(!toWin){
            for (int i = 0; i < path.length(); ++i){
                if (path.charAt(i) == 'C' && path.charAt(i + 1) == ':'){
                    if(path.length() >= 7 && path.substring(0, 7).equals("C:\\User")){
                        if(path.length() == 8){
                            result += "~/";
                            return result;
                        }else{
                            result += '~';
                            i = 6;
                        }
                    }else{
                        ++i;
                    }
                } else if (path.charAt(i) == '\\') {
                    result += '/';
                }else{
                    result += path.charAt(i);
                }
            }
        }else{
            for (int i = 0; i < path.length(); ++i){
                if (path.charAt(i) == '~'){
                    result += "C:\\User";
                } else if (path.charAt(i) == '/') {
                    flag1 = 1;
                    result += '\\';
                }else{
                    result += path.charAt(i);
                }
            }
            if(result.charAt(0) != 'C' && flag1 == 1 && result.charAt(0) != '.' && result.charAt(0) != 'd'){
                result = "C:" + result;
            }
        }
        return result;
    }

    public static String joinWords(String[] words) {
        if(words == null || words.length == 0) {
            return null;
        }
        int count = 0, k = 0;
        for (String word : words) {
            if (word.length() == 0) {
                ++count;
            }
        }
        if(count == words.length){
            return null;
        }
        String[] result = new String[words.length - count];
        for (String word : words) {
            if (word.length() != 0) {
                result[k] = word;
                ++k;
            }
        }
        String res = String.join(", ", result);
        res = "[" + res + "]";
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}