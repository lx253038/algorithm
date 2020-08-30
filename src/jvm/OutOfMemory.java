package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/8/19 20:08
 * @Description �л������ռ���
 * -XX:+UseSerialGC         ʹ�� Serial/SerialOld
 * -XX:+UseConcMarkSweepGC  ʹ�� ParNew/CMS
 * -XX:+UseParallelGC       ʹ�� Parallel Scavenge/Parallel Old
 * -XX:+UseG1GC             ʹ�� G1/G1
 */
public class OutOfMemory {
    static byte[] bytes = new byte[1024 * 1024];

    public static void main(String[] args) {
        List<OutOfMemory> list = new ArrayList<>();
        while (true) {
            list.add(new OutOfMemory());
        }
    }
}
