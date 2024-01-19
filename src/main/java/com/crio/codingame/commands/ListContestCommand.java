package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        try {
            // Extract parameters from tokens
            Level level = null;
            if (tokens.size() > 1) {
                level = Level.valueOf(tokens.get(1).toUpperCase());
            }

            // Call getAllContestLevelWise method of IContestService
            List<Contest> result = contestService.getAllContestLevelWise(level);

            // Print the result
            System.out.println(result.toString());
        } catch (IllegalArgumentException e) {
            // Handle invalid Level
            System.out.println("Invalid Level provided. Use 'HIGH', 'MEDIUM', or 'LOW'.");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("Error fetching contest list: " + e.getMessage());
        }
    }
    
}
