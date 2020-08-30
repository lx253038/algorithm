package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/8/19 20:08
 * @Description 切换垃圾收集器
 * -XX:+UseSerialGC         使用 Serial/SerialOld
 * -XX:+UseConcMarkSweepGC  使用 ParNew/CMS
 * -XX:+UseParallelGC       使用 Parallel Scavenge/Parallel Old
 * -XX:+UseG1GC             使用 G1/G1
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
