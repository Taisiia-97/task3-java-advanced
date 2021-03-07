package task14;


import java.io.IOException;

public final class MenuItem {
    private String label;
    private int number;
     Callback callback;

    public MenuItem(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public int getNumber() {
        return number;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void process() throws IOException {
        if (callback != null) {
            callback.action();
        }
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "label='" + label + '\'' +
                ", number=" + number +
                ", callback=" + callback +
                '}';
    }
}
