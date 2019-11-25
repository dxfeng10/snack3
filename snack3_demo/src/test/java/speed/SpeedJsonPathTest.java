package speed;

import org.junit.Test;
import org.noear.snack.ONode;


public class SpeedJsonPathTest {
    @Test
    public void test1(){
        //1.加载json
        ONode n = ONode.load("{code:1,msg:'Hello world',data:{list:[1,2,3,4,5], ary2:[{a:2},{a:3,b:{c:'ddd'}}]}}");
        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("$..a");
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }

    @Test
    public void test2(){
        //1.加载json
        ONode n = ONode.load("{code:1,msg:'Hello world',data:{list:[1,2,3,4,5], ary2:[{a:2},{a:3,b:{c:'ddd'}}]}}");
        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("data.list[2:4]");
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }

    @Test
    public void test3(){
        //1.加载json
        ONode n = ONode.load("{code:1,msg:'Hello world',data:{list:[1,2,3,4,5], ary2:[{a:2},{a:3,b:{c:'ddd'}}]}}");
        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("data.ary2[*].b.c");
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }

    @Test
    public void test4(){
        //1.加载json
        ONode n = ONode.load("[{b:{c:1}}, {b:{d:1}}, {b:{c:2}}, {b:{c:23}}]");
        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("$..b[?(@.c == 12)]");
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }

    @Test
    public void test5(){
        //1.加载json
        ONode n = ONode.load("{code:1,msg:'Hello world',data:{list:[1,2,3,4,5],b:2,ary2:[{a:2,b:8},{a:3,b:{c:'ddd',b:23}}]}}");

        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("$..b.min()");
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }

    @Test
    public void test6(){
        //1.加载json
        ONode n = ONode.load("[{c:'aaaa'}, {b:'cccc'}, {c:'cccaa'}]");

        long start = System.currentTimeMillis();
        for(int i=0,len=1000000; i<len; i++) {
            n.select("$[?(@.c =~ /a+/)]");//
        }

        long times = System.currentTimeMillis() - start;

        System.out.println(times);

        assert times > 0;
    }
}
