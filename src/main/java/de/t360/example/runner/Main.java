package de.t360.example.runner;

import de.t360.example.service.PlayerService;
import de.t360.example.service.PlayerServiceImpl;
import de.t360.example.service.ServerChatService;
import de.t360.example.service.ServerChatServiceImpl;
import de.t360.example.model.*;

import java.util.Arrays;

/**
 * this is the Main class to run the application
 * the configuration are:
 *   - 5: for one process solution
 *   - 7: for the Thraead solution
 */
public class Main {

    public static void one_process_solution() {

        ServerChatService serverChatService = new ServerChatServiceImpl();
        Player player1 = new Player("Timma");
        PlayerService service1 = new PlayerServiceImpl(serverChatService, player1);


        Player player2 = new Player("Dieudonne");
        PlayerService service2 = new PlayerServiceImpl(serverChatService, player2);
        String message = "Hallo";
        service1.send(message);
        for (int i = 0; i < 10; i++) {
            service2.receive();
            service2.send();
            service1.receive();
            if(!service2.is_Player_cache_full())
            service1.send();
        }
    }

    public static void many_thread_solution() {

        ServerChatService serverChatService = new ServerChatServiceImpl();
        Player player1 = new Player("Timma");
        PlayerService service1 = new PlayerServiceImpl(serverChatService, player1);


        Player player2 = new Player("Dieudonne");
        PlayerService service2 = new PlayerServiceImpl(serverChatService, player2);

        Thread player1Thread = new Thread(service1);
        Thread player2Thread = new Thread(service2);

        player1Thread.start();
        player2Thread.start();

        System.out.println("Process id of "+ player1.getName() + " " + player1Thread.getId());

        System.out.println("Process id of " + player2.getName() + " "  + player2Thread.getId());
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("-------------Start one process solution-------------------------");
            one_process_solution();

            System.out.println("-------------many thread solution-------------------------------");

            many_thread_solution();
        } else {
            boolean step5 = Arrays.stream(args).filter(t -> t.equals("5")).findFirst().isPresent();

            boolean step7 = Arrays.stream(args).filter(t -> t.equals("7")).findFirst().isPresent();

            if (step5) {
                one_process_solution();
            }

            if (step7) {
                many_thread_solution();
            }
        }


    }
}
