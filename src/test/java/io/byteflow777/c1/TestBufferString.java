package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestBufferString {
    @Test
    public void testBufferString() {
        // 字符串转为字节数组
        ByteBuffer buffer1 = ByteBuffer.allocate(16);
        buffer1.put("hello".getBytes());
        // Charset
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        // warp
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());

        // ByteBuffer 转 String
        String s = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(s);
    }
}
