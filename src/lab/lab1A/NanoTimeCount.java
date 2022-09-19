package lab.lab1A;

public class NanoTimeCount {
    long start;
    long end;
    public NanoTimeCount(){
        this.start=System.nanoTime();
    }
    public void end(){
        this.end=System.nanoTime();
    }
    public long endAndReturn(){
        this.end();
        return this.getTime();
    }
    public long getStart(){
        return this.start;
    }
    public long getEnd(){
        return this.end;
    }
    public long getTime(){
        return this.end-this.start;
    }
    public void reset(){
        this.start=System.nanoTime();
    }
}
