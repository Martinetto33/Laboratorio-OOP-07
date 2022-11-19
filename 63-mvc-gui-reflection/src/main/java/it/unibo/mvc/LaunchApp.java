package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import it.unibo.mvc.view.StdoutDrawNumberView;
import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) {
        // final var model = new DrawNumberImpl();
        // final DrawNumberController app = new DrawNumberControllerImpl(model);
        // app.addView(new StdoutDrawNumberView());
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberSwingView());
        /*Reflection Loading */
        Class <?> model;
        Class <?> app;
        Class <?> view1;
        Class <?> view2;
        Class <?> view3;
        try {
            model = Class.forName("DrawNumberImpl"); //usare Class<?> perché Class è un raw type
            Constructor<?> modelConstructor = model.getDeclaredConstructor(model.getClass());
            app = Class.forName("DrawNumberControllerImpl");
            view1 = Class.forName("StdoutDrawNumberView");
            view2 = Class.forName("DrawNumberSwingView");
            view3 = Class.forName("DrawNumberSwingView");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("No \"getDeclaredConstructor\" method was found!");
            System.exit(4);
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println("Security exception!");
            System.exit(5);
        }
    }
}
