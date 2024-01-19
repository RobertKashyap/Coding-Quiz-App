package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.exceptions.*;
import com.crio.codingame.services.IUserService;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    
    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute attendContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try {
            // Extract contestId and userName from tokens
            String contestId = tokens.get(1);
            String userName = tokens.get(2);

            // Call attendContest method of IUserService
            UserRegistrationDto result = userService.attendContest(contestId, userName);

            // Print the result
            System.out.println(result.toString());
        } catch (ContestNotFoundException e) {
            // Handle ContestNotFoundException
            System.out.println("Cannot Attend Contest. Contest for given id:" + tokens.get(1) + " not found!");
        } catch (UserNotFoundException e) {
            // Handle UserNotFoundException
            System.out.println("Cannot Attend Contest. User for given name:" + tokens.get(2) + " not found!");
        } catch (InvalidOperationException e) {
            // Handle InvalidOperationException
            System.out.println(e.getMessage());
        }
    }
    
}
