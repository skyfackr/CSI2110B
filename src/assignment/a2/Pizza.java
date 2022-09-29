package assignment.a2;

public class Pizza {
    int kind;
    int time;
    int getTime() {
        return time;
    }
    int getKind() {
        return kind;
    }
    Pizza(int kind, int time) {
        this.kind = kind;
        this.time = time;
    }
}
