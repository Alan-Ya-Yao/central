package com.example.grammer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 */
public class StringPractice {
    public static void main(String[] args) {
//        String tmp = "";
//        String[] ar = tmp.split(",");
//        System.out.println(ar[0]);


        List<String> ls = new ArrayList<>();
        ls.add("好你好");
        ls.add("很腻害");
        System.out.println(ls.toString());

        StringBuffer sb = new StringBuffer();
        sb.append("id : ").append("my id").append("\n");
        sb.append("name : ").append("my name").append("\n");
        sb.append("description : ").append("my desc");
        System.out.println(sb);

    }



    @Test
    public void modifiedString(){
        String s = "HEARTBEAT_RMC_riskmodelcentermix-99-6139";
        String modifedS = s.replaceAll("(HEARTBEAT_RMCMIX_|HEARTBEAT_RMC_)", "");
        System.out.println(modifedS);
    }

    @Test
    public void removeItemFromList(){
        String tmp = "BBCER00003943;BBCER00023491;BBCER00034591";
        String rex = "BBCER00034591;|BBCER00034591";
        tmp = tmp.replaceAll(rex, "");
        System.out.println(tmp);
    }

    @Test
    public void splitStringTest(){
        String tmp = ";BBCER00003943;BBCER00023491;BBCER00034591";

        String[] tmps = tmp.split(";");
        List<String> tmpsList = Arrays.asList(tmps);
        for(String ss : tmpsList){
            if(!ss.isEmpty()){
                System.out.println(ss);
            }
        }
    }
}
