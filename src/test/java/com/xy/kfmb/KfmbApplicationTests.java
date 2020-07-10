package com.xy.kfmb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfmbApplicationTests {

    @Test
    public void contextLoads() {
        String l = "zh_Ch";
        String[] split = l.split("_");
        for (String s : split) {
            System.out.println(s.toString());
        }
    }

    @Test
    public void demo() {

    }

}
