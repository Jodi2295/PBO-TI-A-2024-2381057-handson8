package config;

import repositories.TodoListRepository;
import repositories.TodoListRepositoryDblmpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("my_database", "root", "", "localhost", "3386");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDblmpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}
