package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        try {
            // Extract parameters from tokens
            ScoreOrder scoreOrder = ScoreOrder.valueOf(tokens.get(1).toUpperCase());

            // Call getAllUserScoreOrderWise method of IUserService
            List<User> result = userService.getAllUserScoreOrderWise(scoreOrder);

            // Print the result
            System.out.println(result.toString());
        } catch (IllegalArgumentException e) {
            // Handle invalid ScoreOrder
            System.out.println("Invalid Score Order provided. Use 'ASC' or 'DESC'.");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("Error fetching leaderboard: " + e.getMessage());
        }
    }
    
}
