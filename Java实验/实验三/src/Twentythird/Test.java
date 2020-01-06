package Twentythird;

class PrintListener {
    boolean useOut;
    boolean printMost;
    public boolean needFix(){
        return isUseOut()&&isPrintMost();
    }

    public boolean isUseOut() {
        return useOut;
    }

    public void setUseOut(boolean useOut) {
        this.useOut = useOut;
    }

    public boolean isPrintMost() {
        return printMost;
    }

    public void setPrintMost(boolean printMost) {
        this.printMost = printMost;
    }
}
public class Test {
    public static void main(String[] args) {
        PrintListener printListener = new PrintListener();
        printListener.setUseOut(true);
        printListener.setPrintMost(false);
        System.out.println(printListener.needFix());
    }
}

