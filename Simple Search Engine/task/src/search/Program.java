package search;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import static search.Display.*;
import static search.MenuRequest.*;
import static search.StrategyRequest.*;

public class Program {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final PersonService service;

    public Program(String file) throws IOException {
        service = new PersonService(file);
    }

    public void run() {
        MenuRequest menuRequest;

        do {
            displayMenu();
            menuRequest = getRequest(getNumberResponse());
            display(SPACER);

            processRequest(menuRequest);

        } while (menuRequest != EXIT);

        display(BYE);
    }

    private int getNumberResponse() {
        int input = SCANNER.nextInt();
        SCANNER.nextLine();

        return input;
    }

    private String getStringResponse() {
        return SCANNER.nextLine();
    }

    private void processRequest(MenuRequest menuRequest) {
        switch (menuRequest) {
            case FIND_A_PERSON:
                display(SELECT_MATCHING_STRATEGY);
                StrategyRequest strategyRequest = getStrategyRequest(getStringResponse());
                display(SPACER);

                if (strategyRequest == INVALID_STRATEGY) {
                    display(INCORRECT_STRATEGY);
                } else {
                    SearchMethod method = StrategyRequest.getMethod(strategyRequest);

                    display(ENTER_NAME_OR_EMAIL);
                    String query = getStringResponse();

                    processQuery(query, method);
                    display(SPACER);
                }

                break;
            case PRINT_ALL_PEOPLE:
                displayAllPeople(service.getPersonRepo());
                display(SPACER);
                break;
            case INVALID_REQUEST:
                display(INCORRECT_OPTION);
                break;
        }
    }

    private void processQuery(String query, SearchMethod method) {
            Set<Integer> indexes = service.findAll(query, method);

            if (indexes.isEmpty()){
                display(NO_MATCHES_FOUND);
            } else {
                display(SPACER);
                displayPeople(service.getPersonRepo(), indexes);
            }
    }
}
