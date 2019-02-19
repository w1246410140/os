import java.util.Stack;

public class Process {//进程类
    static int num=0;//当前生成PCB的序号
    int ProID;//进程序号
    int ProState;//1为运行态，2为就绪态，3为等待态
    int instrucnum;//进程的指令数目
    Instruct instruc_list[];//进程包含的指令序列
    int PSW;//当前指令编号
    int intime;//进程创建时间
    int outtime;//进程销毁时间
    Stack stack;//线程绑定的栈，用来进行现场保护

    public static Process create(Os os,Task task){//进程创建原语
        Process process=new Process();
        process.ProID=num++;
        process.instrucnum=task.instrucnum;
        process.instruc_list=task.instruc_list;
        process.stack=new Stack();
        //分配内存
        process.ProState=2;//创建好的进程为就绪态
        os.q2.offer(process);//创建好的进程进入就绪队列
        return process;
    }

    public static void destroy(Os os,Process process){//进程撤销原语
            os.q4.offer(process);//将该进程放入已完成队列
    }

    public static void block(Os os,Process process){//进程阻塞原语
        os.q3.offer(process);//将该进程放入阻塞队列
    }

    public static void wake(){//进程唤醒原语

    }
}
