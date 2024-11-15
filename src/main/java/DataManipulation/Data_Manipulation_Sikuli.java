package DataManipulation;



import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Data_Manipulation_Sikuli {

    public static final Screen screen = new Screen();

    public static void sortAndRemoveDuplicate()  {

            try {

                ArrayList<Pattern> images = new ArrayList<>(Arrays.asList(
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\downloads.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\excelIcon.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\joinDate.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\sort.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\sortAsc.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\DataTab.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\removeDuplicates.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\unSelect.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\Name.png"),
                        new Pattern("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\imgs\\Ok.png")
                ));

                openWindowsExplorer();

                for (int i = 0 ; i < images.size() ; i++)
                {
                    if(i == 1)
                    {
                        clickImage(images.get(i) , 5 , 2);
                    }
                    clickImage(images.get(i) , 5 , 1);
                }

            }catch (Exception e)
            {
                System.out.println(e.toString());
            }
        }

        public static void openWindowsExplorer() throws AWTException {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
        }

        public static void clickImage(Pattern img, int wait, int clicks) throws FindFailed {
            screen.wait(img , wait);

            if (clicks == 2) {
                screen.doubleClick(img);
            } else {
                screen.click(img);
            }
        }

}
