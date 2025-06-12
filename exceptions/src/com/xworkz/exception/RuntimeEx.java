
package com.xworkz.exception;

import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.MalformedParametersException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.concurrent.RejectedExecutionException;

import javax.print.attribute.UnmodifiableSetException;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.xml.ws.WebServiceException;

import java.security.ProviderException;

import java.util.IllformedLocaleException;


public class RuntimeEx {



    public void getArithmeticException() {
        throw new ArithmeticException();
    }

    public void getArrayStoreException() {
        throw new ArrayStoreException();
    }

    public void getBufferOverflowException() {
        throw new BufferOverflowException();
    }

    public void getBufferUnderflowException() {
        throw new BufferUnderflowException();
    }

    public void getCannotRedoException() {
        throw new CannotRedoException();
    }

    public void getCannotUndoException() {
        throw new CannotUndoException();
    }

    public void getClassCastException() {
        throw new ClassCastException();
    }




    public void getConcurrentModificationException() {
        throw new ConcurrentModificationException("Concurrent modification");
    }







    public void getEmptyStackException() {
        throw new EmptyStackException();
    }





    public void getFileSystemAlreadyExistsException() {
        throw new FileSystemAlreadyExistsException();
    }

    public void getFileSystemNotFoundException() {
        throw new FileSystemNotFoundException();
    }

    public void getIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    public void getIllegalMonitorStateException() {
        throw new IllegalMonitorStateException();
    }


    public void getIllegalStateException() {
        throw new IllegalStateException();
    }

    public void getIllformedLocaleException() {
        throw new IllformedLocaleException();
    }




    public void getIndexOutOfBoundsException() {
        throw new IndexOutOfBoundsException();
    }

    public void getJMRuntimeException() {
        throw new javax.management.JMRuntimeException();
    }



    public void getMalformedParameterizedTypeException() {
        throw new MalformedParameterizedTypeException();
    }

    public void getMalformedParametersException() {
        throw new MalformedParametersException();
    }



    public void getMissingResourceException() {
        throw new MissingResourceException("Missing resource", "SomeClass", "SomeKey");
    }

    public void getNegativeArraySizeException() {
        throw new NegativeArraySizeException("Negative size");
    }

    public void getNoSuchElementException() {
        throw new NoSuchElementException("No such element");
    }


    public void getNullPointerException() {
        throw new NullPointerException("Null pointer");
    }


    public void getProviderException() {
        throw new ProviderException("Provider exception");
    }





    public void getRejectedExecutionException() {
        throw new RejectedExecutionException();
    }

    public void getSecurityException() {
        throw new SecurityException();
    }


    public void getUnmodifiableSetException() {
        throw new UnmodifiableSetException();
    }

    public void getUnsupportedOperationException() {
        throw new UnsupportedOperationException();
    }

    public void getWebServiceException() {
        throw new WebServiceException();
    }

    public void getWrongMethodTypeException() {
        throw new WrongMethodTypeException();
    }
}
