package com.charon.boot;

import com.alibaba.fastjson.JSON;
import com.charon.boot.model.Reader;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.sleep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {
        String str="[he]-[llo]-[charon]-[xiix]";
        String[] split = str.split("-");
        String[] nowStr=new String[split.length];
        for(int i=0 ;i<split.length;i++){
            nowStr[i]=split[i].substring(1,split[i].length()-1);
        }
        String sb="";
        for(int i=0 ;i<nowStr.length;i++){
            sb+="["+nowStr[i]+"]";
           if(i<nowStr.length-1){
               sb+="-";
           }
        }
        System.out.println(sb);
    }

}
