import org.openqa.selenium.By;

/**
 * Created by hudi on 2017.04.19..
 */
class SimplePageTest{
    String url;
    By selector;
    String text;

    public By getSelector() {
        return selector;
    }

    public void setSelector(By selector) {
        this.selector = selector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    SimplePageTest(String url, By selector, String text){
        this.url = url;
        this.selector = selector;
        this.text = text;
    }
}
