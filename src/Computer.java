public class Computer {
    private Clock clock;
    private CPU cpu;
}

class CPU{//CPU类
    private short addbus;//16位地址线
    private short databus;//16位数据线
}

class Clock{//时钟类
    private int time;//记录系统时间，以毫秒为单位

    Clock(){
        time=0;//系统时间初始为0
    }

    public void clockstart()throws InterruptedException{//每隔10毫秒系统时间加10
        for(;;) {
            Thread.sleep(10);
            time += 10;
        }
    }

    public int gettime(){
        return time;
    }
}

class MMU{

}

class Memory{

}

class Disk{

}
