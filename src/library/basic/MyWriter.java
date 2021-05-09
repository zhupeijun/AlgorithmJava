package library.basic;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class MyWriter extends PrintWriter {
    public MyWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            print(a[i]);
            print(i == a.length - 1 ? '\n' : ' ');
        }
    }

    public void printArray(long[] a) {
        for (int i = 0; i < a.length; ++i) {
            print(a[i]);
            print(i == a.length - 1 ? '\n' : ' ');
        }
    }

    public void println(int[] a) {
        for (int v : a) {
            println(v);
        }
    }

    public void println(long[] a) {
        for (long v : a) {
            println(v);
        }
    }

    public <T> void print(List<T> list) {
        for (int i = 0; i < list.size(); ++i) {
            print(list.get(i));
            print(i == list.size() - 1 ? '\n' : ' ');
        }
    }

    public <T> void println(List<T> list) {
        list.forEach(this::println);
    }
}