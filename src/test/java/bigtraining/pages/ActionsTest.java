package bigtraining.pages;

public class ActionsTest {

    public static final String tabName = "WebDriver | Actions";

    public static final String dropFromXpath = "//*[@id='draggable']";
    public static final String dropToXpath = "//*[@id='droppable']";
    public static final String doubleClickXpath = "//*[@id='double-click']";

    public static final String descendantXpath = "//descendant::a";

    public static final String hoverLeftXpath = "//*[@style='float:left;']";
    public static final String leftLinkXpath = hoverLeftXpath + descendantXpath;

    public static final String hoverCenterXpath = "//*[@style='float:center;']";
    public static final String centerLinkXpath = hoverCenterXpath + descendantXpath;

    public static final String hoverRightXpath = "//*[@style='float:right;']";
    public static final String rightLinksListXpath = hoverRightXpath + descendantXpath;

    public static final String clickAndHoldXpath = "//*[@id='click-box']";

    public static final String alertMessage = "Well done you clicked on the link!";

}
