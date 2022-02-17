package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResultBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players = new ArrayList<>();
    private String[] playerNames;

    public Players(String[] playerNames) {
        this.playerNames = playerNames;
        init();
    }

    private void init() {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public MatchResultBoard playMatch(Dealer dealer) {
        return new MatchResultBoard(players.stream()
            .collect(Collectors.toMap(player -> player, player -> player.getMatchResult(player, dealer))));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
