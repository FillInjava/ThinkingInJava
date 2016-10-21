package com.lg.stream;

import com.lg.utils.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by liuguo on 2016/10/21.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        String path = Directory.walk(".", "FormattedMemoryInput.java").files.get(0).getAbsolutePath();

       /* try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(path).getBytes()));
            while (true)
                System.out.println((char)in.readByte());
        } catch (EOFException e) {
            System.out.println("END OF THE FILE");
        }*/
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(path).getBytes()));
        while (in.available() != 0) {
            System.out.println((char) in.readByte());
        }

    }
}
