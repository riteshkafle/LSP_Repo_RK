package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * The VotingMachine class simulates an electronic voting machine.
 * It allows adding candidates, casting votes for existing candidates,
 * and determining the winner based on the votes cast.
 */
public class VotingMachine {
    
    // Map to store each candidate and their current vote count.
    private Map<String, Integer> votes = new HashMap<>();

    /**
     * Adds a candidate to the voting machine.
     *
     * @param candidateName the name of the candidate to add.
     */
    public void addCandidate(String candidateName) {
        // Only add candidate if not already added
        if (!votes.containsKey(candidateName)) {
            votes.put(candidateName, 0);
        }
    }
    
    /**
     * Casts a vote for the specified candidate.
     *
     * @param candidateName the name of the candidate to vote for.
     * @return true if the vote was successfully cast; false if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        if (votes.containsKey(candidateName)) {
            votes.put(candidateName, votes.get(candidateName) + 1);
            return true;
        }
        return false;
    }
    
    /**
     * Determines the winner of the election based on the votes.
     *
     * @return a formatted string showing the winning candidate and their vote count,
     *         e.g. "Charlie WINS with 3 votes!!". If no candidates exist, returns a message indicating so.
     */
    public String getWinner() {
        if (votes.isEmpty()) {
            return "No candidates available";
        }
        String winner = "";
        int maxVotes = -1;
        // Loop through candidates to find the one with the maximum votes.
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}