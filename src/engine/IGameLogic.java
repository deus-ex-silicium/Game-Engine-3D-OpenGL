package engine;

public interface IGameLogic {

    void init(Window window) throws Exception;

    void input(Window window, MouseInput mouseInput) throws Exception;

    void update(float interval, MouseInput mouseInput);

    void render(Window window);

    void cleanup();
}
