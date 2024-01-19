package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.*;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try {
            // Extract parameters from tokens
            String contestName = tokens.get(1);
            Level level = Level.valueOf(tokens.get(2).toUpperCase());
            String creator = tokens.get(3);

            // Check if the last token is an integer (number of questions) or null
            Integer numQuestions = null;
            if (tokens.size() > 4) {
                numQuestions = Integer.parseInt(tokens.get(4));
            }

            // Call create method of IContestService
            Contest result = contestService.create(contestName, level, creator, numQuestions);

            // Print the result
            System.out.println(result.toString());
        } catch (UserNotFoundException e) {
            // Handle UserNotFoundException
            System.out.println("Contest Creator for given name: " + tokens.get(3) + " not found!");
        } catch (QuestionNotFoundException e) {
            // Handle QuestionNotFoundException
            System.out.println("Request cannot be processed as enough number of questions can not found. Please try again later!");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("Error creating contest: " + e.getMessage());
        }
    }
    }
    