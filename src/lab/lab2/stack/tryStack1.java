package lab.lab2.stack;

class tryStack1 {

    public static void main(String[] args) {

        Integer[] arr = new Integer[50];

        for (int i = 0; i < 50; i++) {
            arr[i] = Integer.valueOf(i * 2);
        }

        printA(arr);
        arr = reverse(arr);
        printA(arr);
    }

    public static Integer[] reverse(Integer[] a) {
        ArrayStack S = new ArrayStack(a.length);
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++)
            S.push(a[i]);
        for (int i = 0; i < a.length; i++)
            b[i] = (Integer) (S.pop());
        return b;
    }

    public static void printA(Integer[] a) {
        System.out.println();
        for (int i = 0; i < 50; i++) {
            System.out.print(a[i].intValue() + "\t");
        }
        System.out.println();

    }
}


