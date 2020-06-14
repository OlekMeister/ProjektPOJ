package ProjektPOJ;

public class Main {

    public static void main(String[] args) {//główna funkcja wywołująca
	    Window window = Window.getWindow();

	    Thread thread = new Thread(window);
	    thread.start();
    }
}
