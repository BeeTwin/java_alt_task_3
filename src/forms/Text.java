package forms;

public class Text implements Element {
    public String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return text.length();
    }

    @Override
    public char[][] print(int y, int x, char[][] map) {
        char[] chrArr = text.toCharArray();

        for(int i = 0; i < chrArr.length; i++) {
            map[y][x + i] = chrArr[i];
        }

        return map;
    }

    @Override
    public String toString() {
        return text;
    }
}
