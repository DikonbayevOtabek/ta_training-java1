package com.rpam.rd.autotasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try{
            riskyMethod();
        } catch (FileNotFoundException e){
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException ex){
            throw new IllegalArgumentException("Resource error", ex);
        } catch (ArithmeticException | NumberFormatException ex){
            System.err.println(ex.getMessage());
        }


    }
}
