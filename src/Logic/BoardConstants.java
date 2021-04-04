package Logic;

public class BoardConstants
{
    public static final int SIZE = 7;
    public static final String BLUE  =  "\u001B[38;2;0;0;255m  blue  \u001B[0m";
    public static final String YELLOW = "\u001B[38;2;255;255;0m yellow \u001B[0m";
    public static final String RED =    "\u001B[38;2;255;0;0m  red   \u001B[0m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m orange \u001B[0m";
    public static final String PURPLE = "\u001B[38;2;128;0;128m purple \u001B[0m";
    public static final String GREEN =  "\u001B[38;2;0;255;0m green  \u001B[0m";
    public static final String EMPTY =  "        ";
    public static final String[] COLORS = new String[] {BLUE, YELLOW, RED, ORANGE, PURPLE, GREEN};
    public static final String[][] TEMPLATE = new String[][]
            {
                    {"        ","   21   ","   22   ","   23   ","   24   ","   25   ","   26   ","   27   ","        "},
                    {"   7    ","        ","        ","        ","        ","        ","        ","        ","   0    "},
                    {"   8    ","        ","        ","        ","        ","        ","        ","        ","   1    "},
                    {"   9    ","        ","        ","        ","        ","        ","        ","        ","   2    "},
                    {"   10   ","        ","        ","        ","        ","        ","        ","        ","   3    "},
                    {"   11   ","        ","        ","        ","        ","        ","        ","        ","   4    "},
                    {"   12   ","        ","        ","        ","        ","        ","        ","        ","   5    "},
                    {"   13   ","        ","        ","        ","        ","        ","        ","        ","   6    "},
                    {"        ","   14   ","   15   ","   16   ","   17   ","   18   ","   19   ","   20   ","        "},
            };
}