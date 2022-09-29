package assignment.a2;

public class Pizza {
    int kind;
    long time;
    long getTime() {
        return time;
    }
    int getKind() {
        return kind;
    }
    Pizza(int kind, long time) {
        this.kind = kind;
        this.time = time;
    }
}
