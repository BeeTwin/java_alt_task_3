package forms;

public interface Element {
    int getHeight();
    int getWidth();
    char[][] print(int y, int x, char[][] map);
    @Override
    String toString();
}
