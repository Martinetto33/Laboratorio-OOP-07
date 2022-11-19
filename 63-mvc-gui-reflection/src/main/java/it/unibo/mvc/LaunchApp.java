package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import it.unibo.mvc.view.StdoutDrawNumberView;
import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    public static void main(final String... args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        /*Le successive tre righe si riferiscono al codice che non usa la reflection. */
        // app.addView(new StdoutDrawNumberView());
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberSwingView());
        final Class<?> view1Class = StdoutDrawNumberView.class;
        final Class<?> view2Class = DrawNumberSwingView.class;
        try {
            Constructor<?> view1Constructor = view1Class.getDeclaredConstructor();
            Constructor<?> view2Constructor = view2Class.getDeclaredConstructor();
            app.addView((DrawNumberView) view1Constructor.newInstance());
            app.addView((DrawNumberView) view2Constructor.newInstance());
            app.addView((DrawNumberView) view2Constructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
